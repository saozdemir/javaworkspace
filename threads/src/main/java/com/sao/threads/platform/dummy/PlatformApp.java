package com.sao.threads.platform.dummy;

import com.sao.threads.virtual.dummy.VirtualManager;
import com.sao.threads.virtual.dummy.VirtualWorker;

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
public class PlatformApp {
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
            int initialThreadCount = threadBean.getThreadCount();
            long initialCpuTime = getTotalCpuTime(threadBean);

            List<Thread> pool = new LinkedList<>();
            for (int i = 0; i < 100; i++) {
                PlatformWorker worker = new PlatformWorker();
                pool.add(Thread.ofPlatform().unstarted(worker));
            }
            Thread mainThread = new Thread(new PlatformManager(pool));
            mainThread.start();
            mainThread.join();

            // Get final system metrics
            long finalMemoryUsage = getMemoryUsage();
            int finalThreadCount = threadBean.getThreadCount();
            long finalCpuTime = getTotalCpuTime(threadBean);

            System.out.println("Memory Usage Difference for Platform Threads: " + (finalMemoryUsage - initialMemoryUsage) + " bytes");
            System.out.println("Difference in Thread Count: " + (finalThreadCount - initialThreadCount));
            System.out.println("CPU Time Difference for Platform Threads: " + (finalCpuTime - initialCpuTime) + " ns");
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
            long time = threadBean.getThreadCpuTime(id);
            if (time != -1) { // Thread CPU time is supported
                totalCpuTime += time;
            }
        }
        return totalCpuTime;
    }
}
