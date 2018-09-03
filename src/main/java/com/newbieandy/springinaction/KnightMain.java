package com.newbieandy.springinaction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class KnightMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(KinghtConfig.class);
        Knight knight = context.getBean(Knight.class);
        knight.embarkOnQuest();
        context.close();
    }
}
