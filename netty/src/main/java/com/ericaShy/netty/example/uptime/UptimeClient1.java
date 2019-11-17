package com.ericaShy.netty.example.uptime;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

public class UptimeClient1
{
    static final String HOST = System.getProperty("host", "localhost");

    static final int PORT = Integer.parseInt(System.getProperty("port", "8099"));

    // Sleep 5 seconds before a reconnection attempt
    static final int RECONNECT_DELAY = Integer.parseInt(System.getProperty("reconnectDelay", "5"));

    // Reconnect when the server sends nothing for 10 seconds
    private static final int READ_TIMEOUT = Integer.parseInt(System.getProperty("readTimeout", "20"));

    private static final UptimeClientHandler handler = new UptimeClientHandler();


    public static void start() throws Exception {

        Bootstrap b = new Bootstrap();

        EventLoopGroup group = new NioEventLoopGroup();

        b.group(group)
                .channel(NioSocketChannel.class)
                .remoteAddress(HOST, PORT)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception
                    {
                    }
                });

        ChannelFuture future = b.connect().sync();
        //客户端断线重连逻辑
        future.addListener((ChannelFutureListener) future1 -> {
            if (future1.isSuccess()) {
                System.out.println("连接Netty服务端成功");
            } else {
                System.out.println("连接失败，进行断线重连");
//                future.channel().eventLoop().schedule(() -> start(), 20, TimeUnit.SECONDS);  // ?阻塞线程
            }
        });
    }

    public static void main(String[] args) throws Exception
    {
        start();
    }
}
