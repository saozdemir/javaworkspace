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
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class VirtualThreadExample {
    public static void main(String[] args) {
        /**
         * int logicalCpuCores = Runtime.getRuntime().availableProcessors() * 2; kodunda 2 değerinin alınmasının nedeni, sistemdeki CPU çekirdeklerinin hiper iş parçacıkları (hyper-threading) ile birlikte nasıl kullanılacağını optimize etmektir. Hiper iş parçacıkları, her fiziksel çekirdeğin iki mantıksal çekirdek olarak çalışmasını sağlar, bu da CPU kaynaklarının daha verimli kullanılmasına yardımcı olur. Ancak bu sabit 2 değeri belirli bir kural değildir ve farklı durumlarda, iş yüküne ve sistem kaynaklarına bağlı olarak değiştirilebilir. Örneğin, 4 veya 8 gibi farklı çarpanlar da kullanılabilir.
         *
         * Neden 2 Değeri Kullanılır?
         * Hiper İş Parçacıkları: Birçok modern CPU, hiper iş parçacıklarını destekler, bu da her fiziksel çekirdeğin iki mantıksal çekirdek gibi çalışabileceği anlamına gelir. Bu nedenle, sistemin sahip olduğu fiziksel çekirdek sayısının iki katı mantıksal çekirdek olarak kullanılabilir.
         * Standart Optimizasyon: Çoğu durumda, bu çarpan 2, hiper iş parçacıklarını tam olarak kullanmak için yeterlidir ve CPU-bound iş yüklerini verimli bir şekilde yönetmek için iyi bir başlangıç noktasıdır.
         * Alternatif Değerler Kullanılabilir mi?
         * Evet, 2 dışında farklı çarpanlar kullanmak da mümkündür ve belirli senaryolarda faydalı olabilir. İşte bazı örnekler:
         *
         * 1 Değeri:
         *
         * Nerede Kullanılır: Hiper iş parçacıklarının kullanılmadığı veya her iş parçacığının tam bir çekirdeğe ihtiyaç duyduğu durumlarda.
         * Örnek: int logicalCpuCores = Runtime.getRuntime().availableProcessors();
         * 4 veya 8 Değeri:
         *
         * Nerede Kullanılır: I/O-bound iş yüklerinin çok fazla olduğu veya çok sayıda iş parçacığı oluşturmanın sistem kaynaklarını aşırı kullanmayacağı durumlarda.
         * Örnek: int logicalCpuCores = Runtime.getRuntime().availableProcessors() * 4;
         * Dinamik Ayarlar:
         *
         * Nerede Kullanılır: Sistemin iş yükü türüne bağlı olarak, dinamik olarak çarpan değerini ayarlamak isteyebilirsiniz. Örneğin, belirli bir iş yükü altında performans testi yaparak en uygun değeri belirleyebilirsiniz.
         */
        int logicalCpuCores = Runtime.getRuntime().availableProcessors() * 2; // Mantıksal çekirdek sayısı(Hyper-threading ile her fiziksel çekirdek, iki mantıksal çekirdek gibi çalışır. Intel patentli)
        int kFactor = 2;
        int chunkSize = 10000 / (logicalCpuCores * kFactor);

        List<Personel> personelList = Personel.generatePersonelList(10000); // Daha büyük iş yükü için 10,000 elemanlı liste
        //int chunkSize = 625; // Daha büyük iş yükü için 1000'lik parçalar

        List<List<Personel>> chunks = new ArrayList<>();
        for (int i = 0; i < personelList.size(); i += chunkSize) {
            chunks.add(personelList.subList(i, Math.min(personelList.size(), i + chunkSize)));
        }

        var executor = Executors.newThreadPerTaskExecutor(Thread.ofVirtual().factory());
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

            System.out.println("Virtual Threads - Total time: " + (endTime - startTime) + " ms");
            System.out.println("Memory Usage Difference for Virtual Threads: " + (finalMemoryUsage - initialMemoryUsage) + " bytes");
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

