package com.newbieandy.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Test {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //绑定监听地址
        serverSocketChannel.bind(new InetSocketAddress(8080));
        //设置非阻塞
        serverSocketChannel.configureBlocking(false);
        Selector selector = Selector.open();
        new Thread(new Reactor(selector)).start();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT, new Handler());

    }
}

class Reactor implements Runnable {
    private Selector selector;

    public Reactor(Selector selector) {
        this.selector = selector;
    }

    @Override
    public void run() {
        try {
            int select = selector.select();
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = keys.iterator();
            while (iterator.hasNext()) {
                SelectionKey next = iterator.next();
                //todo
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Handler implements Runnable {

    @Override
    public void run() {

    }
}
