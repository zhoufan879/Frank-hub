package frank.netty5.error.client;

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
		ByteBuf buf = (ByteBuf) msg;
		byte[] req = new byte[buf.readableBytes()];
		buf.readBytes(req);
		
		String body = new String(req, "UTF-8");
		System.out.println("Now is: " + body);
		System.out.println(++counter);
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		byte[] req = "Q".getBytes();
//		ByteBuf firstMsg = Unpooled.buffer(req.length);
//		firstMsg.writeBytes(req);
//		ctx.writeAndFlush(firstMsg);
		
		ByteBuf firstMsg = null;
		
		/*
		 * 粘包
		 * */
		for (int i = 0; i < 100; i++) {
			firstMsg = Unpooled.buffer(req.length);
			firstMsg.writeBytes(req);
			ctx.writeAndFlush(firstMsg);
		}
	}

}
