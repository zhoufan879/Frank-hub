package frank.netty5.solveError.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class TimeClientHandler extends ChannelHandlerAdapter {
	
	private int counter;

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		System.out.println("Unexpected exception from downstream: " + cause.getMessage());
		ctx.close();
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		String body = (String) msg;
		System.out.println("Now is: " + body);
		System.out.println(++counter);
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		byte[] req = ("Q"+System.getProperty("line.separator")).getBytes();	
//		ByteBuf firstMsg = Unpooled.buffer(req.length);
//		firstMsg.writeBytes(req);
//		ctx.writeAndFlush(firstMsg);
		
		ByteBuf firstMsg = null;
		for (int i = 0; i < 100; i++) {
			firstMsg = Unpooled.buffer(req.length);
			firstMsg.writeBytes(req);
			ctx.writeAndFlush(firstMsg);
		}
	}

}
