package com.sao.threads.calculation;

/**
 * @author saozdemir
 * @project javaworkspace
 * @date 24 May 2024
 * <p>
 * @description:
 */
import java.util.ArrayList;
import java.util.List;

public class SingleThreadExample {
    public static void main(String[] args) {
        List<Personel> personelList = Personel.generatePersonelList(10000); // Daha büyük iş yükü için 10,000 elemanlı liste

        try {
            long startTime = System.currentTimeMillis();
            long initialMemoryUsage = getMemoryUsage();
            int initialOSThreadCount = ThreadUtil.getOSThreadCount();
            List<double[]> results = calculateWorkHours(personelList);

            int finalOSThreadCount = ThreadUtil.getOSThreadCount();
            System.out.println("Final OS Thread Count: " + finalOSThreadCount);

            long endTime = System.currentTimeMillis();
            long finalMemoryUsage = getMemoryUsage();

            System.out.println("Single Thread - Total time: " + (endTime - startTime) + " ms");
            System.out.println("Memory Usage Difference for Single Thread: " + (finalMemoryUsage - initialMemoryUsage) + " bytes");
            System.out.println("Used OS Threads: " + (finalOSThreadCount - initialOSThreadCount));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<double[]> calculateWorkHours(List<Personel> personelList) {
        int[] daysArray = {3, 5, 10, 15, 30, 45, 90, 120, 180, 365};
        List<double[]> results = new ArrayList<>();
        for (Personel personel : personelList) {
            double[] workHours = new double[daysArray.length];
            for (int i = 0; i < daysArray.length; i++) {
                workHours[i] = personel.getTotalWorkHours(daysArray[i]);
                // Ekstra iş yükü oluşturmak için yapay bir hesaplama ekliyoruz
                for (int j = 0; j < 1000; j++) {
                    workHours[i] += Math.sin(workHours[i] * j);
                }
            }
            results.add(workHours);
        }
        return results;
    }

    // Method to get the current memory usage of the JVM
    private static long getMemoryUsage() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }
}

