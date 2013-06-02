// DerivativeCompressGZIP

package net.sf.zipme;

class GZIPOutputStream_hook22 {
	GZIPOutputStream_hook22(GZIPOutputStream _this, byte[] gzipFooter) {
		//#if DERIVATIVE_COMPRESS_GZIP
			this._this = _this;
			this.gzipFooter = gzipFooter;
		//#endif
	}

	void execute() {
		//#if DERIVATIVE_COMPRESS_GZIPCRC
			crcval=(int)(_this.crc.getValue() & 0xffffffff);
		    gzipFooter[0]=(byte)crcval;
		    gzipFooter[1]=(byte)(crcval >> 8);
		    gzipFooter[2]=(byte)(crcval >> 16);
		    gzipFooter[3]=(byte)(crcval >> 24);
		//#endif
	}

	protected GZIPOutputStream _this;
	protected byte[] gzipFooter;
	protected int crcval;
}
