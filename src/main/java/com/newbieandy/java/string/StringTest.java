package com.newbieandy.java.string;

import java.util.*;

public class StringTest {
    public static void main(String[] args) {
//        String str1 = new String("a") + new String("b");
//        String str2 = "ab";
//        String intern = str1.intern();
//        System.out.println(str2 == intern);
//        System.out.println(str1 == str2);
//        System.out.println(str1.equals(str2));
//        System.out.println(convertStr("hello ll"));
//        System.out.println(countChar("hello ll"));
        String head = "99650106";
        long strat = System.currentTimeMillis();
        Set<String> set = generateRandomNumber(head, 200000);
        System.out.println(System.currentTimeMillis() - strat);
        System.out.println(set.size());
        //9 96 50 10 64 46 61 10 16 82
        //9 89 62 21 37 22 02 02 46 74
    }


    private static Set<String> generateRandomNumber(String head, int count) {
        Set<String> result = new HashSet<String>(count);
        Random random = new Random();
        int c = 0;

        while (result.size() < count) {
            c++;
            StringBuilder number = new StringBuilder();
            for (int i = 0; i < 10; i++) {
                number.append(random.nextInt(10));
            }
            result.add(head + calculateCheck(head, number.toString()) + number.toString());
        }
        System.out.println("count:" + c);
        return result;
    }

    private static int calculateCheck(String head, String tail) {
        int check = (
                head.charAt(2)
                        + head.charAt(3)
                        + head.charAt(4)
                        + head.charAt(5) * 2
                        + head.charAt(6)
                        + head.charAt(7)
                        + tail.charAt(0)
                        + tail.charAt(1)
                        + tail.charAt(2)
                        + tail.charAt(3)
                        + tail.charAt(4)
                        + tail.charAt(5)
                        + tail.charAt(6)
                        + tail.charAt(7)
                        + tail.charAt(8) * 2
        ) % 10;
        return check > 0 ? 10 - check : 0;
    }

    private static String convertStr(String str) {
        char[] chars = str.toCharArray();
        int length = chars.length;
        char[] newStr = new char[length];
        for (int i = 0; i < length; i++) {
            newStr[i] = chars[length - 1 - i];
        }
        return new String(newStr);
    }

    private static Map<Character, Integer> countChar(String str) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            Integer integer = map.get(aChar);
            if (null == integer) {
                map.put(aChar, 1);
            } else {
                map.put(aChar, ++integer);
            }
        }
        return map;
    }
}
