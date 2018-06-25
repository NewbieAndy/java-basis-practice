package com.newbieandy.java.io.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class RequestHandler implements Runnable {
    private Socket socket;

    public RequestHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (PrintWriter out = new PrintWriter(socket.getOutputStream())) {
            out.println(Thread.currentThread().getName());
            out.println("Hello world!");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
