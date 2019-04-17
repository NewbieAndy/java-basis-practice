package com.newbieandy.netty.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

public class TimeClient {
    public void connect(int port, String host) throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) {
                            socketChannel.pipeline().addLast(new LineBasedFrameDecoder(1024));
                            socketChannel.pipeline().addLast(new StringDecoder());
                            socketChannel.pipeline().addLast(new TimeClientHandler());
                        }
                    });
            //发起异步连接操作
            ChannelFuture channelFuture = bootstrap.connect(host, port).sync();
            //等待客户端关闭链路
            channelFuture.channel().closeFuture().sync();
        } finally {
            //优雅退出
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new TimeClient().connect(8080, "127.0.0.1");
    }

    private static class TimeClientHandler extends ChannelHandlerAdapter {
        private int counter;
        private byte[] req;

        private TimeClientHandler() {
            this.req = ("QUERY TIME ORDER" + System.getProperty("line.separator")).getBytes();
        }

        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            ByteBuf message = null;
            for (int i = 0; i < 100; i++) {
                message = Unpooled.buffer(req.length);
                message.writeBytes(req);
                ctx.writeAndFlush(message);
            }
        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            String body = (String) msg;
//            ByteBuf buf = (ByteBuf) msg;
//            byte[] req = new byte[buf.readableBytes()];
//            buf.readBytes(req);
//            String body = new String(req, "UTF-8");
            System.out.println("Now is: " + body + " ; the counter is:" + ++counter);
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            //释放资源
            System.out.println("捕获异常" + cause.getMessage());
            ctx.close();
        }
    }
}
