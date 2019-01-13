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
        FileChannel fileChannel = new FileInputStream(new File(sourcePath)).getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        int read = fileChannel.read(byteBuffer);


        FileChannel goalFileChannel = new FileOutputStream(new File(goalPath)).getChannel();
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(1024);
    }
}
