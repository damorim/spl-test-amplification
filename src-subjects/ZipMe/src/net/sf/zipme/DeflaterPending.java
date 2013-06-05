//

package net.sf.zipme;

/**
 * This class stores the pending output of the Deflater.
 * 
 * @author Jochen Hoenicke
 * @date Jan 5, 2000
 */
class DeflaterPending  
//#if BASE
extends PendingBuffer 
//#endif
{
	public DeflaterPending() {
		//#if BASE
		super(DeflaterConstants.PENDING_BUF_SIZE);
		//#endif
	}
}
