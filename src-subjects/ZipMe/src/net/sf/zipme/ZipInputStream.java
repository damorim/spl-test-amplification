//

package net.sf.zipme;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/**
 * This is a FilterInputStream that reads the files in an zip archive one after
 * another. It has a special method to get the zip entry of the next file. The
 * zip entry contains information about the file name size, compressed size,
 * CRC, etc. It includes support for STORED and DEFLATED entries.
 * 
 * @author Jochen Hoenicke
 */
public class ZipInputStream extends InflaterInputStream implements ZipConstants {

	private CRC32 crc = new CRC32();

	/**
	 * Open the next entry from the zip archive, and return its description. If
	 * the previous entry wasn't closed, this method will close it.
	 */
	public ZipEntry getNextEntry() throws IOException {
		// #if DERIVATIVE_EXTRACT_CRC
		if (crc == null)
			throw new IOException("Stream closed.");
		// #endif
		// #if EXTRACT
		if (entry != null)
			closeEntry();
		int header = readLeInt();
		if (header == CENSIG) {
			close();
			return null;
		}
		if (header != LOCSIG)
			throw new ZipException("Wrong Local header signature: "
					+ Integer.toHexString(header));
		readLeShort();
		flags = readLeShort();
		method = readLeShort();
		int dostime = readLeInt();
		int crc = readLeInt();
		csize = readLeInt();
		size = readLeInt();
		int nameLen = readLeShort();
		int extraLen = readLeShort();
		if (method == ZipOutputStream.STORED && csize != size)
			throw new ZipException("Stored, but compressed != uncompressed");
		byte[] buffer = new byte[nameLen];
		readFully(buffer);
		String name;
		try {
			name = new String(buffer, "UTF-8");
		} catch (UnsupportedEncodingException uee) {
			throw new Error(uee.toString());
		}
		entry = createZipEntry(name);
		entryAtEOF = false;
		entry.setMethod(method);
		if ((flags & 8) == 0) {
			entry.setCrc(crc & 0xffffffffL);
			entry.setSize(size & 0xffffffffL);
			entry.setCompressedSize(csize & 0xffffffffL);
		}
		entry.setDOSTime(dostime);
		if (extraLen > 0) {
			byte[] extra = new byte[extraLen];
			readFully(extra);
			entry.setExtra(extra);
		}
		if (method == ZipOutputStream.DEFLATED && avail > 0) {
			System.arraycopy(buf, len - avail, buf, 0, avail);
			len = avail;
			avail = 0;
			inf.setInput(buf, 0, len);
		}
		// #endif
		return entry;
	}

	protected void hook36() throws IOException {
		// #if DERIVATIVE_EXTRACT_CRC
		crc.reset();
		// #endif
	}

	protected void hook37(byte[] b, int off, int len) throws IOException {
		// #if DERIVATIVE_EXTRACT_CRC
		if (len > 0)
			crc.update(b, off, len);
		// #endif
	}

	protected void hook38() throws IOException {
		// #if DERIVATIVE_EXTRACT_CRC
		if (crc == null)
			throw new IOException("Stream closed.");
		// #endif
	}

	protected void hook39() throws IOException {
		// #if DERIVATIVE_EXTRACT_CRC
		if ((crc.getValue() & 0xffffffffL) != entry.getCrc())
			throw new ZipException("CRC mismatch");
		crc.reset();
		// #endif
	}

	protected void hook40() throws IOException {
		// #if DERIVATIVE_EXTRACT_CRC
		crc = null;
		// #endif
	}

	public CRC32 headCRC;

	public void hook() {
		// #if DERIVATIVE_GZIPCRC
		crc = new CRC32();
		// #endif
	}

	private void hook1() {
		// #if DERIVATIVE_GZIPCRC
		headCRC = new CRC32();
		// #endif
	}

	public void hook2(int CM) {
		// #if DERIVATIVE_GZIPCRC
		headCRC.update(CM);
		// #endif
	}

	public void hook3(int crcval) throws IOException {
		// #if DERIVATIVE_GZIPCRC
		if (crcval != ((int) headCRC.getValue() & 0xffff))
			throw new IOException("Header CRC value mismatch");
		// #endif
	}

	public void hook4(int crcval) throws IOException {
		// #if DERIVATIVE_GZIPCRC
		if (crcval != (int) crc.getValue())
			throw new IOException("GZIP crc sum mismatch, theirs \""
					+ Integer.toHexString(crcval) + "\" and ours \""
					+ Integer.toHexString((int) crc.getValue()));
		// #endif
	}

	protected void hook30(byte[] buf, int offset, int numRead)
			throws IOException {
		// #if DERIVATIVE_GZIPCRC
		if (numRead > 0)
			crc.update(buf, offset, numRead);
		// #endif
	}

	private ZipEntry entry = null;
	private int csize;
	private int size;
	private int method;
	private int flags;
	private int avail;
	private boolean entryAtEOF;

	/**
	 * Creates a new Zip input stream, reading a zip archive.
	 */
	public ZipInputStream(InputStream in) {
		super(in, new Inflater(true));
	}

	private void fillBuf() throws IOException {
		// #if EXTRACT
		avail = len = in.read(buf, 0, buf.length);
		// #endif
	}

	// #if EXTRACT
	private int readBuf(byte[] out, int offset, int length) throws IOException {
		if (avail <= 0) {
			fillBuf();
			if (avail <= 0)
				return -1;
		}
		if (length > avail)
			length = avail;
		System.arraycopy(buf, len - avail, out, offset, length);
		avail -= length;
		return length;
	}

	// #endif

	private void readFully(byte[] out) throws IOException {
		// #if EXTRACT
		int off = 0;
		int len = out.length;
		while (len > 0) {
			int count = readBuf(out, off, len);
			if (count == -1)
				throw new EOFException();
			off += count;
			len -= count;
		}
		// #endif
	}

	// #if EXTRACT
	private int readLeByte() throws IOException {
		if (avail <= 0) {
			fillBuf();
			if (avail <= 0)
				throw new ZipException("EOF in header");
		}
		return buf[len - avail--] & 0xff;
	}
	// #endif

	// #if EXTRACT
	/**
	 * Read an unsigned short in little endian byte order.
	 */
	private int readLeShort() throws IOException {
		return readLeByte() | (readLeByte() << 8);
	}
	// #endif

	// #if EXTRACT
	/**
	 * Read an int in little endian byte order.
	 */
	private int readLeInt() throws IOException {
		return readLeShort() | (readLeShort() << 16);
	}
	// #endif

	private void readDataDescr() throws IOException {
		// #if EXTRACT
		if (readLeInt() != EXTSIG)
			throw new ZipException("Data descriptor signature not found");
		entry.setCrc(readLeInt() & 0xffffffffL);
		csize = readLeInt();
		size = readLeInt();
		entry.setSize(size & 0xffffffffL);
		entry.setCompressedSize(csize & 0xffffffffL);
		// #endif
	}

	/**
	 * Closes the current zip entry and moves to the next one.
	 */
	public void closeEntry() throws IOException {
		// #if DERIVATIVE_EXTRACT_CRC
		if (crc == null)
			throw new IOException("Stream closed.");
		// #endif
		// #if EXTRACT
		if (entry == null)
			return;
		if (method == ZipOutputStream.DEFLATED) {
			if ((flags & 8) != 0) {
				byte[] tmp = new byte[2048];
				while (read(tmp) > 0)
					;
				return;
			}
			csize -= inf.getTotalIn();
			avail = inf.getRemaining();
		}
		if (avail > csize && csize >= 0)
			avail -= csize;
		else {
			csize -= avail;
			avail = 0;
			while (csize != 0) {
				long skipped = in.skip(csize & 0xffffffffL);
				if (skipped <= 0)
					throw new ZipException("zip archive ends early.");
				csize -= skipped;
			}
		}
		size = 0;
		this.hook36();
		if (method == ZipOutputStream.DEFLATED)
			inf.reset();
		entry = null;
		entryAtEOF = true;
		// #endif
	}

	// #if EXTRACT
	public int available() throws IOException {
		return entryAtEOF ? 0 : 1;
	}
	// #endif

	// #if EXTRACT
	/**
	 * Reads a byte from the current zip entry.
	 * 
	 * @return the byte or -1 on EOF.
	 * @exception IOException
	 *                if a i/o error occured.
	 * @exception ZipException
	 *                if the deflated stream is corrupted.
	 */
	public int read() throws IOException {
		byte[] b = new byte[1];
		if (read(b, 0, 1) <= 0)
			return -1;
		return b[0] & 0xff;
	}
	// #endif

	// #if EXTRACT
	/**
	 * Reads a block of bytes from the current zip entry.
	 * 
	 * @return the number of bytes read (may be smaller, even before EOF), or -1
	 *         on EOF.
	 * @exception IOException
	 *                if a i/o error occured.
	 * @exception ZipException
	 *                if the deflated stream is corrupted.
	 */
	public int read(byte[] b, int off, int len) throws IOException {
		if (len == 0)
			return 0;
		this.hook38();
		if (entry == null)
			return -1;
		boolean finished = false;
		switch (method) {
		case ZipOutputStream.DEFLATED:
			len = super.read(b, off, len);
			if (len < 0) {
				if (!inf.finished())
					throw new ZipException("Inflater not finished!?");
				avail = inf.getRemaining();
				if ((flags & 8) != 0)
					readDataDescr();
				if (inf.getTotalIn() != csize || inf.getTotalOut() != size)
					throw new ZipException("size mismatch: " + csize + ";"
							+ size + " <-> " + inf.getTotalIn() + ";"
							+ inf.getTotalOut());
				inf.reset();
				finished = true;
			}
			break;
		case ZipOutputStream.STORED:
			if (len > csize && csize >= 0)
				len = csize;
			len = readBuf(b, off, len);
			if (len > 0) {
				csize -= len;
				size -= len;
			}
			if (csize == 0)
				finished = true;
			else if (len < 0)
				throw new ZipException("EOF in stored block");
			break;
		}
		this.hook37(b, off, len);
		if (finished) {
			this.hook39();
			entry = null;
			entryAtEOF = true;
		}
		return len;
	}
	// #endif

	/**
	 * Closes the zip file.
	 * 
	 * @exception IOException
	 *                if a i/o error occured.
	 */
	public void close() throws IOException {
		super.close();
		// #if EXTRACT
		this.hook40();
		entry = null;
		entryAtEOF = true;
		// #endif
	}

	// #if EXTRACT
	/**
	 * Creates a new zip entry for the given name. This is equivalent to new
	 * ZipEntry(name).
	 * 
	 * @param name
	 *            the name of the zip entry.
	 */
	protected ZipEntry createZipEntry(String name) {
		return new ZipEntry(name);
	}
	// #endif

}
