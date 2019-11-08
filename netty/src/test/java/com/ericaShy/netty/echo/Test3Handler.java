package com.ericaShy.netty.echo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class Test3Handler extends SimpleChannelInboundHandler<ByteBuf>
{
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception
    {
        System.out.print("Test3Handle========");

        System.out.println("Test3Handle========" + msg);

        ctx.fireChannelRead(msg.retain());


    }
}
