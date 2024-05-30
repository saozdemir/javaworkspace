package com.sao.threads.comparator;

import com.sao.threads.dummy.ThreadWork;

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

        boolean isFinished = false;

        while (!isFinished){
            isFinished = true;
            for (ThreadWorker work : platformThreadPool){
                isFinished = isFinished && work.isFinished;
            }
//            try {
//                sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        System.out.println("Finished Process");

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
