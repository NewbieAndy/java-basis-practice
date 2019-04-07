package com.newbieandy.spitest;

import org.junit.Test;

import java.util.ServiceLoader;

public class SpiTest {
    @Test
    public void sayHi() {
        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
        System.out.println("JAVA SPI");
        serviceLoader.forEach(Robot::sayHi);

    }
}
