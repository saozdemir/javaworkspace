package com.sao.course.virtual;

import java.util.ArrayList;
import java.util.List;

/**
 * @author saozdemir
 * @project javaworkspace
 * @date 31 May 2024
 * <p>
 * @description: Introduction to Virtual Threads
 */
public class VirtualThreadsDemo {
    private static final int NUMBER_OF_VIRTUAL_THREADS = 10000;
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> System.out.println("Inside thread: " + Thread.currentThread());

        List<Thread> virtualThreads = new ArrayList<>();

        for (int i = 0; i < NUMBER_OF_VIRTUAL_THREADS; i++) {
            Thread virtualThread = Thread.ofVirtual().unstarted(runnable);
            virtualThreads.add(virtualThread);
        }

        for (Thread virtualThread : virtualThreads) {
            virtualThread.start();
        }

        for (Thread virtualThread : virtualThreads) {
            virtualThread.join();
        }
    }
}
