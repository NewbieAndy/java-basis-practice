package com.newbieandy.java8.stream;

import java.util.Arrays;

public class AllMatchTest {
    public static void main(String[] args) {
        long[] offsets = new long[]{1, 2, 4, 8};
        boolean match = Arrays.stream(offsets).boxed().map(offset -> offset % 2 == 0 ? true : false).allMatch(b -> b);
        System.out.println(match);
    }
}
