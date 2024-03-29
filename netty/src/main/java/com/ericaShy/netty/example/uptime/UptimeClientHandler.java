package com.ericaShy.netty.example.uptime;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

import java.util.concurrent.TimeUnit;

@ChannelHandler.Sharable
public class UptimeClientHandler extends SimpleChannelInboundHandler<Object>
{
    long startTime = -1;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception
    {
        if (startTime < 0) {
            startTime = System.currentTimeMillis();
        }
        println("Connected to: " + ctx.channel().remoteAddress());
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception
    {

    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception
    {
        if (!(evt instanceof IdleStateEvent)) {
            return;
        }

        IdleStateEvent e = (IdleStateEvent) evt;
        if (e.state() == IdleState.READER_IDLE) {
            println("Disconnection due to no inbound traffic");
            ctx.close();
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception
    {
        println("Disconnection from " + ctx.channel().remoteAddress());
    }

    /*
        当Channel从它的EventLoop注销并且无法处理任何IO时被调用
     */
    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception
    {
        println("Sleeping for: " + UptimeClient.RECONNECT_DELAY + 's');

        ctx.channel().eventLoop().schedule(new Runnable() {
            @Override
            public void run() {
                println("Reconnection to: " + UptimeClient.HOST + ":" + UptimeClient.PORT);
                UptimeClient.connect();
            }
        }, UptimeClient.RECONNECT_DELAY, TimeUnit.SECONDS);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception
    {
        cause.printStackTrace();
        ctx.close();
    }

    void println(String msg)
    {
        if (startTime < 0) {
            System.out.println("Current thread is : " + Thread.currentThread().getName());
            System.err.format("[SERVER IS DOWN] %s%n", msg);
        } else {
            System.out.println("Current thread is : " + Thread.currentThread().getName());
            System.err.format("[UPTIME: %5ds] %s%n", (System.currentTimeMillis() - startTime) / 1000, msg);
        }
    }
}
