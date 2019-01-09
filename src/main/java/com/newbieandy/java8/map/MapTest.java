package com.newbieandy.java8.map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    Map<String, String> map = new HashMap<>();

    @Before
    public void init() {
        map.put("andy", "student");
        map.put("mike", "teacher");
        map.put("tom", "doctor");
    }

    @Test
    public void getOrDefaultTest() {
        String a = map.getOrDefault("andy", "police");
        Assert.assertEquals("student", a);
        String b = map.getOrDefault("amy", "police");
        Assert.assertEquals("police", b);
    }

    @Test
    public void forEachTest() {
        map.forEach((k, v) -> System.out.println(k + ":" + v));
    }

    @Test
    public void replaceTest() {
        System.out.println(map);
        String a = map.replace("andy", "engineer");
        Assert.assertEquals("student", a);
        System.out.println(map);
        boolean b1 = map.replace("andy", "engineer", "soldier");
        Assert.assertTrue(b1);
        boolean b2 = map.replace("andy", "engineer", "general");
        Assert.assertFalse(b2);
        System.out.println(map);
    }

    @Test
    public void replaceAllTest() {
        System.out.println(map);
        map.replaceAll((k, v) -> k + v);
        System.out.println(map);
    }

    @Test
    public void putIfAbsentTest() {
        String s = map.putIfAbsent("andy", "engineer");
        String s1 = map.putIfAbsent("lucy", "dancer");
        System.out.println(s);
        System.out.println(s1);
        System.out.println(map);
    }

    @Test
    public void removeTest() {
        String andy = map.remove("andy");
        Assert.assertEquals("student", andy);
        boolean b1 = map.remove("tom", "doctor");
        Assert.assertTrue(b1);
        boolean b2 = map.remove("lucy", "dancer");
        Assert.assertFalse(b2);
        boolean b = map.remove("mike", "soldier");
        Assert.assertFalse(b);
        System.out.println(map);
    }


    @Test
    public void computeTest() {
        System.out.println(map);
        String andy_value = map.compute("andy", (k, v) -> k + ":" + v);
        System.out.println(map);
    }

    @Test
    public void computeIfAbsentTest() {
        System.out.println(map);
        String andycompute = map.computeIfAbsent("andy", k -> "new " + k);
        System.out.println(andycompute);
        String andy1compute = map.computeIfAbsent("lucy", k -> "new " + k);
        System.out.println(andy1compute);
        System.out.println(map);
    }

    @Test
    public void computeIfPresentTest() {
        System.out.println(map);
        String andy = map.computeIfPresent("andy", (k, v) -> k + ":" + v);
        String lucy = map.computeIfPresent("lucy", (k, v) -> k + ":" + v);
        String tom = map.computeIfPresent("tom", (k, v) -> null);
        System.out.println(map);
    }

}
