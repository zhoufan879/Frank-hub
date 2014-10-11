package frank.hex;

import java.io.UnsupportedEncodingException;

public class Util {
	public Util() {
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		System.out.println("中".getBytes("utf-16").length);
		System.out.println("中".getBytes("utf-8").length);
		System.out.println("中".getBytes("gbk").length);
		System.out.println("中".getBytes().length);
		System.out.println("a".getBytes().length);
		
		int i = 0;
		System.out.println(i);
		
//		
//		printHexString("0","2014042420065932112.04".getBytes());
//		System.out.println(Bytes2HexString("2014042420065932112.04".getBytes()));
//		
//		System.out.println(HexString2Bytes("2014042420065932112.04"));
		
//		System.out.println(HexString2Bytes("0001AB92830109123456")); // [0, 1, -85, -110, -125, 1, 9, 18]
//		
//		System.out.println(Bytes2HexString(HexString2Bytes("0001AB92830109123456")));
//		
//
//		System.out.println(HexString2Bytes2("0001AB92830109123456")); // 
		
		System.out.println(HexString2Bytes2("22232014042115203125566"));
		
		byte[] b = HexString2Bytes2("22232014042115203125566");
		System.out.println(Bytes2HexString(b));
		
//		System.out.println(HexString2Bytes2("123"));
//		
//		System.out.println(0xff);
//		System.out.println(Integer.toHexString(100));
		
	}

	/**
	 * 将指定byte数组以16进制的形式打印到控制台
	 * 
	 * @param hint
	 *            String
	 * @param b
	 *            byte[]
	 * @return void
	 */
	public static void printHexString(String hint, byte[] b) {
		System.out.print(hint);
		for (int i = 0; i < b.length; i++) {
			String hex = Integer.toHexString(b[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			System.out.print(hex.toUpperCase() + " ");
		}
		System.out.println("");
	}

	/**
	 * 
	 * @param b
	 *            byte[]
	 * @return String
	 */
	public static String Bytes2HexString(byte[] b) {
		String ret = "";
		for (int i = 0; i < b.length; i++) {
			String hex = Integer.toHexString(b[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			ret += hex.toUpperCase();
		}
		return ret;
	}

	/**
	 * 将两个ASCII字符合成一个字节； 如："EF"--> 0xEF
	 * 
	 * @param src0
	 *            byte
	 * @param src1
	 *            byte
	 * @return byte
	 */
	public static byte uniteBytes(byte src0, byte src1) {
		byte _b0 = Byte.decode("0x" + new String(new byte[] { src0 }))
				.byteValue();
		_b0 = (byte) (_b0 << 4);
		byte _b1 = Byte.decode("0x" + new String(new byte[] { src1 }))
				.byteValue();
		byte ret = (byte) (_b0 ^ _b1);
		return ret;
	}

	/**
	 * 将指定字符串src，以每两个字符分割转换为16进制形式 如："2B44EFD9" --> byte[]{0x2B, 0x44, 0xEF,
	 * 0xD9}
	 * 
	 * @param src
	 *            String
	 * @return byte[]
	 */
	public static byte[] HexString2Bytes(String src) {
		byte[] ret = new byte[8];
		byte[] tmp = src.getBytes();
		for (int i = 0; i < 8; i++) {
			ret[i] = uniteBytes(tmp[i * 2], tmp[i * 2 + 1]);
		}
		return ret;
	}
	
    public static byte[] HexString2Bytes2(String src) {
        if (null == src || 0 == src.length()) {
            return null;
        }
        byte[] ret = new byte[src.length() / 2];
        byte[] tmp = src.getBytes();
        for (int i = 0; i < (tmp.length / 2); i++) {
            ret[i] = uniteBytes(tmp[i * 2], tmp[i * 2 + 1]);
        }
        return ret;
    }

}
