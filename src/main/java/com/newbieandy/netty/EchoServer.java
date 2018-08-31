package com.newbieandy.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

public class EchoServer {
    private final int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public void start() throws Exception {
        final EchoServiceHandler serviceHandler = new EchoServiceHandler();
        //创建EventLoopGroup
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            //创建ServerBootstrap
            ServerBootstrap b = new ServerBootstrap();
            b.group(group)
                    //指定所使用的NIO传输Channel
                    .channel(NioServerSocketChannel.class)
                    //指定端口地址
                    .localAddress(new InetSocketAddress(port))
                    //添加EchoServerHandler到子Channel的channelPipeline
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            //
                            socketChannel.pipeline().addLast(serviceHandler);
                        }
                    });
            //异步绑定服务器,调用sync()方法阻塞等待直到绑定完成
            ChannelFuture f = b.bind().sync();
            //获取Channel的closeFuture(),并阻塞当前线程直到完成
            f.channel().closeFuture().sync();
        } finally {
            //关闭 EvenLoopGroup,释放资源
            group.shutdownGracefully().sync();
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Usage: " + EchoServer.class.getSimpleName() + "<port>");
        }
        int port = Integer.valueOf(args[0]);
        new EchoServer(port).start();
    }
}
