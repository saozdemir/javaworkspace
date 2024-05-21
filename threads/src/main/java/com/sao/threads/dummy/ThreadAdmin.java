package com.sao.threads.dummy;

import java.util.List;

import static java.lang.Thread.sleep;

/**
 * @author saozdemir
 * @project javaworkspace
 * @date 21 May 2024
 * <p>
 * @description:
 */
public class ThreadAdmin implements Runnable {
    private List<ThreadWork> threadWorkPool;

    public ThreadAdmin(List<ThreadWork> threadWorkPool) {
        this.threadWorkPool = threadWorkPool;
    }

    @Override
    public void run() {
        for (ThreadWork work : threadWorkPool){
            new Thread(work).start();
            //new Thread(work).start();
        }

//        for (ThreadWork work : threadWorkPool){
//            try {
//                work.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

        boolean isFinished = false;

        while (!isFinished){
            isFinished = true;
            for (ThreadWork work : threadWorkPool){
                isFinished = isFinished && work.isFinished;
            }
//            try {
//                sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        System.out.println("Finished Process");
    }
}
