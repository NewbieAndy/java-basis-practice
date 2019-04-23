package com.newbieandy.netty.file;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author chao.ma
 * @Date 2019/4/22 17:06
 * @Version 1.0
 */
public class FileTest {
    public static void main(String[] args) throws IOException {
        String path = System.getProperty("user.dir");
        String filePath = path + "\\src\\main\\resources\\file\\test.txt";
        RandomAccessFile file = new RandomAccessFile(filePath, "rw");
        FileChannel channel = file.getChannel();
        String contect = "13487987423|北京市海淀区|全球通|VIP用户|";
        ByteBuffer buffer = ByteBuffer.allocate(128);
        buffer.put(contect.getBytes());
        buffer.flip();
        channel.write(buffer);
        channel.close();
    }
}
