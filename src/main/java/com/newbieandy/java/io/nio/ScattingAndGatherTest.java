package com.newbieandy.java.io.nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ScattingAndGatherTest {

    public static void main(String[] args) throws IOException {
        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\trywithresource\\";
        String targetPath = path + "scattingAndGather.txt";
        gatherTest(targetPath);
    }

    private static void gatherTest(String targetFilePath) throws IOException {
        ByteBuffer header = ByteBuffer.allocate(10);
        ByteBuffer body = ByteBuffer.allocate(10);
        byte[] h = {'0', '1'};
        byte[] b = {'3', '4'};
        header.put(h);
        body.put(b);
        ByteBuffer[] byteBuffers = {header, body};
        FileOutputStream os = new FileOutputStream(targetFilePath);
        FileChannel fileChannel = os.getChannel();
        System.out.println(byteBuffers);
        fileChannel.write(byteBuffers);
    }
}
