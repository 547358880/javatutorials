package com.ericaShy.netty.echo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class Test1Handler extends SimpleChannelInboundHandler<ByteBuf>
{
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception
    {
        System.out.println("Test1Handle");

//        ctx.fireChannelRead(msg.retain());

        ctx.fireChannelRead(msg);

        System.out.println("Test1Handle========" + msg);
    }
}
