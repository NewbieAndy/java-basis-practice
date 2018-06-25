package com.newbieandy.java.io.bio;

import java.io.*;

/**
 * 传统BIO测试,使用传统IO实现文件的复制,与文本的传输
 * inputstream,reader--从文件向内存读取
 * outputstream,writer--从内存向外写
 */
public class BIOTest {
    private static final String BASE_PASH = System.getProperty("user.dir") + File.separator + "file";

    public static void main(String[] args) throws IOException {
//        copyTest1();
        copyTest2();
    }

    /**
     * 从源文件逐行读取,写入到目标文件
     */
    private static void copyTest1() throws IOException {
        File sourceFile = new File(BASE_PASH + File.separator + "strfile_source.txt");
        File targetFile = new File(BASE_PASH + File.separator + "strfile_target.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(sourceFile));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(targetFile));
        String line;
        while (null != (line = bufferedReader.readLine())) {
            if (line.trim().isEmpty()) {
                continue;
            }
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }
        bufferedReader.close();
        bufferedWriter.close();
    }

    private static void copyTest2() throws IOException {
        File sourceFile = new File(BASE_PASH + File.separator + "picture.jpg");
        File targetFile = new File(BASE_PASH + File.separator + "picture_copy.jpg");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(sourceFile));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(targetFile));
        byte[] buffer = new byte[2];
        while (-1 != bufferedInputStream.read(buffer)) {
            bufferedOutputStream.write(buffer);
            bufferedOutputStream.flush();
        }
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }
}
