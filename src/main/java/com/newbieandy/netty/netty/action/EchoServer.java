package com.newbieandy.netty.netty.action;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

public class EchoServer {
    private int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws InterruptedException {
        new EchoServer(8080).start();
    }

    //启动方法
    public void start() throws InterruptedException {
        EchoServerHandler serverHandler = new EchoServerHandler();
        //创建线程组
        EventLoopGroup group = new NioEventLoopGroup();
        //创建启动器
        ServerBootstrap bootstrap = new ServerBootstrap();
        try {
            //绑定线程组
            bootstrap.group(group)
                    //设置channel
                    .channel(NioServerSocketChannel.class)
                    //使用指定端口
                    .localAddress(new InetSocketAddress(port))
                    //
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(serverHandler);
                        }
                    });

            //异步绑定服务器,调用sync方法阻塞等待绑定完成
            ChannelFuture future = bootstrap.bind().sync();
            //获取channel的closeFuture,并阻塞当前线程，直到它完成
            future.channel().closeFuture().sync();
        } finally {
            //优雅关闭线程组
            group.shutdownGracefully().sync();
        }

    }
}
