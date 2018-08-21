package com.newbieandy.java.io.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class IOAndNIOTest {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\trywithresource\\";
        String sourcePath = path + "niotest.txt";
        IOTest(sourcePath);
        System.out.println("===========");
        NIOTest(sourcePath);
    }

    private static void IOTest(String sourcePath) {
        InputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream(sourcePath));
            byte[] buffer = new byte[1024];
            int bythesRead = in.read(buffer);
            while (-1 != bythesRead) {
                for (int i = 0; i < bythesRead; i++) {
                    System.out.println((char) buffer[i]);
                }
                bythesRead = in.read(buffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void NIOTest(String sourcePath) {
        RandomAccessFile aFile = null;
        try {
            aFile = new RandomAccessFile(sourcePath, "rw");
            FileChannel aFileChannel = aFile.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

            int byteRead = aFileChannel.read(byteBuffer);
            System.out.println(byteRead);
            while (-1 != byteRead) {
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()) {
                    System.out.println((char) byteBuffer.get());
                }
                byteBuffer.compact();
                byteRead = aFileChannel.read(byteBuffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
