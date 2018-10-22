package com.newbieandy.java.bit;

import java.util.UUID;

public class bitOperationTest {
    public static void main(String[] args) {
//        int a = -103457;
//        System.out.println(a);
//        System.out.println(~a);
        //1537510413875
        //1537510444739
//        System.out.println(System.currentTimeMillis());
//        System.out.println("1<<1:" + (1 << 1));
//        System.out.println("1<<30:" + (1 << 30));
//        byte[] bytes = Hashing.murmur3_128().hashString("hello", Charsets.UTF_8).asBytes();
//        System.out.println(bytes);
        System.out.println(UUID.randomUUID().toString());
        String s = "12345";
        System.out.println(Integer.valueOf(String.valueOf(s.charAt(0))));
        System.out.println(Integer.valueOf(String.valueOf(s.charAt(2))));
        System.out.println(Integer.valueOf(String.valueOf(s.charAt(3))));
        System.out.println(Integer.valueOf(s.charAt(1)));
        System.out.println('1');
        System.out.println(s.charAt(0) + s.charAt(1));
        int i = s.codePointAt(0);
        int c = s.charAt(0);
        System.out.println(i);
        System.out.println(c);
        char[] chars = s.toCharArray();
        for (char cr : chars) {
            System.out.println(Integer.valueOf(String.valueOf(cr)));
        }
        int o = '0';
        System.out.println("0 :" + o);
    }
}
