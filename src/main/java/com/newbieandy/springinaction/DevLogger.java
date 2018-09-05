package com.newbieandy.springinaction;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class DevLogger implements Logger {
    @Override
    public void loggerName() {
        System.out.println("Dev logger ...");
    }
}
