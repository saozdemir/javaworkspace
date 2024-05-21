package com.sao.threads.comparator;

import com.sao.threads.dummy.ThreadAdmin;
import com.sao.threads.dummy.ThreadWork;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author saozdemir
 * @project javaworkspace
 * @date 21 May 2024
 * <p>
 * @description:
 */
public class ThreadUserApp {
    public static final int PLATFORM = 1;
    public static final int VIRUAL = 2;

    public static void main(String[] args) {
        System.out.println("[1] Platform threads");
        System.out.println("[2] Virtual threads");
        System.out.print("selection: ");
        Scanner scanner = new Scanner(System.in);
        int selection = scanner.nextInt();
        switch (selection) {
            case PLATFORM:
                platformThreadProcess();
                break;
            case VIRUAL:
                virtualThreadProcess();
                break;
        }


    }

    private static void platformThreadProcess() {
        try {
            long startTime = System.nanoTime();
            List<ThreadWorker> threadWorkerPool = new LinkedList<>();
            for (int i = 0; i < 10000; i++) {
                ThreadWorker threadWorker = new ThreadWorker();//(ThreadWorker) Thread.ofPlatform().name("platform");
                threadWorkerPool.add(threadWorker);
            }
            ThreadManagerPlatform platformManager = new ThreadManagerPlatform(threadWorkerPool);
            Thread mainThread = new Thread(platformManager);
            mainThread.start();
            mainThread.join();

            long elapsedTime = System.nanoTime() - startTime;
            System.out.println("Millis: " + elapsedTime / 1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static void virtualThreadProcess() {
        try {
            long startTime = System.nanoTime();
            List<Thread> threadWorkerPool = new LinkedList<>();
            for (int i = 0; i < 10000; i++) {
                ThreadWorker worker = new ThreadWorker();
                Thread threadWorker = Thread.ofVirtual().name("virtual").unstarted(worker);
                threadWorkerPool.add(threadWorker);
            }
            ThreadManagerVirtual virtualManager = new ThreadManagerVirtual(threadWorkerPool);
            Thread mainThread = new Thread(virtualManager);
            mainThread.start();
            mainThread.join();

            long elapsedTime = System.nanoTime() - startTime;
            System.out.println("Millis: " + elapsedTime / 1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
