package frank.nio.timeserver;

public class TimeServer {

	public static void main(String[] args) {
		int port = 8881;
		
		MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
		new Thread(timeServer, "NIO-MuliplexerTimerServer-001").start();
	}

}
