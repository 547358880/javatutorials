package com.ericaShy.netty.example.tcptosocket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EchoServerHandler extends ChannelInboundHandlerAdapter
{
    private static final Logger log = LoggerFactory.getLogger(EchoServerHandler.class);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception
    {
        String str = (String) msg;
        log.error(ctx.channel().remoteAddress() + " -> Server :" + str);

        ctx.write(msg);
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception
    {
        cause.printStackTrace();
        ctx.close();
    }
}
