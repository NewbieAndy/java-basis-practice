package com.newbieandy.netty.aio;

public class TimeClient {
    public static void main(String[] args) {
        int port = 8080;
        new Thread(new AsyncTimeClientHandler(null, port)).start();
    }
}
