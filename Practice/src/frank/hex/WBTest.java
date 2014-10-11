package frank.hex;

/*
 * http://weibo.com/1610470492/BbGsFrbQH
 * 
 * 自打来广州，远离至亲，无聊至极
 * 
 * 闲聊中，得到一个号码，可以无厘头的找对方扯淡；常常想是不是可以选择一个陪自己唠嗑的人慢慢到老。
 * 
 * ......
 * 
 * 两边相隔不过150公里，认识半年来，只见过一面；出题者似乎陷入了单相思。
 * 
 * ......
 * 
 * 阿笨，笔者有个极其不好的习惯，就是会在各种不经意间思念着某人。 放心，知道你不喜欢烦人、粘人的人，不会告诉你的。:P
 * 
 * */
public class WBTest {
	
	private static final String code = "weibo.com/1610470492/BbGsFrbQH";
	
	public static String fences(String s) {
		String s1 = "", s2 = "";
		for(int i = 0; i < s.length(); ){
			s1 += s.charAt(i);
			i = i + 2;
		}
		for(int j = 1; j < s.length(); ){
			s1 += s.charAt(j);
			j = j + 2;
		}
		System.out.println("栅栏加密： " + ( s1 + s2 ));
		System.out.println("\n");
		return s1 + s2;
	}
	
	public static String reverse(String s){
		StringBuffer sb = new StringBuffer(s);
		String result = sb.reverse().toString();
		System.out.println("反转倒序： " + result);
		return result;
	}
	
	public static String getAscii(String wb) {
		String ascii = "";
		
		for(int i = 0; i < wb.length(); i++ ){
			char c = wb.charAt(i);
			int a = (int)c;
			ascii += a + ",";
			System.out.println(c + " = " + a);
		}
		
		System.out.println("ASCII： " + ascii);
		System.out.println("\n");
//		String ascii = "72,104,70,71,66,50,52,55,48,54,47,111,46,98,101,81,114,115,98,47,57,48,52,49,49,109,99,111,105,119";
		return ascii;
	}
	
	public static String displayBin(String ascii){
		String bin = "";
		for(String a : ascii.split(",")){
			bin += Integer.toBinaryString(Integer.parseInt(a)) + " ";
		}
		System.out.println("二进制： " + bin);
		System.out.println("\n");
		return bin;
	}
	
	public static Integer[] to10(String s) {
		String [] split = s.split(" ");
		Integer[] s10 = new Integer[split.length];
		for (int i = 0; i < split.length; i++ ) {
			String str = split[i];
			s10[i] = Integer.parseInt(str, 2);
			System.out.println(s10[i]);
		}
		System.out.println("解 十进制： " + s10);
		return s10;
	}
	
	public static String toHex(Integer [] integer) {
		String hex = "";
		for (int i : integer) {
			hex += String.valueOf((char)i);
		}

		System.out.println("解 ASCII： " + hex);
		return hex;
	}
	
	public static String toStr(String s) {
		String s1 = "";
		int half = s.length() / 2; // 0 1 2 3
		for(int i = 0; i < s.length()/2; i++ ){
			s1 += s.charAt(i);
			s1 += s.charAt(i+half);
		}
		System.out.println("栅栏解密： " + s1 );
		return s1;
	}
	
	// 加密
	public static String encode(String s) {
		System.out.println("============== 加密 ==================");
		String wb = "";
		
		// 1. 栅栏
		wb = fences(s);
		
		// 2. 倒序
		wb = reverse(wb);
		
		// 3. ASCII
		String ascii = getAscii(wb);
		
		// 4. 二进制
		wb = displayBin(ascii);
		
		return wb;
	}
	
	// 解密
	public static String decryption(String s) {
		System.out.println("============== 解密 ==================");
		String wb = "";
		
		// 1. 解二进制，得到十进制
		Integer[] i = to10(s);
		
		// 2. ASCII 转成字符
		wb = toHex(i);
		
		// 3. 倒序
		wb = reverse(wb);
		
		// 4. 
		wb = toStr(wb);
		
		return wb;
	}
	
	public static void main(String[] args) {
		String e = encode(code);
		decryption(e);
	}
}
