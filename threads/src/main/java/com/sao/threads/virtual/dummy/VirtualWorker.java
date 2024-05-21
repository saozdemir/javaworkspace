package com.sao.threads.virtual.dummy;

/**
 * @author saozdemir
 * @project javaworkspace
 * @date 21 May 2024
 * <p>
 * @description:
 */
public class VirtualWorker implements Runnable{
    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            System.out.println(Thread.currentThread() + "working...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
