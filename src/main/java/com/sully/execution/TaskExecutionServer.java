package com.sully.execution;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Creator: lei.s
 * Create Date: 2017年05月11日
 * 类功能描述：Executor例子
 */
public class TaskExecutionServer {
    private static final int NTHREADS = 100;
    private static final Executor executor = Executors.newFixedThreadPool(NTHREADS);
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(80);
        while (true){
            final Socket socket = serverSocket.accept();
            Runnable callable = new Runnable() {
                @Override
                public void run() {
//                    handleRequest(socket);
                }
            };
            executor.execute(callable);
        }
    }
}
