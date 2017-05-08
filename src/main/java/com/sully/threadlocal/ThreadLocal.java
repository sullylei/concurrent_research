package com.sully.threadlocal;

import java.util.HashMap;
import java.util.Map;

/**
 * Creator: lei.s
 * Create Date: 2017年05月08日
 * 类功能描述：模拟ThreadLocal实现
 */
public class ThreadLocal<T> {
    private Map<Thread,T> map = new HashMap<Thread,T>();

    public T get(){
        Thread current = Thread.currentThread();
        T t = map.get(current);
        if(t==null){
            t = initialValue();
            map.put(current,t);
        }
        return t;
    }

    public void set(T t){
        Thread current = Thread.currentThread();
        map.put(current,t);
    }
    /**
     * 线程局部变量初始值
     * @return 初始值为null
     */
    public T initialValue(){
        return null;
    }

    public void remove(){
        map.remove(Thread.currentThread());
    }

}
