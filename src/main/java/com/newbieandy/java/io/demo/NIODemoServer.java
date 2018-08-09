package com.newbieandy.java.io.demo;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

public class NIODemoServer implements Runnable {
    @Override
    public void run() {
        //创建selector和channel
        try (Selector selector = Selector.open();
             ServerSocketChannel serverSocket = ServerSocketChannel.open();) {
            serverSocket.bind(new InetSocketAddress(InetAddress.getLocalHost(), 8888));
            serverSocket.configureBlocking(false);
            //注册到selector并说明关注点
            serverSocket.register(selector, SelectionKey.OP_ACCEPT);
            while (true) {
                System.out.println("select before..");
                //阻塞等待就绪的channel,这是关注点之一
                selector.select();
                System.out.println("select after..");
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    SelectableChannel channel = key.channel();
                    sayHelloWorld((ServerSocketChannel) channel);
                    iterator.remove();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sayHelloWorld(ServerSocketChannel serverSocketChannel) throws IOException {
        try (SocketChannel accept = serverSocketChannel.accept();) {
            accept.write(Charset.defaultCharset().encode("NIO Hello World!"));
        }
    }

    public static void main(String[] args) {
        new Thread(new NIODemoServer()).start();
    }
}
