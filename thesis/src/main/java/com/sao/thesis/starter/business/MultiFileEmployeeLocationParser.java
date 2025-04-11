package com.sao.thesis.starter.business;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

/**
 * @author saozdemir
 * @project javaworkspace
 * @date 11 Nis 2025
 * <p>
 * @description:
 */
public class MultiFileEmployeeLocationParser {
    public static void main(String[] args) {
        List<Path> filePaths = List.of(
                Path.of("D:\\home\\IdeaProjects\\javaworkspace\\thesis\\src\\main\\java\\com\\sao\\thesis\\starter\\business\\file2.txt"),
                Path.of("D:\\home\\IdeaProjects\\javaworkspace\\thesis\\src\\main\\java\\com\\sao\\thesis\\starter\\business\\file3.txt"),
                Path.of("D:\\home\\IdeaProjects\\javaworkspace\\thesis\\src\\main\\java\\com\\sao\\thesis\\starter\\business\\file4.txt"),
                Path.of("D:\\home\\IdeaProjects\\javaworkspace\\thesis\\src\\main\\java\\com\\sao\\thesis\\starter\\business\\file5.txt"),
                Path.of("D:\\home\\IdeaProjects\\javaworkspace\\thesis\\src\\main\\java\\com\\sao\\thesis\\starter\\business\\file6.txt")
        );

        // Virtual Thread ile çoklu dosya okuma
        long startTime = System.currentTimeMillis();
        List<EmployeeLocation> allLocations = parseMultipleFiles(filePaths);
        long endTime = System.currentTimeMillis();
        System.out.println("Virtual Thread Time: " + (endTime - startTime) + " ms");

        // Single Thread ile çoklu dosya okuma
        startTime = System.currentTimeMillis();
        List<EmployeeLocation> singleThreadResult = parseMultipleFilesSingleThread(filePaths);
        endTime = System.currentTimeMillis();
        System.out.println("Single Thread Time: " + (endTime - startTime) + " ms");
    }

    public static List<EmployeeLocation> parseMultipleFiles(List<Path> filePaths) {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            // Her dosya için bir CompletableFuture başlat
            List<CompletableFuture<List<EmployeeLocation>>> futures = filePaths.stream()
                    .map(filePath -> CompletableFuture.supplyAsync(
                            () -> parseFile(filePath),
                            executor
                    ))
                    .toList();

            // Tüm dosyaların işlenmesini bekle
            CompletableFuture<Void> allFutures = CompletableFuture.allOf(
                    futures.toArray(new CompletableFuture[0])
            );

            // Sonuçları birleştir
            return allFutures.thenApply(v ->
                    futures.stream()
                            .flatMap(future -> future.join().stream())
                            .toList()
            ).join();
        } catch (Exception e) {
            throw new RuntimeException("Hata oluştu", e);
        }
    }

    public static List<EmployeeLocation> parseMultipleFilesSingleThread(List<Path> filePaths) {
        List<EmployeeLocation> result = new ArrayList<>();
        for (Path filePath : filePaths) {
            try {
                // Her dosyayı tek tek oku ve parse et
                List<EmployeeLocation> locations = Files.lines(filePath)
                        .map(MultiFileEmployeeLocationParser::parseLine)
                        .toList();
                result.addAll(locations);
            } catch (IOException e) {
                throw new RuntimeException(filePath + " okunamadı", e);
            }
        }
        return result;
    }

    private static List<EmployeeLocation> parseFile(Path filePath) {
        try {
            return Files.lines(filePath)
                    .map(MultiFileEmployeeLocationParser::parseLine)
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(filePath + " okunamadı", e);
        }
    }

    private static EmployeeLocation parseLine(String line) {
        String[] parts = line.split(",");
        EmployeeLocation location = new EmployeeLocation(parts[0], parts[1]);
        return location;
    }

    static class EmployeeLocation {
        private final String name;
        private final String location;

        public EmployeeLocation(String name, String location) {
            this.name = name;
            this.location = location;
        }
    }
}
