package frank.hex;

public class HexTest {

	public static void main(String[] args) {

		System.out.println(toHexString(0001));
		System.out.println(toHexString("0001"));
		
//		System.out.println("50484952485250525048485453575150494950464852".length()); // 44
		System.out.println("2014042420065932112.04".length());
		
		for(Byte b : "2014042420065932112.04".getBytes())
			System.out.print(b + "");
		// 22个字符 == 22*2字节 
		
		System.out.println();
		System.out.println(toHexString("2014042420065932112.04"));
		

		System.out.println(toStringHex(toHexString("2014042420065932112.04")));
	}

	public static String toHexString(int c) {
		return Integer.toHexString(c);
	}

	public static String toHexString(String s) {
		String str = "";
		for (int i = 0; i < s.length(); i++) {
			int ch = (int) s.charAt(i);
			String s4 = Integer.toHexString(ch);
			str = str + s4;
		}
		return str;
	}
	
	public static String toStringHex(String s) {
		byte[] baKeyword = new byte[s.length() / 2];
		for (int i = 0; i < baKeyword.length; i++) {
			try {
				baKeyword[i] = (byte) (0xff & Integer.parseInt(
						s.substring(i * 2, i * 2 + 2), 16));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			s = new String(baKeyword, "utf-8");// UTF-16le:Not
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return s;
	}
	
	
}
