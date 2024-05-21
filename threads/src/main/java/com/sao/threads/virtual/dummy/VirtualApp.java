package com.sao.threads.virtual.dummy;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.ThreadMXBean;
import java.util.LinkedList;
import java.util.List;

/**
 * @author saozdemir
 * @project javaworkspace
 * @date 21 May 2024
 * <p>
 * @description:
 */
public class VirtualApp {
    public static void main(String[] args) {
        try {
            // Initialize beans to gather system metrics
            OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
            ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();

            // Enable CPU time measurement for threads if not already enabled
            if (!threadBean.isThreadCpuTimeEnabled()) {
                threadBean.setThreadCpuTimeEnabled(true);
            }

            // Get initial system metrics
            long initialMemoryUsage = getMemoryUsage();
            long initialCpuTime = getTotalCpuTime(threadBean);

            List<Thread> pool = new LinkedList<>();
            for (int i = 0; i < 100; i++) {
                VirtualWorker worker = new VirtualWorker();
                pool.add(Thread.ofVirtual().unstarted(worker));
            }
            Thread mainThread = new Thread(new VirtualManager(pool));
            mainThread.start();
            mainThread.join();

            // Get final system metrics
            long finalMemoryUsage = getMemoryUsage();
            long finalCpuTime = getTotalCpuTime(threadBean);

            System.out.println("Memory Usage Difference for Virtual Threads: " + (finalMemoryUsage - initialMemoryUsage) + " bytes");
            System.out.println("CPU Time Difference for Virtual Threads: " + (finalCpuTime - initialCpuTime) + " ns");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    // Method to get the current memory usage of the JVM
    private static long getMemoryUsage() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }

    // Method to get the total CPU time used by all threads
    private static long getTotalCpuTime(ThreadMXBean threadBean) {
        long[] threadIds = threadBean.getAllThreadIds();
        long totalCpuTime = 0;
        for (long id : threadIds) {
            totalCpuTime += threadBean.getThreadCpuTime(id);
        }
        return totalCpuTime;
    }
}
