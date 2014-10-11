package frank.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.apache.commons.lang3.RandomStringUtils;

/*
 * New I/O
 * */
public class NIOTest {

	private static final String FILE_NAME = "F:/To+be+best.txt";
	
	public static void main(String[] args) {
		write();
		
		read();
	}
	
	// read 
	public static void read(){
		try {
			FileInputStream fin = new FileInputStream(new File(FILE_NAME));
			FileChannel fc = fin.getChannel();
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			fc.read(buffer);
			fc.close();
			fin.close();
			
			String s = new String(buffer.array(),"GBK");
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
			String src = "\r\n"+RandomStringUtils.randomAscii(20);
			
			FileOutputStream fos = new FileOutputStream(new File(FILE_NAME), true);
			FileChannel fc = fos.getChannel();
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			buffer.put(src.getBytes());

			buffer.flip();
			fc.write(buffer);
		
			fc.close();
			fos.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
