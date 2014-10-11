package frank.codec;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.digest.DigestUtils;

public class CodecTest {

	public static void main(String[] args) throws UnsupportedEncodingException {
		byte[] b = DigestUtils.md5("2014042420065932112.04");	// [72, 18, 42, -8, 71, -7, -82, 108, 55, -118, 30, 9, 48, 22, -98, 27]
		
		String s = new String(b,"ISO-8859-1");			
		System.out.println(s.length());
		
		System.out.println(s.getBytes("ISO-8859-1").length);

		System.out.println(DigestUtils.md5Hex("123456"));
		
		System.out.println("yyyyMMssHHmiss".length());
	}

}
