package com.newbieandy.java.io.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by mchao on 2016/11/12.
 */
public class NioTest {
    public static void main(String[] args) throws IOException {
//        StringBuffer buffer = new StringBuffer();

        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\trywithresource\\";
        String sourcePath = path + "niotest.txt";
        String goalPath = path + "niotest1.txt";

        FileInputStream fileInputStream = new FileInputStream(new File(sourcePath));
        FileOutputStream fileOutputStream = new FileOutputStream(new File(goalPath));
        FileChannel inChannel = fileInputStream.getChannel();
        FileChannel outChannel = fileOutputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (true) {
            buffer.clear();
            int read = inChannel.read(buffer);
            if (read == -1) {
                break;
            }
            buffer.flip();
            outChannel.write(buffer);
        }

    }
}
