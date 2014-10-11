package frank.netty4;
//package frank.netty4.demo;
//
//import io.netty.bootstrap.Bootstrap;
//import io.netty.channel.Channel;
//import io.netty.channel.ChannelFuture;
//import io.netty.channel.EventLoopGroup;
//import io.netty.channel.nio.NioEventLoopGroup;
//import io.netty.channel.socket.nio.NioSocketChannel;
//
//public class HelloClient {
//
//	public static void main(String[] args) {
//		new HelloClient().run();
//	}
//	
//	public void run() {
//		String ip = "192.168.2.139";
//		int port = 4001;
//		
//		EventLoopGroup group = new NioEventLoopGroup();
//		
//		try {
//			Bootstrap b = new Bootstrap();
//			b.group(group);
//			b.channel(NioSocketChannel.class);
//			b.handler(new HelloClientInitializer());
//			
//			ChannelFuture cf = b.connect(ip, port);
//			cf.sync();
//			Channel c = cf.channel();
//			
//			c.writeAndFlush("hello,server! \r\n");
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
////			group.shutdownGracefully();
//		}
//	}
//}
