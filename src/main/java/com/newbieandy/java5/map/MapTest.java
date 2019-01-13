package com.newbieandy.java5.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by mchao on 2018/4/11.
 */
public class MapTest {
    public static void main(String[] args) {
        linkedHashMapTest();

    }

    private static void linkedHashMapTest() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(16, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > 3;
            }
        };
        linkedHashMap.put("project1", "valhalla");
        linkedHashMap.put("project2", "Panama");
        linkedHashMap.put("project3", "Loom");
        linkedHashMap.forEach((k, v) -> System.out.println(k + ":" + v));

        System.out.println("=======");

        //模拟访问
        linkedHashMap.get("project2");
        linkedHashMap.get("project2");
        linkedHashMap.get("project3");
        linkedHashMap.forEach((k, v) -> System.out.println(k + ":" + v));
        //触发删除
        linkedHashMap.put("project4", "Mission Control");
        System.out.println("oldest should be removed");
        linkedHashMap.forEach((k, v) -> System.out.println(k + ":" + v));
    }
}
