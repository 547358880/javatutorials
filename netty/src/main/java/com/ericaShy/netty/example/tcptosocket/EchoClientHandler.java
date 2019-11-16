package com.ericaShy.netty.example.tcptosocket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EchoClientHandler extends SimpleChannelInboundHandler<String>
{
    private static final Logger log = LoggerFactory.getLogger(EchoClientHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception
    {
        log.error("client receive data: " + s);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception
    {
        cause.printStackTrace();
        ctx.close();
    }
}
