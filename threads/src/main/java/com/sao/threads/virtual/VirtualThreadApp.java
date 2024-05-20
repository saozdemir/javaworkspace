package com.sao.threads.virtual;

import java.util.concurrent.ThreadFactory;

/**
 * @author saozdemir
 * @project javaworkspace
 * @date 20 May 2024
 * <p>
 * @description: Basic application of virtual threads
 */
public class VirtualThreadApp {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = ()->{
            System.out.println(Thread.currentThread());
        };

        // Generic definition of virtual thread
        Thread thread = Thread.ofVirtual().name("virtual").start(runnable);
        thread.join();

        // Usage ThreadFactory  for virtual threads
        ThreadFactory threadFactory = Thread.ofVirtual().name("virtualF").factory();
        Thread thread1 = threadFactory.newThread(runnable);
        thread1.start();
        thread1.join();
    }
}
