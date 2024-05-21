package com.sao.threads.platform.dummy;

import java.util.LinkedList;
import java.util.List;

/**
 * @author saozdemir
 * @project javaworkspace
 * @date 21 May 2024
 * <p>
 * @description:
 */
public class PlatformManager implements Runnable{
    List<Thread> pool = new LinkedList<>();

    public PlatformManager(List<Thread> pool) {
        this.pool = pool;
    }
    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        try {
            for (Thread worker:pool){
                worker.start();
            }

            for (Thread worker : pool){
                worker.join();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
