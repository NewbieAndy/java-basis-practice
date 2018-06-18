package com.newbieandy.java.io.nio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by mchao on 2016/11/12.
 */
public class NioReadTest {
    private final static int UNIT_NUM = 100000;

    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        List<String> collect = list.parallelStream().map(s -> {
            if ("b" == s) {
                return null;
            }
            return s;
        }).collect(Collectors.toList());
        System.out.println(collect);

        List<String> collect1 = list.parallelStream().filter(s -> {
                    if (s == "a") {
                        System.out.println(s);
                        return false;
                    } else {
                        return true;
                    }
                }
        ).collect(Collectors.toList());
        System.out.println(collect1);


        List<String> collect2 = list.parallelStream().map(s -> {
            if ("b" == s) {
                return null;
            }
            return s;
        }).filter(str->{
            if (null == str) {
                System.out.println("过滤掉的信息");
                return false;
            } else {
                return true;
            }
        }).collect(Collectors.toList());
        System.out.println(collect2);
//        LocalDateTime parse = LocalDateTime.parse("2017-08-18 09:51:22", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//        System.out.println(parse);
//        fileDistinctTest();
//        newFileDistinctTest();

//        System.out.println(123/32234);
//        String a = "81589008609\t\tC3700000000065507679\t2016-04-21 14:25:39";
//        System.out.println(a);
//        a = a.replaceAll("\t+", "\t");
//        a = a.replaceAll("\t+", "\t");
//        System.out.println(a);
//        fileTreeTest();
//        fileSpilTest();
//        String fileUrl = "C:\\Users\\Mtime\\Desktop\\card2membersyn\\card2member0821.txt";
//        Path path = Paths.get(fileUrl);
//        String fileName = path.getFileName().toString();
//        String fileDirUrl = fileUrl.substring(0, fileUrl.indexOf(fileName) - 1);
//        String subDirUrl = fileDirUrl + File.separator + "subdir";
//        Path subdir = Paths.get(subDirUrl);
//        if (Files.exists(subdir)){
//        }
//        Files.deleteIfExists(subdir);
//        Files.createDirectory(subdir);
//        for (int i=0;i<10;i++){
//            String s = subDirUrl + File.separator + i + ".txt";
//            Path path1 = Paths.get(s);
//            Files.deleteIfExists(path1);
//            Files.createFile(path1);
//        }
//        System.out.println(fileDirUrl);

//        String s = "12,34-56,78";
//        if (s.contains("-")) {
//            List<String> list = Arrays.asList(s.split("-"));
//            for (String s1 : list) {
//                if (s1.contains(",")) {
//                    String[] split = s1.split(",");
//                    System.out.println(split[0]);
//                    System.out.println(split[1]);
//                }
//            }
//        }
//        String[] split = s.split("-");

//        String pathUrl = "C:\\Users\\Mtime\\IdeaProjects\\card-info\\card-info-task\\src\\main\\resources\\etc\\changemember.txt";
//        Path path = Paths.get(pathUrl);
//        List<String> list = Files.readAllLines(path);
//        int idx = 1;
//        for (String s : list) {
//            String[] strings = s.split(",");
//            System.out.println(strings[0]);
//            System.out.println(strings[1]);
//            idx++;
//        }
//        System.out.println(idx);
//        System.out.println(list.size());
    }


    /**
     * 装机目录
     */
    private static Path createFile() throws IOException {
        Path filePath = Paths.get("");
        if (Files.exists(filePath)) {
            Files.delete(filePath);
        }
        Path path = Files.createFile(filePath);
        return path;
    }


    private static synchronized void fileSpilTest() throws IOException {
        String basePath = "C:\\Users\\Mtime\\Desktop\\card2membersyn";
        Path path1 = Paths.get(basePath + File.separator + "card2member0821.txt");
        BufferedReader bufferedReader = Files.newBufferedReader(path1);
        String line = null;
        int lineNum = 1;
        Path path2 = Paths.get(basePath + File.separator + "c2m" + lineNum + ".txt");
        Files.createFile(path2);
        BufferedWriter bufferedWriter = null;
        bufferedWriter = Files.newBufferedWriter(path2, Charset.defaultCharset());
        while (null != (line = bufferedReader.readLine())) {
            System.out.println(lineNum + ":" + line);

            if (0 == lineNum % 10000) {
                Path path = Paths.get(basePath + File.separator + "c2m" + lineNum + ".txt");
                Files.createFile(path);
                bufferedWriter = Files.newBufferedWriter(path, Charset.defaultCharset());
            }
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            lineNum++;
        }
        bufferedReader.close();
    }

    private static void fileTreeTest() throws IOException {
        Path path1 = Paths.get("C:\\Users\\Mtime\\Desktop\\card2membersyn");
        DirectoryStream<Path> paths = Files.newDirectoryStream(path1);
        for (Path path : paths) {
            System.out.println(path.getFileName());
        }
        paths.close();
    }

    private static void fileExistTest() {
        String fileName = "C:\\Users\\Mtime\\Documents\\Tencent Files\\411684828\\FileRecv\\1Nonick.txt";
        boolean exists = Files.exists(Paths.get(fileName), LinkOption.NOFOLLOW_LINKS);
        System.out.println(exists);
    }


    /**
     * 数据去重
     */
    private static void newFileDistinctTest() throws IOException {
        String fileName = "D:\\test\\Nocmc.txt";
        List<String> allLines = Files.readAllLines(Paths.get(fileName), Charset.defaultCharset());
        Map<String, String> stringListMap = new HashMap<>();
        int size = allLines.size();
        System.out.println(allLines.size());
        for (int i = 0; i < size; i++) {
            String s = allLines.get(i);
            String[] split = s.split("\t");
            String s1 = split[0].trim();
            stringListMap.put(s1, s);
            System.out.println("进度:" + (i + 1) + "/" + size);
        }
        System.out.println(stringListMap.size());
        allLines.clear();
        for (String s : stringListMap.values()) {
            allLines.add(s);
        }
        System.out.println(allLines.size());

    }

    private static void fileDistinctTest() throws IOException {
        String fileName = "D:\\test\\Nocmc.txt";

        List<String> allLines = Files.readAllLines(Paths.get(fileName), Charset.defaultCharset());
        System.out.println(allLines.size());
        Map<String, List<String>> stringListMap = new HashMap<>();
        allLines.forEach(s -> {
            String[] split = s.split("\t");
            String s1 = split[0];
            String s2 = split[1];
//            String s3 = split[2];
//            timeStrConvertToDate(s3);

            List<String> strings = stringListMap.get(s1);
            if (null == strings) {
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(s);
                stringListMap.put(s1, arrayList);
            } else {
                strings.add(s);
            }
        });

        System.out.println(stringListMap.size());
//        System.setOut(new PrintStream("D:\\cardlist.txt"));
        String fileName1 = "D:\\test\\Nocmc1.txt";
        Path logFile = Paths.get(fileName1);
        if (Files.exists(logFile)) {
            Files.delete(logFile);
        }
        Path file = Files.createFile(Paths.get(fileName1));
        BufferedWriter bufferedWriter = Files.newBufferedWriter(file, StandardCharsets.UTF_8, StandardOpenOption.WRITE);
        for (Map.Entry<String, List<String>> entry : stringListMap.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (value.size() > 1) {
//                System.out.println("cardNumber:"+key+"->memberNo"+value);
                bufferedWriter.write("cardNumber:" + key + "->memberNo" + value);
                bufferedWriter.newLine();
            }
        }
    }

    private static void fileTest() throws IOException {
        String fileName = "C:\\Users\\Mtime\\Documents\\Tencent Files\\411684828\\FileRecv\\Nonick.txt";
        List<String> allLines = Files.readAllLines(Paths.get(fileName), Charset.defaultCharset());
        int size = allLines.size();
        System.out.println("lines:" + size);
        int times = getTreatingTimesByTotalNum(size, UNIT_NUM);
        int startIdx = 0;
        int endIdx = 0;
        List<String> subLines = null;
        for (int i = 1; i <= times; i++) {
            startIdx = (i - 1) * UNIT_NUM;
            endIdx = i * UNIT_NUM;
            if (i == times) {
                endIdx = size;
            }
            subLines = allLines.subList(startIdx, endIdx);
            for (String line : subLines) {
                String[] split = line.split("\t");
                String cardNumber = split[0];
                String memberCode = split[1];
            }
        }
    }

    /**
     * 根据需要生码的数量,获取需要处理的次数
     *
     * @param totalNum 总数量
     * @param unitNum  每次处理数量
     * @return 需要处理的次数
     */
    private static int getTreatingTimesByTotalNum(int totalNum, int unitNum) {
        if (totalNum <= 0 || unitNum == 0) {
            return 0;
        }
        int model = totalNum % unitNum;
        if (0 == model) {
            return totalNum / unitNum;
        }
        return totalNum / unitNum + 1;
    }

    /**
     * 字符串转时间类型
     */
    private static LocalDateTime timeStrConvertToDate(String dateTimeStr) {
        return LocalDateTime.parse("2017-08-18 09:51:22", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
