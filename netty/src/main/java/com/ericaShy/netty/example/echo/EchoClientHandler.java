package com.ericaShy.netty.example.echo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

public class EchoClientHandler extends ChannelInboundHandlerAdapter
{
    private final ByteBuf message = Unpooled.unreleasableBuffer(Unpooled.copiedBuffer("Hello World", CharsetUtil.UTF_8));

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception
    {
        System.out.println("connection");

//        ByteBuf byteBuf =
        for (int i = 0; i < 5; i++) {
            ctx.writeAndFlush(message);

            try {
                Thread.sleep(5000);
            } catch (Exception e) {}
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception
    {
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println("client read data" + byteBuf.toString(CharsetUtil.UTF_8));

        byteBuf.release();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception
    {
        cause.printStackTrace();
        ctx.close();
    }
}
