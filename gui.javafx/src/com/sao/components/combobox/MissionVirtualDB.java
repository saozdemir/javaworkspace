package com.sao.components.combobox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author saozd
 * @project com.sao.components.combobox javaworkspace
 * @date 28.08.2023 Ağu 2023
 * <p>
 * @description:
 */
public class MissionVirtualDB {
    public static List<Mission> missions = new ArrayList<>();
    public static List<String> detailsOne = new ArrayList<>();
    public static List<String> detailsTwo = new ArrayList<>();

    public static Map<Mission, List<String>> missionAndDetailsMap = new HashMap<>();


    static {
        missions.add(new Mission(1L, "Görev 1"));
        missions.add(new Mission(2L, "Görev 2"));

        detailsOne.add("Görev 1 detay A");
        detailsOne.add("Görev 1 detay B");

        detailsTwo.add("Görev 2 detay I");
        detailsTwo.add("Görev 2 detay II");

        missionAndDetailsMap.put(missions.get(0), detailsOne);
        missionAndDetailsMap.put(missions.get(1), detailsTwo);

    }
}
