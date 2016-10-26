package demo.util;

import java.io.UnsupportedEncodingException;

public class CharsetConvertTest {

	// encoding converting like this only work when the bytes is encoded in iso-8859-1
	public static void main(String[] args) throws UnsupportedEncodingException {
		final String ISO = "iso-8859-1";
		
		final String ORI_ENC = "UTF-16";
		final String TRANS_ENC = ISO;
		
		String hi_ori = "你好.txt";
		
		String hi_enc = new String(hi_ori.getBytes(ORI_ENC), TRANS_ENC);
		
		String hi_conv = new String(hi_enc.getBytes(TRANS_ENC), ORI_ENC);
		
		System.out.println(hi_ori);
		System.out.println(hi_enc);
		System.out.println(hi_conv);
	}
	
}
