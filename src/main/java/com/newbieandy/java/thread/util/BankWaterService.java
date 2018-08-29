package com.newbieandy.java.thread.util;

import java.util.Map;
import java.util.concurrent.*;

public class BankWaterService implements Runnable {
    //创建4个屏障,处理完之后执行当前的run方法
    private CyclicBarrier c = new CyclicBarrier(4, this);
    //启动4个线程
    private Executor executor = Executors.newFixedThreadPool(4);

    //保存每个sheet计算出的结果
    private ConcurrentHashMap<String, Integer> sheetBankWaterCount = new ConcurrentHashMap<>();

    private void count() {
        for (int i = 0; i < 4; i++) {
            executor.execute(() -> {
                //计算当前sheet的银流数据,计算代码省略
                sheetBankWaterCount.put(Thread.currentThread().getName(), 1);
                //计算完成,插入屏障
                try {
                    c.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
    }


    @Override
    public void run() {
        int result = 0;
        //汇总结果
        for (Map.Entry<String, Integer> entry : sheetBankWaterCount.entrySet()) {
            result += entry.getValue();
        }
        sheetBankWaterCount.put("result", result);
        System.out.println("result:" + result);
    }

    public static void main(String[] args) {
        BankWaterService bankWaterService = new BankWaterService();
        bankWaterService.count();
    }
}
