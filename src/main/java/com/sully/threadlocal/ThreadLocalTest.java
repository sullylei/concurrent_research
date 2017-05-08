package com.sully.threadlocal;

/**
 * Creator: lei.s
 * Create Date: 2017年05月08日
 * 类功能描述：ThreadLocal测试
 */
public class ThreadLocalTest {
    //通过覆写ThreadLocal中的initialValue方法为线程局部变量初始化之为0
    ThreadLocal<Integer> tlNum = new ThreadLocal<Integer>(){
        public Integer initialValue(){
            return 0;
        }
    };

    public int getNextNum(){
        Integer num = tlNum.get();
        tlNum.set(num+1);
        return num;
    }

    private static class TestThread implements Runnable{
        private ThreadLocalTest tlt;

        public TestThread(ThreadLocalTest tlt) {
            this.tlt = tlt;
        }
        public void run() {
            int n = 5;
            for (int i = 0; i < n; i++) {
                System.out.println("线程【"+Thread.currentThread().getName()+"】-线程变量值【"+tlt.getNextNum()+"】");
            }
        }
    }

    public static void main(String[] args) {

        //TestThread tt1 = new TestThread(new ThreadLocalTest());
        //TestThread tt2 = new TestThread(new ThreadLocalTest());
        //TestThread tt3 = new TestThread(new ThreadLocalTest());
        //之前这样写是不正确的

        ThreadLocalTest tlt = new ThreadLocalTest();
        TestThread tt1 = new TestThread(tlt);
        TestThread tt2 = new TestThread(tlt);
        TestThread tt3 = new TestThread(tlt);
        Thread t1 = new Thread(tt1);
        Thread t2 = new Thread(tt2);
        Thread t3 = new Thread(tt3);
        t1.start();
        t2.start();
        t3.start();
    }
}
