package com.newbieandy.java.io.demo;

import java.io.IOException;
import java.nio.channels.Selector;

public class NIODemoServer implements Runnable {
    @Override
    public void run() {
        try (Selector selector = Selector.open();
             //todo NIOTEST
        ) {

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
