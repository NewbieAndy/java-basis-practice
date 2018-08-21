package com.newbieandy.java.io.nio;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CopyTest {

    public static void main(String[] args) throws IOException {
        String sourceFilePath = "D:/BaiduNetdiskDownload/中国居民膳食指南_2016.pdf";
        String targetFilePath = "D:/BaiduNetdiskDownload/中国居民膳食指南Copy_2016.pdf";
//        copyFileByStream(new File(sourceFilePath), new File(targetFilePath));
//        copyFileByChannel(new File(sourceFilePath),new File(targetFilePath));
        Files.copy(Paths.get(sourceFilePath), Paths.get(targetFilePath));
    }


    private static void copyFileByStream(File source, File target) throws IOException {
        try (InputStream in = new FileInputStream(source);
             OutputStream out = new FileOutputStream(target)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer);
            }
        }
    }

    private static void copyFileByChannel(File source, File target) {
        try (FileChannel sourceFC = new FileInputStream(source).getChannel();
             FileChannel targetFc = new FileOutputStream(target).getChannel()) {
            for (long count = sourceFC.size(); count > 0; ) {
                long transfered = sourceFC.transferTo(sourceFC.position(), count, targetFc);
                sourceFC.position(sourceFC.position() + transfered);
                count -= transfered;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
