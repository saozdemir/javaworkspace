package com.sao.threads.performancediff;

import java.util.ArrayList;
import java.util.List;

/**
 * @author saozdemir
 * @project javaworkspace
 * @date 08 Eki 2024
 * <p>
 * @description:
 */
public class VirtualThreadOperation {
    public static void main(String[] args) throws InterruptedException {
        List<Personnel> personnelList = new ArrayList<>();

        for (int i = 1; i <= 1000; i++) {
            personnelList.add(new Personnel(i, "Personnel" + i));
        }

        long startTime = System.currentTimeMillis();

        List<Thread> threadList = new ArrayList<>();
        for (Personnel personnel : personnelList) {
            Thread thread = Thread.ofVirtual().start(() -> {
                databaseOperation(personnel);
            });
            threadList.add(thread);
        }

        for (Thread thread : threadList) {
            thread.join();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Platform Thread Performance Time: " + (endTime - startTime));

    }

    private static void databaseOperation(Personnel personnel) {
        try {
            Thread.sleep(100);
            System.out.println("Completed: " + personnel.getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
