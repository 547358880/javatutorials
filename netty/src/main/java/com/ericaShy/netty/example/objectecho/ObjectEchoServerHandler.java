package com.ericaShy.netty.example.objectecho;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.List;

public class ObjectEchoServerHandler extends ChannelInboundHandlerAdapter
{

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception
    {
        List<Integer> list = (List<Integer>) msg;

        System.out.println(list);

        ctx.write(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception
    {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception
    {
        cause.printStackTrace();
        ctx.close();
    }
}
