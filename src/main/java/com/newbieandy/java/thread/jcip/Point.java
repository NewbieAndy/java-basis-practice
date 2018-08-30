package com.newbieandy.java.thread.jcip;

//不可变的
public class Point {
    public final int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
