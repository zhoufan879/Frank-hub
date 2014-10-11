package frank.hex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinaryTest {
	public static String byte2hex(byte[] b) { // 二进制转字符串
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1)
				hs = hs + "0" + stmp;
			else
				hs = hs + stmp;
		}
		return hs;
	}

	public static byte[] hex2byte(String str) { // 字符串转二进制
		if (str == null)
			return null;
		str = str.trim();
		int len = str.length();
		if (len == 0 || len % 2 == 1)
			return null;

		byte[] b = new byte[len / 2];
		try {
			for (int i = 0; i < str.length(); i += 2) {
				b[i / 2] = (byte) Integer
						.decode("0x" + str.substring(i, i + 2)).intValue();
			}
			return b;
		} catch (Exception e) {
			return null;
		}
	}
	
	public static void saveFile(byte[] b) {
//		FileInputStream fis=new FileInputStream("文件路径");
		FileOutputStream out = null;
		try {
			out = new FileOutputStream("F:\\log\\test.dat");
		    out.write(b);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		String str = "123456";
		String result = "";
		
		saveFile(hex2byte(str));
		
		result = byte2hex(str.getBytes());
		System.out.println(str.getBytes());
		System.out.println(result);
		System.out.println(new String(hex2byte(result)));
		System.out.println(hex2byte(result).toString());
		
		System.out.println("\r\n");
		
		
		String ascii = "";
		String wb = "HbFGB24706/o.beQrsb/90411mcoiw";
		
		for(int i = 0; i < wb.length(); i++ ){
			char c = wb.charAt(i);
			int a = (int)c;
			ascii += a + ",";
			System.out.println(c + " = " + a);
		}

		System.out.println("\r\n");
		
//		String ascii = "72,104,70,71,66,50,52,55,48,54,47,111,46,98,101,81,114,115,98,47,57,48,52,49,49,109,99,111,105,119";
		for(String a : ascii.split(",")){
			System.out.println(Integer.toBinaryString(Integer.parseInt(a)));
		}
	}
}
