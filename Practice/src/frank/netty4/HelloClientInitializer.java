package frank.netty4;
//package frank.netty4.demo;
//
//import io.netty.channel.ChannelInitializer;
//import io.netty.channel.ChannelPipeline;
//import io.netty.channel.socket.SocketChannel;
//import io.netty.handler.codec.DelimiterBasedFrameDecoder;
//import io.netty.handler.codec.Delimiters;
//import io.netty.handler.codec.string.StringDecoder;
//import io.netty.handler.codec.string.StringEncoder;
//
//public class HelloClientInitializer extends ChannelInitializer<SocketChannel> {
//
//	@Override
//	protected void initChannel(SocketChannel sc) throws Exception {
//		ChannelPipeline pipeline = sc.pipeline();
//		
//		pipeline.addLast("framer", new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
//		
//		pipeline.addLast("decoder", new StringDecoder());
//		pipeline.addLast("encoder", new StringEncoder());
//		
//		pipeline.addLast("handler", new HelloClientHandler());
//	}
//
//}
