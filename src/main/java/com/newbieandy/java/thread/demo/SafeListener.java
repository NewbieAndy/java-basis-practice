package com.newbieandy.java.thread.demo;

import java.awt.*;
import java.util.EventListener;

public class SafeListener {
    private final EventListener listener;

    private SafeListener() {
        listener = new EventListener() {
            public void onEvent(Event e) {
                System.out.println("");
            }
        };
    }

//    public static SafeListener newInstance()
}
