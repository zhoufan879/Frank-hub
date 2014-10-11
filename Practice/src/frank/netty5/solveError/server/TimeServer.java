package frank.netty5.solveError.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * 计算时间戳服务
 * 
 * @author pengfch  zengcl@cybbj.com
 * @filename com.cybbj.services.netty.TimeServer.java
 * @filedesc 
 * @createdate Mar 14, 2010
 * @changelog
 *   
	     ┏┓　　　┏┓ 
	 ┏┛┻━━━┛┻┓ 
	 ┃　　　　　　　┃ 　 
	 ┃　　　━　　　┃ 
	 ┃　┳┛　┗┳　┃ 
	 ┃　　　　　　　┃ 
	 ┃　　　┻　　　┃ 
	 ┃　　　　　　　┃ 
	 ┗━┓　　　┏━┛ 
	         ┃　　　┃   神兽保佑，代码无BUG！ 　　　　　　　　　 
	         ┃　　　┃   Code is far away from bugs with the animal protection   
	         ┃            ┃  
	         ┃　　　┗━━━┓ 
	         ┃　　　　　　　┣┓ 
	         ┃　　　　　　　┏┛ 
	         ┗┓┓┏━┳┓┏┛ 
	             ┃┫┫　┃┫┫ 
	             ┗┻┛　┗┻┛ 
       
 */
public class TimeServer {

	public static void main(String[] args) {
		new TimeServer().run();
	}
	
	public void run() {
		int port = 4001;
		
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup);
			b.channel(NioServerSocketChannel.class);
			b.option(ChannelOption.SO_BACKLOG, 1024);
			b.childHandler(new ChildChannelHandler());
			
			ChannelFuture cf = b.bind(port).sync();
			System.out.println("The time server is start.");
			cf.channel().closeFuture().sync();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}
	
	private class ChildChannelHandler extends ChannelInitializer<SocketChannel> {

		@Override
		protected void initChannel(SocketChannel ch) throws Exception {
			ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
			ch.pipeline().addLast(new StringDecoder());
			ch.pipeline().addLast(new TimeServerHandler());
		}
		
	}
}
