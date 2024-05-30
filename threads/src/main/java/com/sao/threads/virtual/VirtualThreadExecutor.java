package com.sao.threads.virtual;

import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author saozdemir
 * @project javaworkspace
 * @date 20 May 2024
 * <p>
 * @description:
 */
public class VirtualThreadExecutor {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        for (int j = 0; j < 25; j++) {
            try (ExecutorService service = Executors.newVirtualThreadPerTaskExecutor()) {
                IntStream.range(0, 100).forEach(i -> {
                    service.submit(() -> {
                        Thread.sleep(Duration.ofSeconds(1));
                        return i;
                    });
                });
            }
        }
        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Millis: " + elapsedTime / 1000000);
    }
}
