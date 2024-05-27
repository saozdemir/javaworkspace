package com.sao.threads.calculation;

/**
 * @author saozdemir
 * @project javaworkspace
 * @date 28 May 2024
 * <p>
 * @description:
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HyperThreadingCheck {
    public static void main(String[] args) {
        int logicalCores = Runtime.getRuntime().availableProcessors();
        int physicalCores = getPhysicalCores();

        System.out.println("Logical Cores: " + logicalCores);
        System.out.println("Physical Cores: " + physicalCores);

        if (logicalCores > physicalCores) {
            System.out.println("Hyper-Threading is enabled.");
        } else {
            System.out.println("Hyper-Threading is not enabled.");
        }
    }

    private static int getPhysicalCores() {
        int cores = 0;
        try {
            String command = "";
            String os = System.getProperty("os.name").toLowerCase();

            if (os.contains("win")) {
                command = "wmic CPU Get NumberOfCores /Format:List";
            } else if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
                command = "lscpu | grep '^Core(s) per socket:' | awk '{print $4}'";
            }

            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            if (os.contains("win")) {
                while ((line = reader.readLine()) != null) {
                    if (line.startsWith("NumberOfCores=")) {
                        cores = Integer.parseInt(line.split("=")[1].trim());
                        break;
                    }
                }
            } else {
                while ((line = reader.readLine()) != null) {
                    if (line.matches("\\d+")) {
                        cores = Integer.parseInt(line.trim());
                        break;
                    }
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cores;
    }
}

