package com.ericaShy.netty.echo;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class Test2Handler extends SimpleChannelInboundHandler<String>
{
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception
    {
        System.out.print("Test2Handler");

        ctx.fireChannelRead(msg);

        System.out.println(msg);
    }
}
