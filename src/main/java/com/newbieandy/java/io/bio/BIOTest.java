package com.newbieandy.java.io.bio;

import java.io.*;

/**
 * 传统BIO测试,使用传统IO实现文件的复制,与文本的传输
 * inputstream,reader--从文件向内存读取
 * outputstream,writer--从内存向外写
 */
public class BIOTest {
    public static void main(String[] args) throws IOException {
        fileCopyTest();
    }

    /**
     * 文件复制测试
     */
    private static void fileCopyTest() throws IOException {
        String sourceFilePath = "/Users/andy/IdeaProjects/java-basis-practice/src/main/resources/iotest/txts/subFile1.txt";
        String targetFilePath="/Users/andy/IdeaProjects/java-basis-practice/src/main/resources/iotest/txts/subFile1_copy.txt";

        FileInputStream fileInputStream = new FileInputStream(new File(sourceFilePath));
        FileOutputStream fileOutputStream = new FileOutputStream(new File(targetFilePath));
        //设置缓冲区
        byte [] buffer = new byte[1024];
        while (-1 !=fileInputStream.read(buffer)){
            fileOutputStream.write(buffer);
        }

        fileInputStream.close();
        fileOutputStream.close();
    }
}
