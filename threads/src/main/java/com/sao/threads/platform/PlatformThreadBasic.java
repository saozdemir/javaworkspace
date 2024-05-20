package com.sao.threads.platform;

import java.util.stream.IntStream;

/**
 * @author saozdemir
 * @project javaworkspace
 * @date 20 May 2024
 * <p>
 * @description:
 */
public class PlatformThreadBasic {
    private static final int TASK_COUNT = 10;

    public static void main(String[] args) {
        IntStream.range(0, TASK_COUNT).forEach(i -> {
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(1000);
                    System.out.println("Platform Thread Task " + i + " completed by " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        });
    }
}
