package com.sao.threads.calculation;

/**
 * @author saozdemir
 * @project javaworkspace
 * @date 24 May 2024
 * <p>
 * @description:
 */
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Personel {
    private final int id;
    private final double[] workHours; // Günlere göre çalışma saatleri

    public Personel(int id) {
        this.id = id;
        this.workHours = new double[365];
        // Rastgele çalışma saatleriyle doldur
        Random random = new Random();
        for (int i = 0; i < 365; i++) {
            this.workHours[i] = 1 + random.nextDouble() * 8; // 1 ile 9 saat arasında çalışıyor
        }
    }

    public double getTotalWorkHours(int days) {
        return IntStream.range(0, days).mapToDouble(i -> workHours[i]).sum();
    }

    public int getId() {
        return id;
    }

    public static List<Personel> generatePersonelList(int size) {
        return IntStream.range(0, size).mapToObj(Personel::new).collect(Collectors.toList());
    }
}

