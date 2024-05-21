package com.sao.threads.comparator;

import java.util.List;

/**
 * @author saozdemir
 * @project javaworkspace
 * @date 21 May 2024
 * <p>
 * @description:
 */
public class ThreadManagerPlatform implements Runnable{
    List<ThreadWorker> platformThreadPool;

    public ThreadManagerPlatform(List<ThreadWorker> platformThreadPool){
        this.platformThreadPool = platformThreadPool;
    }

    @Override
    public void run() {
        for (ThreadWorker work : platformThreadPool){
            new Thread(work).start();
        }

//        for (ThreadWorker work : platformThreadPool) {
//            try {
//                work.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        System.out.println("Finish virtual thread process.");
    }
}
