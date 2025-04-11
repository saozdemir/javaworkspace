package com.sao.thesis.starter.business;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author saozdemir
 * @project javaworkspace
 * @date 11 Nis 2025
 * <p>
 * @description:
 */
public class EmployeeLocationParser {

    public static void main(String[] args) {

        Path filePath = Path.of("D:\\home\\IdeaProjects\\javaworkspace\\thesis\\src\\main\\java\\com\\sao\\thesis\\starter\\business\\employee_locations.txt");
        long startTime;
        long endTime;
        List<EmployeeLocation> parsedLocations=new ArrayList<>();

        /**Virtual Thread*/
        startTime = System.currentTimeMillis();
        parsedLocations = parseFileWithVirtualThreads(filePath);
        endTime = System.currentTimeMillis();
        System.out.println("Virtual Thread Performance Time: " + (endTime - startTime));
//        parsedLocations.forEach(System.out::println);

//        parsedLocations.clear();

        /**Virtual Thread Optimized*/
        startTime = System.currentTimeMillis();
        parsedLocations = parseFileWithVirtualThreadsOptimized(filePath);
        endTime = System.currentTimeMillis();
        System.out.println("Optimized Virtual Thread Performance Time: " + (endTime - startTime));
//        parsedLocations.forEach(System.out::println);

//        parsedLocations.clear();

        /**Virtual Thread Batch*/
        startTime = System.currentTimeMillis();
        parsedLocations = parseFileWithBatches(filePath);
        endTime = System.currentTimeMillis();
        System.out.println("Batched Virtual Thread Performance Time: " + (endTime - startTime));
//        parsedLocations.forEach(System.out::println);

//        parsedLocations.clear();

        /**Single Thread*/
        startTime = System.currentTimeMillis();
        parsedLocations = parseFileSingleThread(filePath);
        endTime = System.currentTimeMillis();
        System.out.println("Single Thread Performance Time: " + (endTime - startTime));
//        parsedLocations.forEach(System.out::println);
    }

    public static List<EmployeeLocation> parseFileWithVirtualThreads(Path filePath) {
        List<EmployeeLocation> result = new ArrayList<>();

        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            // Dosyayı satır satır oku ve her satır için bir işlem başlat
            List<Future<EmployeeLocation>> futures = Files.lines(filePath)
                    .map(line -> executor.submit(() -> parseLine(line)))
                    .toList();

            // Tüm işlemlerin tamamlanmasını bekle
            for (Future<EmployeeLocation> future : futures) {
                result.add(future.get());
            }
        } catch (IOException | InterruptedException | ExecutionException e) {
            throw new RuntimeException("Parsing failed", e);
        }

        return result;
    }

    public static List<EmployeeLocation> parseFileSingleThread(Path filePath) {
        try {
            return Files.lines(filePath)
                    .map(EmployeeLocationParser::parseLine)
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<EmployeeLocation> parseFileWithVirtualThreadsOptimized(Path filePath) {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            // Tüm satırları bir kerede oku (küçük dosyalar için uygun)
            List<String> lines = Files.readAllLines(filePath);

            // Her satır için CompletableFuture oluştur
            List<CompletableFuture<EmployeeLocation>> futures = lines.stream()
                    .map(line -> CompletableFuture.supplyAsync(() -> parseLine(line), executor))
                    .toList();

            // Tüm task'ların bitmesini bekle
            CompletableFuture<Void> allFutures = CompletableFuture.allOf(
                    futures.toArray(new CompletableFuture[0])
            );

            // Sonuçları topla
            return allFutures.thenApply(v ->
                    futures.stream()
                            .map(CompletableFuture::join)
                            .toList()
            ).join();
        } catch (IOException e) {
            throw new RuntimeException("Dosya okunamadı", e);
        }
    }

    public static List<EmployeeLocation> parseFileWithBatches(Path filePath) {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            List<String> lines = Files.readAllLines(filePath);
            int batchSize = 1000; // Her task 1000 satır işlesin
            List<CompletableFuture<List<EmployeeLocation>>> futures = new ArrayList<>();

            for (int i = 0; i < lines.size(); i += batchSize) {
                int end = Math.min(i + batchSize, lines.size());
                List<String> batch = lines.subList(i, end);
                futures.add(CompletableFuture.supplyAsync(() ->
                                batch.stream()
                                        .map(EmployeeLocationParser::parseLine)
                                        .toList(),
                        executor
                ));
            }

            return futures.stream()
                    .flatMap(future -> future.join().stream())
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException("Dosya okunamadı", e);
        }
    }

    private static EmployeeLocation parseLine(String line) {
        // Satırı parse et (örneğin CSV formatı)
        String[] parts = line.split(",");
        return new EmployeeLocation(parts[0], parts[1]);
    }

    static class EmployeeLocation {
        private final String name;
        private final String location;

        public EmployeeLocation(String name, String location) {
            this.name = name;
            this.location = location;
        }

        @Override
        public String toString() {
            return "EmployeeLocation{name='" + name + "', location='" + location + "'}";
        }
    }
}
