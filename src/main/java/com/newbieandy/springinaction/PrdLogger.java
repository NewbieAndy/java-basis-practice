package com.newbieandy.springinaction;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prd")
public class PrdLogger implements Logger {
    @Override
    public void loggerName() {
        System.out.println("PRD logger ...");
    }
}
