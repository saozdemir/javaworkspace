package com.sao.course.performance;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author saozdemir
 * @project javaworkspace
 * @date 31 May 2024
 * <p>
 * @description: Thread Per Task Threading Model
 */
public class IoBoundApplication {
    private static final int NUMBER_OF_TASKS = 1000;

    public static void main(String[] args) {
        System.out.printf("Running %d tasks\n", NUMBER_OF_TASKS);

        long start = System.currentTimeMillis();
        performTasks();
        System.out.printf("Tasks took %dms to complete\n", System.currentTimeMillis() - start);
    }

    private static void performTasks() {
        try (ExecutorService executorService = Executors.newCachedThreadPool()) { //Thread-Per-Task için out of memory verir.

            for (int i = 0; i < NUMBER_OF_TASKS; i++) {
                executorService.submit(() ->  blockingIoOperation());
            }
        }
    }

    // Simulates a long blocking IO
    private static void blockingIoOperation() {
        System.out.println("Executing a blocking task from thread: " + Thread.currentThread());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
