package com.sao.threads.comparator;

/**
 * @author saozdemir
 * @project javaworkspace
 * @date 21 May 2024
 * <p>
 * @description:
 */
public class ThreadWorker implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread() + " work");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
