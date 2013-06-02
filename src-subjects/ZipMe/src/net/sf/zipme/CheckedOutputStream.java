//

package net.sf.zipme;
import java.io.IOException;
import java.io.OutputStream;

/** 
 * OutputStream that computes a checksum of data being written using a
 * supplied Checksum object.
 * @see Checksum
 * @author Tom Tromey
 * @date May 17, 1999
 */
public class CheckedOutputStream extends OutputStream {
	
  /** 
 * This is the subordinate <code>OutputStream</code> that this class
 * redirects its method calls to.
 */
  protected OutputStream out;
  
  /** 
 * Creates a new CheckInputStream on top of the supplied OutputStream
 * using the supplied Checksum.
 */
  public CheckedOutputStream(  OutputStream out,  Checksum cksum){
	  //#if BASE
	    this.out=out;
	    this.sum=cksum;
	  //#endif
  }
  
  /** 
 * Returns the Checksum object used. To get the data checksum computed so
 * far call <code>getChecksum.getValue()</code>.
 */
  public Checksum getChecksum(){
	  //#if BASE
		  return sum;
	  //#endif
  }
  
  /** 
 * Writes one byte to the OutputStream and updates the Checksum.
 */
  public void write(  int bval) throws IOException {
	  //#if BASE
	    out.write(bval);
	  //#if ADLER32CHECKSUM
	    sum.update(bval);
	  //#endif
	  //#endif
  }
  
  /** 
 * This method writes all the bytes in the specified array to the underlying
 * <code>OutputStream</code>.  It does this by calling the three parameter
 * version of this method - <code>write(byte[], int, int)</code> in this
 * class instead of writing to the underlying <code>OutputStream</code>
 * directly.  This allows most subclasses to avoid overriding this method.
 * @param buf The byte array to write bytes from
 * @exception IOException If an error occurs
 */
  public void write(  byte[] buf) throws IOException {
	  //#if BASE
		  write(buf,0,buf.length);
		//#endif
  }
  
  /** 
 * Writes the byte array to the OutputStream and updates the Checksum.
 */
  public void write(  byte[] buf,  int off,  int len) throws IOException {
	  //#if BASE
	    out.write(buf,off,len);
	  //#if ADLER32CHECKSUM
	    sum.update(buf,off,len);
	  //#endif
	  //#endif
  }
  
  /** 
 * This method closes the underlying <code>OutputStream</code>.  Any
 * further attempts to write to this stream may throw an exception.
 * @exception IOException If an error occurs
 */
  public void close() throws IOException {
	  //#if BASE
	    flush();
	    out.close();
	  //#endif
  }
  
  /** 
 * This method attempt to flush all buffered output to be written to the
 * underlying output sink.
 * @exception IOException If an error occurs
 */
  public void flush() throws IOException {
	  //#if BASE
		  out.flush();
		//#endif
  }
  
  /** 
 * The checksum object. 
 */
  private Checksum sum;
}
