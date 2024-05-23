package com.sao.threads.calculation;

/**
 * @author saozdemir
 * @project javaworkspace
 * @date 24 May 2024
 * <p>
 * @description:
 */
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class ThreadUtil {
    private static final ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

    public static int getOSThreadCount() {
        return threadMXBean.getThreadCount();
    }
}

