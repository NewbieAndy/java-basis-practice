package com.newbieandy.java.string;

public class StringTest {
    public static void main(String[] args) {
        String str1 = new String("a") + new String("b");
        String str2 = "ab";
        String intern = str1.intern();
        System.out.println(str2 == intern);
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
    }
}
