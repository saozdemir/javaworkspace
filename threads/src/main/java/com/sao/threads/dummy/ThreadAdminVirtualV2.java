package com.sao.threads.dummy;

/**
 * @author saozdemir
 * @project javaworkspace
 * @date 21 May 2024
 * <p>
 * @description:
 */
import java.util.List;

public class ThreadAdminVirtualV2 implements Runnable {
    private List<ThreadWork> threadWorkPool;

    public ThreadAdminVirtualV2(List<ThreadWork> threadWorkPool) {
        this.threadWorkPool = threadWorkPool;
    }

    @Override
    public void run() {
        for (ThreadWork work : threadWorkPool) {
            Thread.ofVirtual().start(work);
        }
        boolean isFinished = false;

        while (!isFinished) {
            isFinished = true;
            for (ThreadWork work : threadWorkPool) {
                isFinished = isFinished && work.isFinished;
            }
        }
        System.out.println("Finished Process");
    }
}

