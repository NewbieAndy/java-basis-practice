package com.newbieandy.java.io.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class DemoClient {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            try (Socket client = new Socket(InetAddress.getLocalHost(), 9991)) {
                InputStream inputStream = client.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                bufferedReader.lines().forEach(System.out::println);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
