package com.sao.threads.dummy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author saozdemir
 * @project javaworkspace
 * @date 21 May 2024
 * <p>
 * @description:
 */
public class ThreadOpApp {
    public static void main(String[] args) throws InterruptedException {
        virtualThreadOperation();
        //platformThreadOperation();

    }

    private static void platformThreadOperation() throws InterruptedException {
        long startTime = System.nanoTime();
        List<Thread> pool = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            pool.add(new Thread(new ThreadOperation()));
        }

        for (Thread thread : pool){
            thread.start();
        }
        for (Thread thread : pool) {
            //thread.start();
            thread.join(); // Thread'lerin tamamlanmasını bekler
        }
        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Millis: " + elapsedTime / 1000000);
    }

    private static void virtualThreadOperation() throws InterruptedException {
        long startTime = System.nanoTime();
        List<Thread> pool = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            Thread thread = Thread.ofVirtual().unstarted(new ThreadOperation());
            pool.add(thread);
        }

        for (Thread thread : pool) {
            thread.start(); // Virtual thread'lerin tamamlanmasını bekler
        }

        for (Thread thread : pool) {
            //thread.start();
            thread.join(); // Virtual thread'lerin tamamlanmasını bekler
        }
        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Millis: " + elapsedTime / 1000000);
    }
}
