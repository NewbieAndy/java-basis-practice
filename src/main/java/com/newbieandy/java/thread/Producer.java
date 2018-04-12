package com.newbieandy.java.thread;

/**
 * Created by mchao on 2018/1/3.
 */
public class Producer  implements Runnable{
    private Resource resource;

    public Producer(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
    }
}
