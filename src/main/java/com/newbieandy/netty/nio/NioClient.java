package com.newbieandy.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class NioClient {
    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        SocketChannel sc = SocketChannel.open();
        sc.configureBlocking(false);
        sc.socket().setReuseAddress(true);
        sc.socket().setReceiveBufferSize(1024);
        sc.socket().setSendBufferSize(1024);
        boolean connected = sc.connect(new InetSocketAddress(8080));
        if (connected) {
            sc.register(selector, SelectionKey.OP_READ);
        } else {
            sc.register(selector, SelectionKey.OP_CONNECT);
        }
    }

}
