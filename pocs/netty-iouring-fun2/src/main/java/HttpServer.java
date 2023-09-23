import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.*;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.CharsetUtil;

import java.nio.channels.SocketChannel;

public class HttpServer {

    public static void main(String[] args) throws Exception{
        HttpServer server = new HttpServer();
        server.port=8080;
        server.run();
    }

    private int port;

    public void run() throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        ServerBootstrap b = new ServerBootstrap();
        b.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .handler(new LoggingHandler(LogLevel.INFO))
                .childHandler(new ChannelInitializer() {
                    @Override
                    protected void initChannel(Channel channel) throws Exception {
                        ChannelPipeline p = channel.pipeline();
                        p.addLast(new HttpRequestDecoder());
                        p.addLast(new HttpResponseEncoder());
                        p.addLast(new CustomHttpServerHandler());
                    }
                });
        try{
            ChannelFuture f = b.bind(port)
                    .sync();
            f.channel()
                    .closeFuture()
                    .sync();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    class CustomHttpServerHandler extends SimpleChannelInboundHandler {
        private HttpRequest request;
        StringBuilder responseData = new StringBuilder();

        @Override
        protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
            if (msg instanceof HttpRequest) {
                HttpRequest request = this.request = (HttpRequest) msg;

                if (HttpUtil.is100ContinueExpected(request)) {
                    HttpServer.this.writeResponse(ctx);
                }
                responseData.setLength(0);
                responseData.append(RequestUtils.formatParams(request));
            }

            responseData.append(RequestUtils.evaluateDecoderResult(request));

            if (msg instanceof HttpContent) {
                HttpContent httpContent = (HttpContent) msg;
                responseData.append(RequestUtils.formatBody(httpContent));
                responseData.append(RequestUtils.evaluateDecoderResult(request));
                if (msg instanceof LastHttpContent) {
                    LastHttpContent trailer = (LastHttpContent) msg;
                    responseData.append(RequestUtils.prepareLastResponse(request, trailer));
                    writeResponse(ctx, trailer, responseData);
                }
            }
        }

        private void writeResponse(ChannelHandlerContext ctx, LastHttpContent trailer, StringBuilder responseData) {
            boolean keepAlive = HttpUtil.isKeepAlive(request);

            FullHttpResponse httpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, ((HttpObject) trailer).decoderResult()
                    .isSuccess() ?
                            HttpResponseStatus.OK :
                            HttpResponseStatus.BAD_REQUEST,
                Unpooled.copiedBuffer(responseData.toString(), CharsetUtil.UTF_8));

            httpResponse
                    .headers()
                    .set(HttpHeaderNames.CONTENT_TYPE, "text/plain; charset=UTF-8");

            if (keepAlive) {
                httpResponse
                        .headers()
                        .setInt(HttpHeaderNames.CONTENT_LENGTH, httpResponse.content()
                        .readableBytes());

                httpResponse
                        .headers()
                        .set(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);
            }

            ctx.write(httpResponse);
            if (!keepAlive) {
                ctx.writeAndFlush(Unpooled.EMPTY_BUFFER)
                        .addListener(ChannelFutureListener.CLOSE);
            }
        }

    }

    private void writeResponse(ChannelHandlerContext ctx) {
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.CONTINUE, Unpooled.EMPTY_BUFFER);
        ctx.write(response);
    }

}