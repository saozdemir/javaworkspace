package com.sao.threads.virtual;

import java.time.Duration;
import java.util.stream.IntStream;

/**
 * @author saozdemir
 * @project javaworkspace
 * @date 20 May 2024
 * <p>
 * @description:
 */
public class VirtualThreadBasic {
    private static final int TASK_COUNT = 10;

    public static void main(String[] args) {
        IntStream.range(0, TASK_COUNT).forEach(i -> {
            Thread thread = Thread.ofVirtual().start(() -> {
                try {
                    Thread.sleep(Duration.ofSeconds(1));
                    System.out.println("Virtual Thread Task " + i + " completed by " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
