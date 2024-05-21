package com.sao.threads.dummy;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.ThreadMXBean;
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
public class ThreadPoolOperation {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("[1] Platform threads");
        System.out.println("[2] Virtual threads");
        System.out.print("selection: ");
        Scanner scanner = new Scanner(System.in);
        int selection = scanner.nextInt();
        switch (selection) {
            case 1:
                platformThreadOperation();
                break;
            case 2:
                virtualThreadOperation();
                break;
        }

        //platformThreadOperation();
//        virtualThreadOperation();

    }

    private static void platformThreadOperation() throws InterruptedException {
        // Initialize beans to gather system metrics
        OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
        ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();

        // Enable CPU time measurement for threads if not already enabled
        if (!threadBean.isThreadCpuTimeEnabled()) {
            threadBean.setThreadCpuTimeEnabled(true);
        }

        // Get initial system metrics
        long initialMemoryUsage = getMemoryUsage();
        long startTime = System.nanoTime();

        List<ThreadWork> threadWorkPool = new LinkedList<>();
        for (int i = 0; i < 10000; i++) {
            threadWorkPool.add(new ThreadWork());
        }
        ThreadAdmin threadAdmin = new ThreadAdmin(threadWorkPool);
        Thread mainThread = new Thread(threadAdmin);
        mainThread.start();
        mainThread.join();
        // Get final system metrics
        long finalMemoryUsage = getMemoryUsage();

        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Memory Usage Difference for Platform Threads: " + (finalMemoryUsage - initialMemoryUsage) + " bytes");
        System.out.println("Millis: " + elapsedTime / 1000000);
    }


    private static void virtualThreadOperation() throws InterruptedException {
        // Initialize beans to gather system metrics
        OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
        ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();

        // Enable CPU time measurement for threads if not already enabled
        if (!threadBean.isThreadCpuTimeEnabled()) {
            threadBean.setThreadCpuTimeEnabled(true);
        }

        // Get initial system metrics
        long initialMemoryUsage = getMemoryUsage();
        long startTime = System.nanoTime();
//        List<Thread> virtualThreadWorkPool = new LinkedList<>();
        List<ThreadWork> virtualThreadWorkPool = new LinkedList<>();
        for (int i = 0; i < 10000; i++) {
            virtualThreadWorkPool.add((new ThreadWork()));
        }
//        ThreadAdminVirtual threadAdminVirtual = new ThreadAdminVirtual(virtualThreadWorkPool);
        ThreadAdminVirtualV2 threadAdminVirtual = new ThreadAdminVirtualV2(virtualThreadWorkPool);
        Thread mainThread = new Thread(threadAdminVirtual);
        mainThread.start();
        mainThread.join();

        // Get final system metrics
        long finalMemoryUsage = getMemoryUsage();

        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Memory Usage Difference for Virtual Threads: " + (finalMemoryUsage - initialMemoryUsage) + " bytes");
        System.out.println("Millis: " + elapsedTime / 1000000);
    }

    // Method to get the current memory usage of the JVM
    private static long getMemoryUsage() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }
}
