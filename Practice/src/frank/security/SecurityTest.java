package frank.security;

import java.io.File;

public class SecurityTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		new SecurityTest().getClass()
//		System.out.println(System.getSecurityManager().toString());
		
		getFileLength();
	}
	
	public static void getFileLength(){
		File file = new File("F:\\weibo\\weibo\\xjpactice.jpg");
		System.out.println(file.length());
		System.out.println(file.isFile());
		System.out.println(file.toString());
		
		System.out.println("d:/demo/testTaskFile/bde_file/".contains("s"));
	}

}
