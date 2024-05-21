package com.sao.threads.comparator;

import java.util.List;

/**
 * @author saozdemir
 * @project javaworkspace
 * @date 21 May 2024
 * <p>
 * @description:
 */
public class ThreadManagerVirtual implements Runnable{
    List<Thread> virtualThreadPool;

    public ThreadManagerVirtual(List<Thread> virtualThreadPool){
        this.virtualThreadPool = virtualThreadPool;
    }

    @Override
    public void run() {
        for (Thread work : virtualThreadPool){
            work.start();
        }

        for (Thread work : virtualThreadPool) {
            try {
                work.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Finish virtual thread process.");
    }
}
