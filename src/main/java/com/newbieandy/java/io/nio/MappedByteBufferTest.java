package com.newbieandy.java.io.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MappedByteBufferTest {
    public static void main(String[] args) {
        String filePath = "D:/BaiduNetdiskDownload/中国居民膳食指南 _2016.pdf";
        byteBufferTest(filePath);
        mappedByteBufferTest(filePath);
    }

    private static void byteBufferTest(String filePath) {
        RandomAccessFile accessFile = null;
        FileChannel fileChannel = null;
        try {
            accessFile = new RandomAccessFile(filePath, "rw");
            fileChannel = accessFile.getChannel();

            long begin = System.currentTimeMillis();
            ByteBuffer buffer = ByteBuffer.allocate((int) accessFile.length());
            System.out.println("buffer is Direct:" + buffer.isDirect());
            buffer.clear();
            fileChannel.read(buffer);
            long end = System.currentTimeMillis();
            System.out.println("Read Time:" + (end - begin) + " ms");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (accessFile != null) {
                    accessFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void mappedByteBufferTest(String path) {
        RandomAccessFile accessFile = null;
        FileChannel fileChannel = null;
        try {
            accessFile = new RandomAccessFile(path, "rw");
            fileChannel = accessFile.getChannel();
            long begin = System.currentTimeMillis();
            MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, accessFile.length());
            System.out.println("mappedByteBuffer is Direct:" + mappedByteBuffer.isDirect());
            long end = System.currentTimeMillis();
            System.out.println("Mapped Read Time:" + (end - begin) + " ms");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (accessFile != null) {
                    accessFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
