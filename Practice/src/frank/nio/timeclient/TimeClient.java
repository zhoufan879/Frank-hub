package frank.nio.timeclient;

public class TimeClient {
	
	public static void main(String[] args) {
		new Thread(new TimeClientHandle("127.0.0.1", 8881), "TimeClient-001").start();
	}
}
