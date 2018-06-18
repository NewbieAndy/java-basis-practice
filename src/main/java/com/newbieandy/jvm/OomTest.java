package com.newbieandy.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * OutOfMemoryError异常测试 VM Args:-Xms20m-Xmx20m-XX:+HeapDumpOnOUtOfMemoryError Created by mchao on
 * 2018/4/12.
 */
public class OomTest {


    public static void main(String[] args) {
        List<OOMBean> list = new ArrayList<>();
        System.out.println();
    }
    public static String getString(){
        return "";
    }

    static class OOMBean {
    }
}
