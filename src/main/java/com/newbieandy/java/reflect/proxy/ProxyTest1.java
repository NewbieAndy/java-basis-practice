package com.newbieandy.java.reflect.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest1 {
    public static void main(String[] args) {
        HelloImpl hello = new HelloImpl();
        HelloInovcationHandler inovcationHandler = new HelloInovcationHandler(hello);
        Hello proxyHello = (Hello) Proxy.newProxyInstance(HelloImpl.class.getClassLoader(), hello.getClass().getInterfaces(), inovcationHandler);
        hello.sayHi();
        System.out.println("========");
        proxyHello.sayHi();
    }
}

interface Hello {
    void sayHi();
}

class HelloImpl implements Hello {

    @Override
    public void sayHi() {
        System.out.println("hi proxy...");
    }
}

class HelloInovcationHandler implements InvocationHandler {

    private Hello hello;

    public HelloInovcationHandler(Hello obj) {
        this.hello = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Invocation hello ...");
        Object invoke = method.invoke(hello, args);
        return invoke;
    }
}
