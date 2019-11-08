package com.ericaShy.netty.echo;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;

public class EchoClient
{
    static final String HOST = "localhost";

    static final int PORT = 8099;

    public static void main(String[] args) throws Exception
    {
        EventLoopGroup worker = new NioEventLoopGroup();

        try {

            Bootstrap b = new Bootstrap();
            b.group(worker)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {

                        }
                    });

            Channel channel = b.connect(HOST, PORT).sync().channel();

            ByteBuf buf = Unpooled.copiedBuffer("Hello world", CharsetUtil.UTF_8);

            channel.writeAndFlush(buf);

            channel.closeFuture().sync();

        } finally {
            worker.shutdownGracefully();
        }

    }
}
