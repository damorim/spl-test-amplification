//#if CLEANER
package com.sleepycat.je.cleaner;
import com.sleepycat.je.dbi.MemoryBudget;
/** 
 * Delta file summary info for a tracked file.  Tracked files are managed by
 * the UtilizationTracker.
 * <p>The methods in this class for reading obsolete offsets may be used by
 * multiple threads without synchronization even while another thread is adding
 * offsets.  This is possible because elements are never deleted from the
 * lists.  The thread adding obsolete offsets does so under the log write
 * latch to prevent multiple threads from adding concurrently.</p>
 */
public class TrackedFileSummary extends FileSummary {
  private UtilizationTracker tracker;
  private long fileNum;
  private OffsetList obsoleteOffsets;
//#if MEMORYBUDGET
  private int memSize;
//#endif
  private boolean trackDetail;
  private boolean allowFlush=true;
  /** 
 * Creates an empty tracked summary.
 */
  TrackedFileSummary(  UtilizationTracker tracker,  long fileNum,  boolean trackDetail){
    this.tracker=tracker;
    this.fileNum=fileNum;
    this.trackDetail=trackDetail;
  }
  /** 
 * Returns whether this summary is allowed or prohibited from being flushed
 * or evicted during cleaning.  By default, flushing is allowed.
 */
  public boolean getAllowFlush(){
    return allowFlush;
  }
  /** 
 * Allows or prohibits this summary from being flushed or evicted during
 * cleaning.  By default, flushing is allowed.
 */
  void setAllowFlush(  boolean allowFlush){
    this.allowFlush=allowFlush;
  }
  /** 
 * Returns the file number being tracked.
 */
  public long getFileNumber(){
    return fileNum;
  }
//#if MEMORYBUDGET
  /** 
 * Return the total memory size for this object.  We only bother to budget
 * obsolete detail, not the overhead for this object, for two reasons:
 * 1) The number of these objects is very small, and 2) unit tests disable
 * detail tracking as a way to prevent budget adjustments here.
 */
  int getMemorySize(){
    return memSize;
  }
//#endif
  /** 
 * Overrides reset for a tracked file, and is called when a FileSummaryLN
 * is written to the log.
 * <p>Must be called under the log write latch.</p>
 */
  public void reset(){
    obsoleteOffsets=null;
    tracker.resetFile(this);
//#if MEMORYBUDGET
    if (memSize > 0) 
//#if MEMORYBUDGET
{
      updateMemoryBudget(0 - memSize);
    }
//#endif
//#endif
    super.reset();
  }
  /** 
 * Tracks the given offset as obsolete or non-obsolete.
 * <p>Must be called under the log write latch.</p>
 */
  void trackObsolete(  long offset){
    if (!trackDetail) {
      return;
    }
//#if MEMORYBUDGET
    int adjustMem=0;
//#endif
    if (obsoleteOffsets == null) {
      obsoleteOffsets=new OffsetList();
//#if MEMORYBUDGET
      adjustMem+=MemoryBudget.TFS_LIST_INITIAL_OVERHEAD;
//#endif
    }
    if (obsoleteOffsets.add(offset,tracker.getEnvironment().isOpen())) {
//#if MEMORYBUDGET
      adjustMem+=MemoryBudget.TFS_LIST_SEGMENT_OVERHEAD;
//#endif
    }
//#if MEMORYBUDGET
    if (adjustMem != 0) 
//#if MEMORYBUDGET
{
      updateMemoryBudget(adjustMem);
    }
//#endif
//#endif
  }
  /** 
 * Adds the obsolete offsets as well as the totals of the given object.
 */
  void addTrackedSummary(  TrackedFileSummary other){
    add(other);
    if (other.obsoleteOffsets != null) {
      if (obsoleteOffsets != null) {
        if (obsoleteOffsets.merge(other.obsoleteOffsets)) {
//#if MEMORYBUDGET
          updateMemoryBudget(-MemoryBudget.TFS_LIST_SEGMENT_OVERHEAD);
//#endif
        }
      }
 else {
        obsoleteOffsets=other.obsoleteOffsets;
      }
    }
  }
  /** 
 * Returns obsolete offsets as an array of longs, or null if none.
 */
  public long[] getObsoleteOffsets(){
    if (obsoleteOffsets != null) {
      return obsoleteOffsets.toArray();
    }
 else {
      return null;
    }
  }
  /** 
 * Returns whether the given offset is present in the tracked offsets.
 * This does not indicate whether the offset is obsolete in general, but
 * only if it is known to be obsolete in this version of the tracked
 * information.
 */
  boolean containsObsoleteOffset(  long offset){
    if (obsoleteOffsets != null) {
      return obsoleteOffsets.contains(offset);
    }
 else {
      return false;
    }
  }
//#if MEMORYBUDGET
  private void updateMemoryBudget(  int delta){
    memSize+=delta;
    tracker.getEnvironment().getMemoryBudget().updateMiscMemoryUsage(delta);
  }
//#endif
}
//#endif
