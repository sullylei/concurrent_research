package com.sully.executorservice;

/**
 * Creator: lei.s
 * Create Date: 2017年05月11日
 * 类功能描述：
 */
public class MyThread extends Thread {
    private String name;

    public MyThread(String name){
        this.name = name;
    }

    @Override
    public void run(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.name+"正在执行......");
    }
}
