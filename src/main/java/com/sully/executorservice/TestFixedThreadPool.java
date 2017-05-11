package com.sully.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Creator: lei.s
 * Create Date: 2017年05月11日
 * 类功能描述：
 */
public class TestFixedThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Thread t1 = new MyThread("t1");
        Thread t2 = new MyThread("t2");
        Thread t3 = new MyThread("t3");
        Thread t4 = new MyThread("t4");
        Thread t5 = new MyThread("t5");
        executorService.execute(t1);
        executorService.execute(t2);
        executorService.execute(t3);
        executorService.execute(t4);
        executorService.execute(t5);
        executorService.shutdown();
    }
}
