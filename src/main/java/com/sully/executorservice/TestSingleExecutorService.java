package com.sully.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Creator: lei.s
 * Create Date: 2017年05月11日
 * 类功能描述：
 */
public class TestSingleExecutorService {
    public static void main(String[] args) {
        //创建一个可重用固定线程数的线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        //创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口
        Thread t1 = new MyThread("t1");
        Thread t2 = new MyThread("t2");
        Thread t3 = new MyThread("t3");
        Thread t4 = new MyThread("t4");
        Thread t5 = new MyThread("t5");
        //将线程放入池中进行执行
        executorService.execute(t1);
        executorService.execute(t2);
        executorService.execute(t3);
        executorService.execute(t4);
        executorService.execute(t5);
        //关闭线程池
        executorService.shutdown();
    }
}
