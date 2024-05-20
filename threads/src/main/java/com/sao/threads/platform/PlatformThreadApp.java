package com.sao.threads.platform;

import java.util.concurrent.ThreadFactory;

/**
 * @author saozdemir
 * @project javaworkspace
 * @date 20 May 2024
 * <p>
 * @description: Basic application of platform threads
 */
public class PlatformThreadApp {
    public static void main(String[] args) {
        Runnable runnable = ()->{
            System.out.println(Thread.currentThread());
        };

        // Generic definition of platform thread
        Thread thread = Thread.ofPlatform().name("platform").start(runnable);

        // Usage ThreadFactory  for platform threads
        ThreadFactory threadFactory = Thread.ofPlatform().name("platformF").factory();
        Thread thread1 = threadFactory.newThread(runnable);
        thread1.start();
    }
}
