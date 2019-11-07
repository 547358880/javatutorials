package com.ericaShy.netty.example.http.websocketx.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.handler.ssl.SslHandler;
import io.netty.util.CharsetUtil;

public class WebSocketIndexPageHandler extends SimpleChannelInboundHandler<FullHttpRequest>
{
    private final String websocketPath;

    public WebSocketIndexPageHandler(String websocketPath)
    {
        this.websocketPath = websocketPath;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest request) throws Exception
    {
        // Handle a bad request
        if (!request.decoderResult().isSuccess()) {
            sendHttpResponse(ctx, request, new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_REQUEST, Unpooled.EMPTY_BUFFER));
            return;
        }

        // Allow only get methods
        if (!HttpMethod.GET.equals(request.method())) {
            sendHttpResponse(ctx, request, new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.FORBIDDEN, Unpooled.EMPTY_BUFFER));
            return;
        }

        // Send the index page
        if ("/".equals(request.uri()) || "/index.html".equals(request.uri())) {
            String webSocketLocation = getWebSocketLocation(ctx.pipeline(), request, websocketPath);
            ByteBuf content = WebSocketServerIndexPage.getContent(webSocketLocation);

            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);
            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/html; charset=utf-8");
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());
            sendHttpResponse(ctx, request, response);
        } else {
            sendHttpResponse(ctx, request, new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.NOT_FOUND, Unpooled.EMPTY_BUFFER));
        }
    }

    private static String getWebSocketLocation(ChannelPipeline pipeline, HttpRequest request, String path)
    {
        String protocol = "ws";
        if (pipeline.get(SslHandler.class) != null) {
            protocol = "wss";
        }
        return protocol + "://" + request.headers().get(HttpHeaderNames.HOST) + path;
    }

    private static void sendHttpResponse(ChannelHandlerContext ctx, FullHttpRequest request, FullHttpResponse response)
    {
        if (response.status().code() != 200) {
            ByteBuf buf = Unpooled.copiedBuffer(response.status().toString(), CharsetUtil.UTF_8);
            response.content().writeBytes(buf);
            buf.release();
            HttpUtil.setContentLength(request, response.content().readableBytes());
        }

        if (!HttpUtil.isKeepAlive(request) || response.status().code() != 200) {
            response.headers().set(HttpHeaderNames.CONNECTION, HttpHeaderValues.CLOSE);
            ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
        } else {
            if (request.protocolVersion().equals(HttpVersion.HTTP_1_0)) {
                response.headers().set(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);
            }
            ctx.writeAndFlush(response);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception
    {
        cause.printStackTrace();
        if (ctx.channel().isActive()) {
            ctx.close();
        }
    }
}
