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
public class ThreadAdminVirtual implements Runnable{
    private List<Thread> virtualThreadWorkPool;

    public ThreadAdminVirtual(List<Thread> virtualThreadWorkPool) {
        this.virtualThreadWorkPool = virtualThreadWorkPool;
    }

    @Override
    public void run() {
        for (Thread work : virtualThreadWorkPool){
           work.start();
        }

        for (Thread work : virtualThreadWorkPool) {
            try {
                work.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

//        boolean isFinished = false;
//
//        while (!isFinished){
//            isFinished = true;
//            for (Thread work : virtualThreadWorkPool){
//                isFinished = isFinished && ((ThreadWork) work).isFinished;
//            }
//            try {
//                sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

//        for (Thread work : virtualThreadWorkPool){
//            try {
//                work.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

        System.out.println("Finished Process");
    }
}
