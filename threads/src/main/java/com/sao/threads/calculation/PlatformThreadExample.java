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
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PlatformThreadExample {
    public static void main(String[] args) {
        /**
         * Virtual thread'ler ve platform thread'ler için farklı CPU çekirdeği hesaplamalarının nedeni,
         * virtual thread'lerin donanım seviyesinde daha az bağımlı olmasıdır.
         * Platform thread'leri (OS thread'leri) doğrudan fiziksel ve mantıksal çekirdekler üzerinde çalışırken,
         * virtual thread'ler daha hafif iş parçacıklarıdır ve JVM tarafından yönetilir.
         * Bu nedenle, virtual thread'ler için daha fazla paralellik oluşturmak amacıyla,
         * çekirdek sayısını ikiyle çarparak daha fazla sanal iş parçacığı oluşturulur.
         * Bu, sistemin hiper iş parçacıklarını (hyper-threading) ve ek paralel işleme kapasitesini daha iyi kullanmasına yardımcı olur.
         */
        int cpuCores = Runtime.getRuntime().availableProcessors();
        int kFactor = 2;
        int chunkSize = 10000 / (cpuCores * kFactor);

        List<Personel> personelList = Personel.generatePersonelList(10000); // Daha büyük iş yükü için 10,000 elemanlı liste
        //int chunkSize = 625; // Daha büyük iş yükü için 1000'lik parçalar

        List<List<Personel>> chunks = new ArrayList<>();
        for (int i = 0; i < personelList.size(); i += chunkSize) {
            chunks.add(personelList.subList(i, Math.min(personelList.size(), i + chunkSize)));
        }

        ExecutorService executor = Executors.newFixedThreadPool(chunks.size());
        List<Callable<List<double[]>>> tasks = new ArrayList<>();

        for (List<Personel> chunk : chunks) {
            tasks.add(() -> calculateWorkHours(chunk));
        }

        try {
            long startTime = System.currentTimeMillis();
            long initialMemoryUsage = getMemoryUsage();
            int initialOSThreadCount = ThreadUtil.getOSThreadCount();
            System.out.println("Initial OS Thread Count: " + initialOSThreadCount);

            List<Future<List<double[]>>> results = executor.invokeAll(tasks);
            List<double[]> finalResults = new ArrayList<>();
            for (Future<List<double[]>> result : results) {
                finalResults.addAll(result.get());
            }
            int finalOSThreadCount = ThreadUtil.getOSThreadCount();
            System.out.println("Final OS Thread Count: " + finalOSThreadCount);

            long endTime = System.currentTimeMillis();
            long finalMemoryUsage = getMemoryUsage();

            System.out.println("Platform Threads - Total time: " + (endTime - startTime) + " ms");
            System.out.println("Memory Usage Difference for Platform Threads: " + (finalMemoryUsage - initialMemoryUsage) + " bytes");
            System.out.println("Used OS Threads: " + (finalOSThreadCount - initialOSThreadCount));
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
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


