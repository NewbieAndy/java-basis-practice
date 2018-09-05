package com.newbieandy.springinaction;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("def")
//@Primary
public class DefaultLogger implements Logger {
    @Override
    public void loggerName() {
        System.out.println("default logger ...");
    }
}
