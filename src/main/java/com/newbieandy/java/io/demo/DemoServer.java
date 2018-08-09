package com.newbieandy.java.io.demo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DemoServer implements Runnable {
    private ServerSocket serverSocket;

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(8888);
            ExecutorService threadPool = Executors.newFixedThreadPool(5);
            while (true) {
                System.out.println("before accept");
                Socket socket = serverSocket.accept();
                System.out.println("after accept");
                RequestHandler requestHandler = new RequestHandler(socket);
                threadPool.execute(requestHandler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != serverSocket) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        DemoServer demoServer = new DemoServer();
        new Thread(demoServer).start();
    }
}
