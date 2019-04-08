package com.newbieandy.netty.nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {
    public static void main(String[] args) throws IOException {

        //打开通道
        ServerSocketChannel acceptorSer = ServerSocketChannel.open();
        //绑定端口，设置为非阻塞
        int prot = 8080;
        acceptorSer.socket().bind(new InetSocketAddress(InetAddress.getByName("IP"), prot));
        acceptorSer.configureBlocking(false);
        //创建多路复用器
        Selector selector = Selector.open();
        new Thread(new ReactorTask()).start();
        //把channel注册到selector上，监听accept事件
        Object ioHandler = null;
        acceptorSer.register(selector, SelectionKey.OP_ACCEPT, ioHandler);
        int num = selector.select();
        Set<SelectionKey> keys = selector.selectedKeys();
        Iterator<SelectionKey> iterator = keys.iterator();
        while (iterator.hasNext()) {
            SelectionKey next = iterator.next();
            //todo
        }

    }
}
