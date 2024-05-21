package com.sao.threads.dummy;

import java.util.LinkedList;
import java.util.List;

/**
 * @author saozdemir
 * @project javaworkspace
 * @date 21 May 2024
 * <p>
 * @description:
 */
public class ThreadPoolOperation {
    public static void main(String[] args) throws InterruptedException {
        //platformThreadOperation();
        virtualThreadOperation();

    }

    private static void platformThreadOperation() throws InterruptedException {
        long startTime = System.nanoTime();
        List<ThreadWork> threadWorkPool = new LinkedList<>();
        for (int i = 0; i < 10000; i++) {
            threadWorkPool.add(new ThreadWork());
        }
        ThreadAdmin threadAdmin = new ThreadAdmin(threadWorkPool);
        Thread mainThread = new Thread(threadAdmin);
        mainThread.start();
        mainThread.join();

        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Millis: " + elapsedTime / 1000000);
    }


    private static void virtualThreadOperation() throws InterruptedException {
        long startTime = System.nanoTime();
        List<Thread> virtualThreadWorkPool = new LinkedList<>();
        for (int i = 0; i < 10000; i++) {
            virtualThreadWorkPool.add(Thread.ofVirtual().unstarted(new ThreadWork()));
        }
        ThreadAdminVirtual threadAdminVirtual = new ThreadAdminVirtual(virtualThreadWorkPool);
        Thread mainThread = new Thread(threadAdminVirtual);
        mainThread.start();
        mainThread.join();

        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Millis: " + elapsedTime / 1000000);
    }
}
