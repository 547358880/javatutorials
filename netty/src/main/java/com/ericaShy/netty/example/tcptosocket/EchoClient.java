package com.ericaShy.netty.example.tcptosocket;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;


public class EchoClient
{
    static final String host = "localhost";
    static final int port = 8099;

    public static void main(String[] args) throws Exception
    {
        EventLoopGroup group = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap();

            b.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new StringEncoder(), new StringDecoder(), new EchoClientHandler());
                        }

                    });

            Channel channel = b.connect(host, port).sync().channel();


            ByteBuf buf = Unpooled.unreleasableBuffer(Unpooled.buffer());
            ByteBuffer writeBuffer = ByteBuffer.allocate(32);

            try (BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {
                String userInput;
                while ((userInput = stdIn.readLine()) != null) {
//                    buf.writeBytes(userInput.getBytes());
//                    channel.writeAndFlush(buf);

                    writeBuffer.put(userInput.getBytes());
                    writeBuffer.flip();
                    writeBuffer.rewind();

                    // 转为ByteBuf
                    ByteBuf buf1 = Unpooled.copiedBuffer(writeBuffer);

                    // 写消息到管道
                    channel.writeAndFlush(buf1);

                    // 清理缓冲区
                    writeBuffer.clear();
                }
            }


            channel.closeFuture().sync();

        } finally {
            group.shutdownGracefully();
        }
    }
}
