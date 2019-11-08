package com.ericaShy.netty.example.echo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;

public class EchoServerHandler extends ChannelInboundHandlerAdapter
{
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception
    {
        ByteBuf buf = (ByteBuf) msg;
        System.out.println("server read data " + buf.toString(CharsetUtil.UTF_8));
        ctx.write(msg);

//        buf.release();
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception
    {
        System.out.println("fire read complete");
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception
    {
        cause.printStackTrace();
        ctx.close();
    }
}
