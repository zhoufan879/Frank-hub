package frank.socket2;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;


public class SocketTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SocketTest().socket2();
	}
	
	public boolean socket() {
		boolean b = false;
		String sNettyServceHost = "192.168.137.1";    
		String sNettyServicePort = "4001";    
		
		try {
			Socket sock = new Socket(sNettyServceHost, Integer.parseInt(sNettyServicePort));
			OutputStream out = sock.getOutputStream();
			InputStream sin = sock.getInputStream();
			byte buf [] = new byte[1];	
			buf = "0".getBytes();
			out.write(buf);
			System.out.println("send ok --->   Out: " + out);
			byte ibuf[] = new byte[4];
			int len = sin.read(ibuf);
			String s = new String(ibuf, 0, len-1);
			String reqData = new String(ibuf).replace("\r", "").replace("\n", "") ; 
			System.err.println("reqData is "+reqData);
			
			if(reqData!=null)
				b = true;
		} catch (Exception e) {
			e.printStackTrace();
			b = false;
		}
		
		return b;
	}
	
	public boolean socket2() {
		boolean b = false;
		String sNettyServceHost = "192.168.2.111";    
		String sNettyServicePort = "4001";    
		
		try {
			Socket sock = new Socket(sNettyServceHost, Integer.parseInt(sNettyServicePort));
			OutputStream out = sock.getOutputStream();
			InputStream sin = sock.getInputStream();
			
//			byte buf [] = new byte[1];	
//			buf = "0".getBytes();
//			out.write(buf);
//			System.out.println("send ok --->   Out: " + out);
//			byte ibuf[] = new byte[4];
//			int len = sin.read(ibuf);
//			String s = new String(ibuf, 0, len-1);
			
			String s1 = "1005";
			out.write(s1.getBytes());
			System.out.println("send ok --->   Out: " + s1);
			
			// SUCC
			byte ibuf[] = new byte[1024];
			int len = sin.read(ibuf);
			String s = new String(ibuf, 0, len);
			
			// XF
//			byte ibuf[] = new byte[1024];
//			int len = -1;
//			ByteArrayOutputStream buff = new ByteArrayOutputStream();
//			while ((len = sin.read(ibuf)) != -1) {
//				System.out.println("读取的数据长度"+len);
//				buff.write(ibuf, 0, len);
//			}
//			byte[] data = buff.toByteArray();
//			String result = new String(data);
//			System.out.println(result);
			
//			BufferedReader reader = new BufferedReader(new InputStreamReader(sin));
			
			String reqData = new String(ibuf).trim().replace("\r", "").replace("\n", "") ; 
//			String reqData = reader.readLine();
			System.out.println("reqData is "+reqData);
			System.out.println("reqData is "+s);
			
			if(reqData!=null)
				b = true;
		} catch (Exception e) {
			e.printStackTrace();
			b = false;
		}
		
		return b;
	}

}
