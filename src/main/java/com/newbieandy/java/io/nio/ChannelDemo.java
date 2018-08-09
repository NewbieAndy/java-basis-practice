package com.newbieandy.java.io.nio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelDemo {
    private static final String BASE_PASH = System.getProperty("user.dir") + File.separator + "file";

    public static void main(String[] args) throws IOException {
        String filePath = BASE_PASH + File.separator + "strfile_source.txt";
        RandomAccessFile aFile = new RandomAccessFile(filePath, "rw");
        FileChannel fileChannel = aFile.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(48);
        int read = fileChannel.read(byteBuffer);
        while (-1 != read) {
            System.out.println("read:" + read);
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                System.out.print((char) byteBuffer.get());
            }
            byteBuffer.clear();
            read = fileChannel.read(byteBuffer);
        }
        aFile.close();
    }
}
