package com.sleepycat.je.log;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.zip.Checksum;
import com.sleepycat.je.DatabaseException;
//#if STATISTICS
import com.sleepycat.je.EnvironmentStats;
//#endif
import com.sleepycat.je.RunRecoveryException;
//#if STATISTICS
import com.sleepycat.je.StatsConfig;
//#endif
import com.sleepycat.je.config.EnvironmentParams;
import com.sleepycat.je.dbi.DbConfigManager;
import com.sleepycat.je.dbi.EnvironmentImpl;
//#if LATCHES
import com.sleepycat.je.latch.Latch;
//#endif
//#if LATCHES
import com.sleepycat.je.latch.LatchSupport;
//#endif
import com.sleepycat.je.log.entry.LogEntry;
import com.sleepycat.je.utilint.Adler32;
import com.sleepycat.je.utilint.DbLsn;
import com.sleepycat.je.utilint.HexFormatter;

/**
 * The FileManager presents the abstraction of one contiguous file. It doles out
 * LSNs.
 */
public class FileManager {
	public static class FileMode {
		public static final FileMode READ_MODE = new FileMode("r");
		public static final FileMode READWRITE_MODE = new FileMode("rw");
		private String fileModeValue;

		private FileMode(String fileModeValue) {
			this.fileModeValue = fileModeValue;
		}

		public String getModeValue() {
			return fileModeValue;
		}
	}

	static boolean IO_EXCEPTION_TESTING = false;
	private static final String DEBUG_NAME = FileManager.class.getName();
	private static long writeCount = 0;
	private static long stopOnWriteCount = Long.MAX_VALUE;
	public static final String JE_SUFFIX = ".jdb";
	public static final String CIF_SUFFIX = ".cif";
	public static final String DEL_SUFFIX = ".del";
	public static final String BAD_SUFFIX = ".bad";
	public static final String LOCK_SUFFIX = ".lck";
	static final String[] DEL_SUFFIXES = { DEL_SUFFIX };
	static final String[] JE_SUFFIXES = { JE_SUFFIX };
	private static final String[] JE_AND_DEL_SUFFIXES = { JE_SUFFIX, DEL_SUFFIX };
	private boolean syncAtFileEnd = true;
	private EnvironmentImpl envImpl;
	private long maxFileSize;
	private File dbEnvHome;
	private boolean includeDeletedFiles = false;
	// #if FILEHANDLECACHE
	private FileCache fileCache;
	// #endif
	// #if FILEHANDLECACHE
	// #if LATCHES
	private Latch fileCacheLatch;
	// #endif
	// #endif
	// #if ENVIRONMENTLOCKING
	private RandomAccessFile lockFile;
	// #endif
	// #if ENVIRONMENTLOCKING
	private FileChannel channel;
	// #endif
	// #if ENVIRONMENTLOCKING
	private FileLock envLock;
	// #endif
	// #if ENVIRONMENTLOCKING
	private FileLock exclLock;
	// #endif
	private boolean readOnly;
	private long currentFileNum;
	private long nextAvailableLsn;
	private long lastUsedLsn;
	private long prevOffset;
	private boolean forceNewFile;
	private long savedCurrentFileNum;
	private long savedNextAvailableLsn;
	private long savedLastUsedLsn;
	private long savedPrevOffset;
	private boolean savedForceNewFile;
	private LogEndFileDescriptor endOfLog;
	// #if FSYNC
	private FSyncManager syncManager;
	// #endif
	private Map perFileLastUsedLsn;
	private long chunkedNIOSize = 0;
	
	/**
	 * Set up the file cache and initialize the file manager to point to the
	 * beginning of the log.
	 * 
	 * @param configManager
	 * @param dbEnvHomeenvironment
	 *            home directory
	 */
	public FileManager(EnvironmentImpl envImpl, File dbEnvHome, boolean readOnly)
			throws DatabaseException {
		this.envImpl = envImpl;
		this.dbEnvHome = dbEnvHome;
		this.readOnly = readOnly;
		DbConfigManager configManager = envImpl.getConfigManager();
		maxFileSize = configManager.getLong(EnvironmentParams.LOG_FILE_MAX);
		// #if CHUNKEDNIO
		chunkedNIOSize = configManager
				.getLong(EnvironmentParams.LOG_CHUNKED_NIO);
		// #endif
		// #if ENVIRONMENTLOCKING
		lockEnvironment(readOnly, false);
		// #endif
		// #if FILEHANDLECACHE
		fileCache = new FileCache(configManager);
		// #if LATCHES
		fileCacheLatch = LatchSupport.makeLatch(DEBUG_NAME + "_fileCache",
				envImpl);
		// #endif
		// #endif
		if (!dbEnvHome.exists()) {
			throw new LogException("Environment home " + dbEnvHome
					+ " doesn't exist");
		}
		currentFileNum = 0L;
		nextAvailableLsn = DbLsn.makeLsn(currentFileNum, firstLogEntryOffset());
		lastUsedLsn = DbLsn.NULL_LSN;
		perFileLastUsedLsn = new HashMap();
		prevOffset = 0L;
		endOfLog = new LogEndFileDescriptor();
		forceNewFile = false;
		saveLastPosition();
		String stopOnWriteProp = System.getProperty("je.debug.stopOnWrite");
		if (stopOnWriteProp != null) {
			stopOnWriteCount = Long.parseLong(stopOnWriteProp);
		}
		// #if FSYNC
		syncManager = new FSyncManager(envImpl);
		// #endif
	}

	/**
	 * Set the file manager's "end of log".
	 * 
	 * @param nextAvailableLsnLSN
	 *            to be used for the next log entry
	 * @param lastUsedLsnlast
	 *            LSN to have a valid entry, may be null
	 * @param prevOffsetvalue
	 *            to use for the prevOffset of the next entry. If the beginning
	 *            of the file, this is 0.
	 */
	public void setLastPosition(long nextAvailableLsn, long lastUsedLsn,
			long prevOffset) {
		this.lastUsedLsn = lastUsedLsn;
		perFileLastUsedLsn.put(new Long(DbLsn.getFileNumber(lastUsedLsn)),
				new Long(lastUsedLsn));
		this.nextAvailableLsn = nextAvailableLsn;
		currentFileNum = DbLsn.getFileNumber(this.nextAvailableLsn);
		this.prevOffset = prevOffset;
		saveLastPosition();
	}

	void saveLastPosition() {
		savedNextAvailableLsn = nextAvailableLsn;
		savedLastUsedLsn = lastUsedLsn;
		savedPrevOffset = prevOffset;
		savedForceNewFile = forceNewFile;
		savedCurrentFileNum = currentFileNum;
	}

	void restoreLastPosition() {
		nextAvailableLsn = savedNextAvailableLsn;
		lastUsedLsn = savedLastUsedLsn;
		prevOffset = savedPrevOffset;
		forceNewFile = savedForceNewFile;
		currentFileNum = savedCurrentFileNum;
	}

	/**
	 * May be used to disable sync at file end to speed unit tests. Must only be
	 * used for unit testing, since log corruption may result.
	 */
	public void setSyncAtFileEnd(boolean sync) {
		syncAtFileEnd = sync;
	}

	/**
	 * public for cleaner.
	 * 
	 * @return the number of the first file in this environment.
	 */
	public Long getFirstFileNum() {
		return getFileNum(true);
	}

	public boolean getReadOnly() {
		return readOnly;
	}

	/**
	 * @return the number of the last file in this environment.
	 */
	public Long getLastFileNum() {
		return getFileNum(false);
	}

	public long getCurrentFileNum() {
		return currentFileNum;
	}

	public void setIncludeDeletedFiles(boolean includeDeletedFiles) {
		this.includeDeletedFiles = includeDeletedFiles;
	}

	/**
	 * Get all JE file numbers.
	 * 
	 * @return an array of all JE file numbers.
	 */
	public Long[] getAllFileNumbers() {
		String[] names = listFiles(JE_SUFFIXES);
		Long[] nums = new Long[names.length];
		for (int i = 0; i < nums.length; i += 1) {
			nums[i] = getNumFromName(names[i]);
		}
		return nums;
	}

	/**
	 * Get the next file number before/after currentFileNum.
	 * 
	 * @param currentFileNumthe
	 *            file we're at right now. Note that it may not exist, if it's
	 *            been cleaned and renamed.
	 * @param forwardif
	 *            true, we want the next larger file, if false we want the
	 *            previous file
	 * @return null if there is no following file, or if filenum doesn't exist
	 */
	public Long getFollowingFileNum(long currentFileNum, boolean forward) {
		String[] names = listFiles(JE_SUFFIXES);
		String searchName = getFileName(currentFileNum, JE_SUFFIX);
		int foundIdx = Arrays.binarySearch(names, searchName);
		boolean foundTarget = false;
		if (foundIdx >= 0) {
			if (forward) {
				foundIdx++;
			} else {
				foundIdx--;
			}
		} else {
			foundIdx = Math.abs(foundIdx + 1);
			if (!forward) {
				foundIdx--;
			}
		}
		if (forward && (foundIdx < names.length)) {
			foundTarget = true;
		} else if (!forward && (foundIdx > -1)) {
			foundTarget = true;
		}
		if (foundTarget) {
			return getNumFromName(names[foundIdx]);
		} else {
			return null;
		}
	}

	/**
	 * @return true if there are any files at all.
	 */
	public boolean filesExist() {
		String[] names = listFiles(JE_SUFFIXES);
		return (names.length != 0);
	}

	/**
	 * Get the first or last file number in the set of je files.
	 * 
	 * @param firstif
	 *            true, get the first file, else get the last file
	 * @return the file number or null if no files exist
	 */
	private Long getFileNum(boolean first) {
		String[] names = listFiles(JE_SUFFIXES);
		if (names.length == 0) {
			return null;
		} else {
			int index = 0;
			if (!first) {
				index = names.length - 1;
			}
			return getNumFromName(names[index]);
		}
	}

	/**
	 * Get the file number from a file name.
	 * 
	 * @param thefile
	 *            name
	 * @return the file number
	 */
	private Long getNumFromName(String fileName) {
		String fileNumber = fileName.substring(0, fileName.indexOf("."));
		return new Long(Long.parseLong(fileNumber, 16));
	}

	/**
	 * Find je files. Return names sorted in ascending fashion.
	 * 
	 * @param suffixwhich
	 *            type of file we're looking for
	 * @return array of file names
	 */
	String[] listFiles(String[] suffixes) {
		String[] fileNames = dbEnvHome.list(new JEFileFilter(suffixes));
		Arrays.sort(fileNames);
		return fileNames;
	}

	/**
	 * Find je files, flavor for unit test support.
	 * 
	 * @param suffixwhich
	 *            type of file we're looking for
	 * @return array of file names
	 */
	public static String[] listFiles(File envDirFile, String[] suffixes) {
		String[] fileNames = envDirFile.list(new JEFileFilter(suffixes));
		Arrays.sort(fileNames);
		return fileNames;
	}

	/**
	 * @return the full file name and path for the nth je file.
	 */
	String[] getFullFileNames(long fileNum) {
		if (includeDeletedFiles) {
			int nSuffixes = JE_AND_DEL_SUFFIXES.length;
			String[] ret = new String[nSuffixes];
			for (int i = 0; i < nSuffixes; i++) {
				ret[i] = getFullFileName(getFileName(fileNum,
						JE_AND_DEL_SUFFIXES[i]));
			}
			return ret;
		} else {
			return new String[] { getFullFileName(getFileName(fileNum,
					JE_SUFFIX)) };
		}
	}

	/**
	 * @return the full file name and path for the given file number and suffix.
	 */
	public String getFullFileName(long fileNum, String suffix) {
		return getFullFileName(getFileName(fileNum, suffix));
	}

	/**
	 * @return the full file name and path for this file name.
	 */
	private String getFullFileName(String fileName) {
		return dbEnvHome + File.separator + fileName;
	}

	/**
	 * @return the file name for the nth file.
	 */
	public static String getFileName(long fileNum, String suffix) {
		return (HexFormatter.formatLong(fileNum).substring(10) + suffix);
	}

	/**
	 * Rename this file to NNNNNNNN.suffix. If that file already exists, try
	 * NNNNNNNN.suffix.1, etc. Used for deleting files or moving corrupt files
	 * aside.
	 * 
	 * @param fileNumthe
	 *            file we want to move
	 * @param newSuffixthe
	 *            new file suffix
	 */
	public void renameFile(long fileNum, String newSuffix)
			throws DatabaseException, IOException {
		int repeatNum = 0;
		boolean renamed = false;
		while (!renamed) {
			String generation = "";
			if (repeatNum > 0) {
				generation = "." + repeatNum;
			}
			String newName = getFullFileName(getFileName(fileNum, newSuffix)
					+ generation);
			File targetFile = new File(newName);
			if (targetFile.exists()) {
				repeatNum++;
			} else {
				String oldFileName = getFullFileNames(fileNum)[0];
				// #if FILEHANDLECACHE
				clearFileCache(fileNum);
				// #endif
				File oldFile = new File(oldFileName);
				if (oldFile.renameTo(targetFile)) {
					renamed = true;
				} else {
					throw new LogException("Couldn't rename " + oldFileName
							+ " to " + newName);
				}
			}
		}
	}

	/**
	 * Delete log file NNNNNNNN.
	 * 
	 * @param fileNumthe
	 *            file we want to move
	 */
	public void deleteFile(long fileNum) throws DatabaseException, IOException {
		String fileName = getFullFileNames(fileNum)[0];
		// #if FILEHANDLECACHE
		clearFileCache(fileNum);
		// #endif
		File file = new File(fileName);
		boolean done = file.delete();
		if (!done) {
			throw new LogException("Couldn't delete " + file);
		}
	}

	/**
	 * Return a read only file handle that corresponds the this file number.
	 * Retrieve it from the cache or open it anew and validate the file header.
	 * This method takes a latch on this file, so that the file descriptor will
	 * be held in the cache as long as it's in use. When the user is done with
	 * the file, the latch must be released.
	 * 
	 * @param fileNumwhich
	 *            file
	 * @return the file handle for the existing or newly created file
	 */
	FileHandle getFileHandle(long fileNum) throws LogException,
			DatabaseException {
		Long fileId = new Long(fileNum);
		FileHandle fileHandle = null;
		// #if FILEHANDLECACHE
		while (true) {
			fileHandle = fileCache.get(fileId);
			if (fileHandle == null) {
				// #if LATCHES
				fileCacheLatch.acquire();
				try {
					fileHandle = fileCache.get(fileId);
					if (fileHandle == null) {
						fileHandle = makeFileHandle(fileNum, FileMode.READ_MODE);
						fileCache.add(fileId, fileHandle);
					}
				} finally {
					fileCacheLatch.release();
				}
				// #endif
			}
			// #if LATCHES
			fileHandle.latch();
			// #endif
			if (fileHandle.getFile() == null) {
				// #if LATCHES
				fileHandle.release();
				// #endif
			} else {
				break;
			}
		}
		// #endif
		return fileHandle;
	}

	private FileHandle makeFileHandle(long fileNum, FileMode mode)
			throws DatabaseException {
		String[] fileNames = getFullFileNames(fileNum);
		RandomAccessFile newFile = null;
		String fileName = null;
		try {
			FileNotFoundException FNFE = null;
			for (int i = 0; i < fileNames.length; i++) {
				fileName = fileNames[i];
				try {
					newFile = new RandomAccessFile(fileName,
							mode.getModeValue());
					break;
				} catch (FileNotFoundException e) {
					if (FNFE == null) {
						FNFE = e;
					}
				}
			}
			if (newFile == null) {
				throw FNFE;
			}
			boolean oldHeaderVersion = false;
			if (newFile.length() == 0) {
				if (mode == FileMode.READWRITE_MODE) {
					long lastLsn = DbLsn.longToLsn((Long) perFileLastUsedLsn
							.remove(new Long(fileNum - 1)));
					long headerPrevOffset = 0;
					if (lastLsn != DbLsn.NULL_LSN) {
						headerPrevOffset = DbLsn.getFileOffset(lastLsn);
					}
					FileHeader fileHeader = new FileHeader(fileNum,
							headerPrevOffset);
					writeFileHeader(newFile, fileName, fileHeader);
				}
			} else {
				oldHeaderVersion = readAndValidateFileHeader(newFile, fileName,
						fileNum);
			}
			return new FileHandle(newFile, fileName, envImpl, oldHeaderVersion);
		} catch (FileNotFoundException e) {
			throw new LogFileNotFoundException("Couldn't open file " + fileName
					+ ": " + e.getMessage());
		} catch (DbChecksumException e) {
			closeFileInErrorCase(newFile);
			throw new DbChecksumException(envImpl, "Couldn't open file "
					+ fileName, e);
		} catch (Throwable t) {
			closeFileInErrorCase(newFile);
			throw new DatabaseException("Couldn't open file " + fileName + ": "
					+ t, t);
		}
	}

	/**
	 * Close this file and eat any exceptions. Used in catch clauses.
	 */
	private void closeFileInErrorCase(RandomAccessFile file) {
		try {
			if (file != null) {
				file.close();
			}
		} catch (IOException e) {
		}
	}

	/**
	 * Read the given je log file and validate the header.
	 * 
	 * @throws DatabaseExceptionif
	 *             the file header isn't valid
	 * @return whether the file header has an old version number.
	 */
	private boolean readAndValidateFileHeader(RandomAccessFile file,
			String fileName, long fileNum) throws DatabaseException,
			IOException {
		LogManager logManager = envImpl.getLogManager();
		LogEntry headerEntry = logManager.getLogEntry(
				DbLsn.makeLsn(fileNum, 0), file);
		FileHeader header = (FileHeader) headerEntry.getMainItem();
		return header.validate(fileName, fileNum);
	}

	/**
	 * Write a proper file header to the given file.
	 */
	private void writeFileHeader(RandomAccessFile file, String fileName,
			FileHeader header) throws DatabaseException, IOException {
		envImpl.checkIfInvalid();
		if (envImpl.mayNotWrite()) {
			return;
		}
		int headerSize = header.getLogSize();
		int entrySize = headerSize + LogManager.HEADER_BYTES;
		ByteBuffer headerBuf = envImpl.getLogManager().putIntoBuffer(header,
				headerSize, 0, false, entrySize);
		if (++writeCount >= stopOnWriteCount) {
			Runtime.getRuntime().halt(0xff);
		}
		int bytesWritten;
		try {
			if (RUNRECOVERY_EXCEPTION_TESTING) {
				generateRunRecoveryException(file, headerBuf, 0);
			}
			bytesWritten = writeToFile(file, headerBuf, 0);
		} catch (ClosedChannelException e) {
			throw new RunRecoveryException(envImpl,
					"Channel closed, may be due to thread interrupt", e);
		} catch (IOException e) {
			throw new RunRecoveryException(envImpl, "IOException caught: " + e);
		}
		if (bytesWritten != entrySize) {
			throw new LogException("File " + fileName
					+ " was created with an incomplete header. Only "
					+ bytesWritten + " bytes were written.");
		}
	}

	/**
	 * @return the prevOffset field stored in the file header.
	 */
	long getFileHeaderPrevOffset(long fileNum) throws IOException,
			DatabaseException {
		LogEntry headerEntry = envImpl.getLogManager().getLogEntry(
				DbLsn.makeLsn(fileNum, 0));
		FileHeader header = (FileHeader) headerEntry.getMainItem();
		return header.getLastEntryInPrevFileOffset();
	}

	/**
	 * @return the file offset of the last LSN that was used. For constructing
	 *         the headers of log entries. If the last LSN that was used was in
	 *         a previous file, or this is the very first LSN of the whole
	 *         system, return 0.
	 */
	long getPrevEntryOffset() {
		return prevOffset;
	}

	/**
	 * Increase the current log position by "size" bytes. Move the prevOffset
	 * pointer along.
	 * 
	 * @param sizeis
	 *            an unsigned int
	 * @return true if we flipped to the next log file.
	 */
	boolean bumpLsn(long size) {
		saveLastPosition();
		boolean flippedFiles = false;
		if (forceNewFile
				|| (DbLsn.getFileOffset(nextAvailableLsn) + size) > maxFileSize) {
			forceNewFile = false;
			currentFileNum++;
			if (lastUsedLsn != DbLsn.NULL_LSN) {
				perFileLastUsedLsn.put(
						new Long(DbLsn.getFileNumber(lastUsedLsn)), new Long(
								lastUsedLsn));
			}
			prevOffset = 0;
			lastUsedLsn = DbLsn.makeLsn(currentFileNum, firstLogEntryOffset());
			flippedFiles = true;
		} else {
			if (lastUsedLsn == DbLsn.NULL_LSN) {
				prevOffset = 0;
			} else {
				prevOffset = DbLsn.getFileOffset(lastUsedLsn);
			}
			lastUsedLsn = nextAvailableLsn;
		}
		nextAvailableLsn = DbLsn.makeLsn(DbLsn.getFileNumber(lastUsedLsn),
				(DbLsn.getFileOffset(lastUsedLsn) + size));
		return flippedFiles;
	}

	/**
	 * Write out a log buffer to the file.
	 * 
	 * @param fullBufferbuffer
	 *            to write
	 */
	void writeLogBuffer(LogBuffer fullBuffer) throws DatabaseException {
		envImpl.checkIfInvalid();
		if (envImpl.mayNotWrite()) {
			return;
		}
		long firstLsn = fullBuffer.getFirstLsn();
		if (firstLsn != DbLsn.NULL_LSN) {
			RandomAccessFile file = endOfLog.getWritableFile(DbLsn
					.getFileNumber(firstLsn));
			ByteBuffer data = fullBuffer.getDataBuffer();
			if (++writeCount >= stopOnWriteCount) {
				Runtime.getRuntime().halt(0xff);
			}
			try {
				// #if DISKFULLERRO
				assert fullBuffer.getRewriteAllowed()
						|| (DbLsn.getFileOffset(firstLsn) >= file.length() || file
								.length() == firstLogEntryOffset()) : "FileManager would overwrite non-empty file 0x"
						+ Long.toHexString(DbLsn.getFileNumber(firstLsn))
						+ " lsnOffset=0x"
						+ Long.toHexString(DbLsn.getFileOffset(firstLsn))
						+ " fileLength=0x" + Long.toHexString(file.length());
				// #endif
				if (IO_EXCEPTION_TESTING) {
					throw new IOException("generated for testing");
				}
				if (RUNRECOVERY_EXCEPTION_TESTING) {
					generateRunRecoveryException(file, data,
							DbLsn.getFileOffset(firstLsn));
				}
				writeToFile(file, data, DbLsn.getFileOffset(firstLsn));
			} catch (ClosedChannelException e) {
				throw new RunRecoveryException(envImpl,
						"File closed, may be due to thread interrupt", e);
			} catch (IOException IOE) {
				abortCommittedTxns(data);
				// #if DISKFULLERRO
				try{
					if (IO_EXCEPTION_TESTING) {
						throw new IOException("generated for testing");
					}
					writeToFile(file, data, DbLsn.getFileOffset(firstLsn));
				} catch (IOException IOE2) {
					fullBuffer.setRewriteAllowed();
					throw new DatabaseException(IOE2);
				} if (false)
					throw new DatabaseException(IOE);
				// #endif
			}
			assert EnvironmentImpl.maybeForceYield();
		}
	}

	/**
	 * Write a buffer to a file at a given offset, using NIO if so configured.
	 */
	private int writeToFile(RandomAccessFile file, ByteBuffer data,
			long destOffset) throws IOException, DatabaseException {
		int totalBytesWritten = 0;
		FileChannel channel = null;
		// #if NIO
		channel = file.getChannel();
		// #elif CHUNKEDNIO
		channel = file.getChannel();
		// #endif
		if (chunkedNIOSize > 0) {
			// #if CHUNKEDNIO
			ByteBuffer useData = data.duplicate();
			int originalLimit = useData.limit();
			useData.limit(useData.position());
			while (useData.limit() < originalLimit) {
				useData.limit((int) (Math.min(useData.limit() + chunkedNIOSize,
						originalLimit)));
				int bytesWritten = channel.write(useData, destOffset);
				destOffset += bytesWritten;
				totalBytesWritten += bytesWritten;
			}
			// #endif
		} else{
		// #if NIO
			totalBytesWritten = channel.write(data, destOffset);
		// #endif
		}
		
		// #if IO
		// #if SYNCHRONIZEDIO
		synchronized (file){
			totalBytesWritten = ioWriteWithoutSynchronized(file, data, destOffset);
		}
		//#else
		totalBytesWritten = ioWriteWithoutSynchronized(file, data, destOffset);
		// #endif
		// #endif
		return totalBytesWritten;
	}

	boolean NIO, CHUNKEDNIO, IO, SYNCHRONIZEDIO;
	
	private int ioWriteWithoutSynchronized(RandomAccessFile file,
			ByteBuffer data, long destOffset) throws IOException {
		// #if IO
			int totalBytesWritten;
			assert data.hasArray();
			assert data.arrayOffset() == 0;
			int pos=data.position();
			int size=data.limit() - pos;
			file.seek(destOffset);
			//			file.write(data.array(),pos,size);
			for (int i = 0; i < size; i++) {
				byte by = data.get(pos+i);
				file.writeByte(by);
			}
			data.position(pos + size);
			totalBytesWritten=size;
			return totalBytesWritten;
		//#else
			return -1; /*dummy*/
		//#endif
	}


	/**
	 * Read a buffer from a file at a given offset, using NIO if so configured.
	 */
	void readFromFile(RandomAccessFile file, ByteBuffer readBuffer, long offset)
			throws IOException {
		FileChannel channel = null;
		// #if NIO
		if (NIO) {
			channel = file.getChannel();
		}
		//#elif CHUNKEDNIO
			channel=file.getChannel();
		// #endif

		if (chunkedNIOSize > 0){
		// #if CHUNKEDNIO
			int readLength = readBuffer.limit();
			long currentPosition = offset;
			while (readBuffer.position() < readLength) {
				readBuffer.limit((int) (Math.min(readBuffer.limit()
						+ chunkedNIOSize, readLength)));
				int bytesRead = channel.read(readBuffer, currentPosition);
				if (bytesRead < 1)
					break;
				currentPosition += bytesRead;
			}
			// #endif
		} else {
		// #if NIO
			channel.read(readBuffer, offset);
		// #endif
		}
		// #if IO
		// #if SYNCHRONIZEDIO
		synchronized (file){
			ioReadWithoutSynchronazed(file, readBuffer, offset);
		}
		// #else
		ioReadWithoutSynchronazed(file, readBuffer, offset);
		// #endif
		// #endif
	}
	
	private void ioReadWithoutSynchronazed(RandomAccessFile file,
			ByteBuffer readBuffer, long offset) throws IOException {
		// #if IO
			assert readBuffer.hasArray();
			assert readBuffer.arrayOffset() == 0;
			int pos=readBuffer.position();
			int size=readBuffer.limit() - pos;
			file.seek(offset);

			//int bytesRead=file.read(readBuffer.array(),pos,size);
			int bytesRead = 0;
			try {
				for (int i = 0; i < size; i++) {
					byte by = file.readByte();
					readBuffer.put(pos + i, by);
					bytesRead++;
				}
			} catch (EOFException _) {
				if (bytesRead == 0) {
					bytesRead = -1;
				}
			}
			if (bytesRead > 0) {
				readBuffer.position(pos + bytesRead);
			}
		//#endif
	}


	private void abortCommittedTxns(ByteBuffer data) {
		final byte commitType = LogEntryType.LOG_TXN_COMMIT.getTypeNum();
		final byte abortType = LogEntryType.LOG_TXN_ABORT.getTypeNum();
		// #if FILEHANDLECACHE
		data.position(0);
		// #endif
		while (data.remaining() > 0) {
			int recStartPos = data.position();
			data.position(recStartPos + LogManager.HEADER_ENTRY_TYPE_OFFSET);
			int typePos = data.position();
			byte entryType = data.get();
			boolean recomputeChecksum = false;
			if (entryType == commitType) {
				data.position(typePos);
				data.put(abortType);
				recomputeChecksum = true;
			}
			byte version = data.get();
			data.position(data.position() + LogManager.PREV_BYTES);
			int itemSize = LogUtils.readInt(data);
			int itemDataStartPos = data.position();
			if (recomputeChecksum) {
				Checksum checksum = Adler32.makeChecksum();
				data.position(recStartPos);
				int nChecksumBytes = itemSize
						+ (LogManager.HEADER_BYTES - LogManager.CHECKSUM_BYTES);
				byte[] checksumBytes = new byte[nChecksumBytes];
				System.arraycopy(data.array(), recStartPos
						+ LogManager.CHECKSUM_BYTES, checksumBytes, 0,
						nChecksumBytes);
				checksum.update(checksumBytes, 0, nChecksumBytes);
				LogUtils.writeUnsignedInt(data, checksum.getValue());
			}
			data.position(itemDataStartPos + itemSize);
		}
		data.position(0);
	}

	/**
	 * FSync the end of the log.
	 */
	void syncLogEnd() throws DatabaseException {
		try {
			endOfLog.force();
		} catch (IOException e) {
			throw new DatabaseException(e);
		}
	}

	/**
	 * Sync the end of the log, close off this log file. Should only be called
	 * under the log write latch.
	 */
	void syncLogEndAndFinishFile() throws DatabaseException, IOException {
		if (syncAtFileEnd) {
			syncLogEnd();
		}
		endOfLog.close();
	}

	// #if FSYNC
	/**
	 * Flush a file using the group sync mechanism, trying to amortize off other
	 * syncs.
	 */
	void groupSync() throws DatabaseException {
		syncManager.fsync();
	}

	// #endif
	/**
	 * Close all file handles and empty the cache.
	 */
	public void clear() throws IOException, DatabaseException {
		// #if FILEHANDLECACHE
		// #if LATCHES
		fileCacheLatch.acquire();
		try{
			fileCache.clear();
		} finally {
			fileCacheLatch.release();
		}
		// #endif
		// #endif
		endOfLog.close();
	}

	/**
	 * Clear the file lock.
	 */
	public void close() throws IOException, DatabaseException {
		// #if ENVIRONMENTLOCKING
		if (envLock != null){
			envLock.release();
		}
		if (exclLock != null){
			exclLock.release();
		}
		if (channel != null){
			channel.close();
		}
		if (lockFile != null){
			lockFile.close();
		}
		// #endif
	}

	// #if ENVIRONMENTLOCKING
	/**
	 * Lock the environment. Return true if the lock was acquired. If exclusive
	 * is false, then this implements a single writer, multiple reader lock. If
	 * exclusive is true, then implement an exclusive lock. There is a lock file
	 * and there are two regions of the lock file: byte 0, and byte 1. Byte 0 is
	 * the exclusive writer process area of the lock file. If an environment is
	 * opened for write, then it attempts to take an exclusive write lock on
	 * byte 0. Byte 1 is the shared reader process area of the lock file. If an
	 * environment is opened for read-only, then it attempts to take a shared
	 * lock on byte 1. This is how we implement single writer, multi reader
	 * semantics. The cleaner, each time it is invoked, attempts to take an
	 * exclusive lock on byte 1. The owning process already either has an
	 * exclusive lock on byte 0, or a shared lock on byte 1. This will
	 * necessarily conflict with any shared locks on byte 1, even if it's in the
	 * same process and there are no other holders of that shared lock. So if
	 * there is only one read-only process, it will have byte 1 for shared
	 * access, and the cleaner can not run in it because it will attempt to get
	 * an exclusive lock on byte 1 (which is already locked for shared access by
	 * itself). If a write process comes along and tries to run the cleaner, it
	 * will attempt to get an exclusive lock on byte 1. If there are no other
	 * reader processes (with shared locks on byte 1), and no other writers
	 * (which are running cleaners on with exclusive locks on byte 1), then the
	 * cleaner will run.
	 */
	public boolean lockEnvironment(boolean readOnly, boolean exclusive)
			throws DatabaseException {
		try {
			if (checkEnvHomePermissions(readOnly)) {
				return true;
			}
			if (lockFile == null){
				lockFile = new RandomAccessFile(new File(dbEnvHome, "je"
						+ LOCK_SUFFIX), "rw");
			}
			channel = lockFile.getChannel();
			boolean throwIt = false;
			try {
				if (exclusive) {
					exclLock = channel.tryLock(1, 2, false);
					if (exclLock == null) {
						return false;
					}
					return true;
				} else {
					if (readOnly) {
						envLock = channel.tryLock(1, 2, true);
					} else {
						envLock = channel.tryLock(0, 1, false);
					}
					if (envLock == null) {
						throwIt = true;
					}
				}
			} catch (OverlappingFileLockException e) {
				throwIt = true;
			}
			if (throwIt) {
				throw new LogException("A je" + LOCK_SUFFIX + "file exists in "
						+ dbEnvHome + " The environment can not be locked for "
						+ (readOnly ? "shared" : "single writer") + " access.");
			}
		} catch (IOException IOE) {
			throw new LogException(IOE.toString());
		}
		return true;
	}
	// #endif
	
	// #if ENVIRONMENTLOCKING
	public void releaseExclusiveLock() throws DatabaseException {
		try {
			if (exclLock != null) {
				exclLock.release();
			}
		} catch (IOException IOE) {
			throw new DatabaseException(IOE);
		}
	}

	// #endif
	/**
	 * Ensure that if the environment home dir is on readonly media or in a
	 * readonly directory that the environment has been opened for readonly
	 * access.
	 * 
	 * @return true if the environment home dir is readonly.
	 */
	private boolean checkEnvHomePermissions(boolean readOnly)
			throws DatabaseException {
		boolean envDirIsReadOnly = !dbEnvHome.canWrite();
		if (envDirIsReadOnly && !readOnly) {
			throw new DatabaseException("The Environment directory "
					+ dbEnvHome + " is not writable, but the "
					+ "Environment was opened for read-write access.");
		}
		return envDirIsReadOnly;
	}

	/**
	 * Truncate a log at this position. Used by recovery to a timestamp
	 * utilities and by recovery to set the end-of-log position.
	 * <p>
	 * This method forces a new log file to be written next, if the last file
	 * (the file truncated to) has an old version in its header. This ensures
	 * that when the log is opened by an old version of JE, a version
	 * incompatibility will be detected. [#11243]
	 * </p>
	 */
	public void truncateLog(long fileNum, long offset) throws IOException,
			DatabaseException {
		FileHandle handle = makeFileHandle(fileNum, FileMode.READWRITE_MODE);
		RandomAccessFile file = handle.getFile();
		try {
			file.getChannel().truncate(offset);
		} finally {
			file.close();
		}
		if (handle.isOldHeaderVersion()) {
			forceNewFile = true;
		}
	}

	/**
	 * Set the flag that causes a new file to be written before the next write.
	 */
	void forceNewLogFile() {
		forceNewFile = true;
	}

	/**
	 * @return the size in bytes of the file header log entry.
	 */
	public static int firstLogEntryOffset() {
		return FileHeader.entrySize() + LogManager.HEADER_BYTES;
	}

	/**
	 * Return the next available LSN in the log. Note that this is
	 * unsynchronized, so is only valid as an approximation of log size.
	 */
	public long getNextLsn() {
		return nextAvailableLsn;
	}

	/**
	 * Return the last allocated LSN in the log. Note that this is
	 * unsynchronized, so if it is called outside the log write latch it is only
	 * valid as an approximation of log size.
	 */
	public long getLastUsedLsn() {
		return lastUsedLsn;
	}

	// #if STATISTICS
	// #if FSYNC
	public long getNFSyncs() {
		return syncManager.getNFSyncs();
	}
	// #endif
	// #endif
	
	// #if STATISTICS
	// #if FSYNC
	public long getNFSyncRequests() {
		return syncManager.getNFSyncRequests();
	}
	// #endif
	// #endif
	
	// #if STATISTICS
	// #if FSYNC
	public long getNFSyncTimeouts() {
		return syncManager.getNTimeouts();
	}
	// #endif
	// #endif
	
	// #if STATISTICS
	// #if FSYNC
	void loadStats(StatsConfig config, EnvironmentStats stats)
			throws DatabaseException {
		syncManager.loadStats(config, stats);
	}
	// #endif
	// #endif
	
	// #if FILEHANDLECACHE
	Set getCacheKeys() {
		return fileCache.getCacheKeys();
	}
	// #endif
	
	// #if FILEHANDLECACHE
	/**
	 * Clear a file out of the file cache regardless of mode type.
	 */
	private void clearFileCache(long fileNum) throws IOException,
			DatabaseException {
		// #if LATCHES
		fileCacheLatch.acquire();
		try {
			fileCache.remove(fileNum);
		} finally {
			fileCacheLatch.release();
		}
		// #endif
	}
	// #endif
	
	// #if FILEHANDLECACHE
	private static class FileCache {
		private Map fileMap;
		private LinkedList fileList;
		private int fileCacheSize;

		FileCache(DbConfigManager configManager) throws DatabaseException {
			fileMap = new Hashtable();
			fileList = new LinkedList();
			fileCacheSize = configManager
					.getInt(EnvironmentParams.LOG_FILE_CACHE_SIZE);
		}

		private FileHandle get(Long fileId) {
			return (FileHandle) fileMap.get(fileId);
		}

		private void add(Long fileId, FileHandle fileHandle)
				throws DatabaseException {
			if (fileList.size() >= fileCacheSize) {
				Iterator iter = fileList.iterator();
				while (iter.hasNext()) {
					Long evictId = (Long) iter.next();
					FileHandle evictTarget = (FileHandle) fileMap.get(evictId);
					// #if LATCHES
					if (evictTarget.latchNoWait()) {
						try {
							fileMap.remove(evictId);
							iter.remove();
							evictTarget.close();
						} catch (IOException e) {
							throw new DatabaseException(e);
						} finally {
							evictTarget.release();
						}
						break;
					}
					// #endif
				}
			}
			fileList.add(fileId);
			fileMap.put(fileId, fileHandle);
		}

		/**
		 * Take any file handles corresponding to this file name out of the
		 * cache. A file handle could be there twice, in rd only and in r/w
		 * mode.
		 */
		private void remove(long fileNum) throws IOException, DatabaseException {
			Iterator iter = fileList.iterator();
			while (iter.hasNext()) {
				Long evictId = (Long) iter.next();
				if (evictId.longValue() == fileNum) {
					FileHandle evictTarget = (FileHandle) fileMap.get(evictId);
					// #if LATCHES
					try {
						// #if LATCHES
						evictTarget.latch();
						// #endif
						fileMap.remove(evictId);
						iter.remove();
						evictTarget.close();
					} finally {
						evictTarget.release();
					}
					// #endif
				}
			}
		}

		private void clear() throws IOException, DatabaseException {
			Iterator iter = fileMap.values().iterator();
			while (iter.hasNext()) {
				FileHandle fileHandle = (FileHandle) iter.next();
				// #if LATCHES
				try {
					// #if LATCHES
					fileHandle.latch();
					// #endif
					fileHandle.close();
					iter.remove();
				} finally {
					fileHandle.release();
				}
				// #endif
			}
			fileMap.clear();
			fileList.clear();
		}

		private Set getCacheKeys() {
			return fileMap.keySet();
		}
	}
	// #endif
	
	/**
	 * The LogEndFileDescriptor is used to write and fsync the end of the log.
	 * Because the JE log is append only, there is only one logical R/W file
	 * descriptor for the whole environment. This class actually implements two
	 * RandomAccessFile instances, one for writing and one for fsyncing, so the
	 * two types of operations don't block each other. The write file descriptor
	 * is considered the master. Manipulation of this class is done under the
	 * log write latch. Here's an explanation of why the log write latch is
	 * sufficient to safeguard all operations. There are two types of callers
	 * who may use this file descriptor: the thread that is currently writing to
	 * the end of the log and any threads that are fsyncing on behalf of the
	 * FSyncManager. The writing thread appends data to the file and fsyncs the
	 * file when we flip over to a new log file. The file is only instantiated
	 * at the point that it must do so -- which is either when the first fsync
	 * is required by JE or when the log file is full and we flip files.
	 * Therefore, the writing thread has two actions that change this descriptor
	 * -- we initialize the file descriptor for the given log file at the first
	 * write to the file, and we close the file descriptor when the log file is
	 * full. Therefore is a period when there is no log descriptor -- when we
	 * have not yet written a log buffer into a given log file. The fsyncing
	 * threads ask for the log end file descriptor asynchronously, but will
	 * never modify it. These threads may arrive at the point when the file
	 * descriptor is null, and therefore skip their fysnc, but that is fine
	 * because it means a writing thread already flipped that target file and
	 * has moved on to the next file. Time Activity 10 thread 1 writes log entry
	 * A into file 0x0, issues fsync outside of log write latch, yields the
	 * processor 20 thread 2 writes log entry B, piggybacks off thread 1 30
	 * thread 3 writes log entry C, but no room left in that file, so it flips
	 * the log, and fsyncs file 0x0, all under the log write latch. It nulls out
	 * endOfLogRWFile, moves onto file 0x1, but doesn't create the file yet. 40
	 * thread 1 finally comes along, but endOfLogRWFile is null-- no need to
	 * fsync in that case, 0x0 got fsynced.
	 */
	class LogEndFileDescriptor {
		private RandomAccessFile endOfLogRWFile = null;
		private RandomAccessFile endOfLogSyncFile = null;

		/**
		 * getWritableFile must be called under the log write latch.
		 */
		RandomAccessFile getWritableFile(long fileNumber)
				throws RunRecoveryException {
			try {
				if (endOfLogRWFile == null) {
					endOfLogRWFile = makeFileHandle(fileNumber,
							FileMode.READWRITE_MODE).getFile();
					endOfLogSyncFile = makeFileHandle(fileNumber,
							FileMode.READWRITE_MODE).getFile();
				}
				return endOfLogRWFile;
			} catch (Exception e) {
				throw new RunRecoveryException(envImpl, e);
			}
		}

		/**
		 * FSync the log file that makes up the end of the log.
		 */
		void force() throws DatabaseException, IOException {
			RandomAccessFile file = endOfLogSyncFile;
			if (file != null) {
				FileChannel channel = file.getChannel();
				try {
					channel.force(false);
				} catch (ClosedChannelException e) {
					throw new RunRecoveryException(envImpl,
							"Channel closed, may be due to thread interrupt", e);
				}
				assert EnvironmentImpl.maybeForceYield();
			}
		}

		/**
		 * Close the end of the log file descriptor. Use atomic assignment to
		 * ensure that we won't force and close on the same descriptor.
		 */
		void close() throws IOException {
			IOException firstException = null;
			if (endOfLogRWFile != null) {
				RandomAccessFile file = endOfLogRWFile;
				endOfLogRWFile = null;
				try {
					file.close();
				} catch (IOException e) {
					firstException = e;
				}
			}
			if (endOfLogSyncFile != null) {
				RandomAccessFile file = endOfLogSyncFile;
				endOfLogSyncFile = null;
				file.close();
			}
			if (firstException != null) {
				throw firstException;
			}
		}
	}

	static boolean RUNRECOVERY_EXCEPTION_TESTING = false;
	private static final int RUNRECOVERY_EXCEPTION_MAX = 100;
	private int runRecoveryExceptionCounter = 0;
	private boolean runRecoveryExceptionThrown = false;
	private Random runRecoveryExceptionRandom = null;

	private void generateRunRecoveryException(RandomAccessFile file,
			ByteBuffer data, long destOffset) throws DatabaseException,
			IOException {
		if (runRecoveryExceptionThrown) {
			try {
				throw new Exception("Write after RunRecoveryException");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		runRecoveryExceptionCounter += 1;
		if (runRecoveryExceptionCounter >= RUNRECOVERY_EXCEPTION_MAX) {
			runRecoveryExceptionCounter = 0;
		}
		if (runRecoveryExceptionRandom == null) {
			runRecoveryExceptionRandom = new Random(System.currentTimeMillis());
		}
		if (runRecoveryExceptionCounter == runRecoveryExceptionRandom
				.nextInt(RUNRECOVERY_EXCEPTION_MAX)) {
			int len = runRecoveryExceptionRandom.nextInt(data.remaining());
			if (len > 0) {
				byte[] a = new byte[len];
				data.get(a, 0, len);
				ByteBuffer buf = ByteBuffer.wrap(a);
				writeToFile(file, buf, destOffset);
			}
			runRecoveryExceptionThrown = true;
			throw new RunRecoveryException(envImpl,
					"Randomly generated for testing");
		}
	}
}
