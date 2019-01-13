package com.newbieandy.java.thread.executor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceTest {
    private static final ScheduledExecutorService service = Executors.newScheduledThreadPool(1);

    public static void main(String[] args) {
        service.schedule(() -> {
            System.out.println("当前时间：" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
        }, 5, TimeUnit.SECONDS);
    }
}
