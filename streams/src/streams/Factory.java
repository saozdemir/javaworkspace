package streams;

import java.util.*;

/**
 * @author saozdemir
 * @project javaworkspace
 * @date 09 Mar 2025
 * <p>
 * @description:
 */
public class Factory {
    private static Random random = new Random();

    private static List<String> nameList = Arrays.asList("Ahmet", "Emir", "Seyit", "Kerem", "Esra", "İbrahim", "Hatice", "Hıfzı");

    private static List<String> emptyNameList = new ArrayList<>();

    private static List<String> duplicatedNameList = Arrays.asList("Ahmet", "Emir", "Ahmet", "Emir", "Esra", "İbrahim", "Hatice", "Hıfzı", "Emir");

    private static Set<String> nameSet = new HashSet<>(Arrays.asList("Ahmet", "Ahmet", "Emir", "Seyit", "Kerem", "Esra", "İbrahim", "Hatice", "Hıfzı"));

    private static int[] intArray = new int[]{32, 57, 21, 84, 19, 69, 30, 8, 85, 47};

    private static long[] longArray = new long[]{323_284_289_283L, 4L, 21L, 327_942_428_184L, 261_283L, 300_000L, 888_888L, 302L, 741L};

    private static double[] doubleArray = new double[]{45.92, 75.71, 12.03, 94.00, 19.37, 3.1415, 2.71828, 14.44, 68.73, 59.08};

    private static String[] stringIntArray = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25",
            "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50"};

    public static double[] getDoubleArray() {
        return doubleArray;
    }

    public static List<String> getDuplicatedNameList() {
        return duplicatedNameList;
    }

    public static List<String> getEmptyNameList() {
        return emptyNameList;
    }

    public static int[] getIntArray() {
        return intArray;
    }

    public static long[] getLongArray() {
        return longArray;
    }

    public static List<String> getNameList() {
        return nameList;
    }

    public static Set<String> getNameSet() {
        return nameSet;
    }

    public static String[] getStringIntArray() {
        return stringIntArray;
    }


}
