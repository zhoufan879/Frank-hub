package frank.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;


/*
 * Old I/O
 * */
public class OIOTest {

	private static final String FILE_NAME = "F:/To+be+best.txt";
	
	public static void main(String[] args) {
		write();
		
		read();
	}
	
	// read 
	public static void read(){
		try {
			FileInputStream fin = new FileInputStream(new File(FILE_NAME));
			byte[] b = new byte[fin.available()];
			fin.read(b);
			fin.close();
			
			String s = new String(b,"GBK");
			System.out.println("print: "+ s);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// write
	public static void write(){
		try {
			FileOutputStream fos = new FileOutputStream(new File(FILE_NAME),true);
			fos.write(new Date().toString().getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
