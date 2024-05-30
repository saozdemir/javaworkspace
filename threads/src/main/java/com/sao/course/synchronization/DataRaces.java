package com.sao.course.synchronization;

/**
 * @author saozdemir
 * @project javaworkspace
 * @date 29 May 2024
 * <p>
 * @description: Race Conditions & Data Races
 */
public class DataRaces {
    public static void main(String[] args) {
        SharedClass sharedClass = new SharedClass();
        Thread thread1 = new Thread(() -> { //x ve y değerlerini artırır.
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                sharedClass.increment();
            }
        });

        Thread thread2 = new Thread(() -> { // eş zamanlı olarak x ve y nin eşit olup olmama durumlarını kontrol eder.
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                sharedClass.checkForDataRace();
            }

        });

        thread1.start();
        thread2.start();
    }

    public static class SharedClass {
//        private int x = 0; //
//        private int y = 0;
        private volatile int x = 0; //Atomik olarak tanımlandığı için istisnai durum ortaya çıkmayacak.
        private volatile int y = 0;

        public void increment() {
            x++;
            y++;
        }

        public void checkForDataRace() {
            if (y > x) {
                System.out.println("y > x - Data Race is detected");
            }
        }
    }
}
