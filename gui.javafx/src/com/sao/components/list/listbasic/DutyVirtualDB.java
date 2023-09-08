package com.sao.components.list.listbasic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author saozd
 * @project com.sao.components.list.listbasic javaworkspace
 * @date 28.08.2023 Ağu 2023
 * <p>
 * @description:
 */
public class DutyVirtualDB {
    public static List<Duty> dutyList = new ArrayList<>();


    static {
        dutyList.add(new Duty(1L, "Görev Liste 1"));
        dutyList.add(new Duty(2L, "Görev Liste 2"));
        dutyList.add(new Duty(3L, "Görev Liste 3"));
        dutyList.add(new Duty(4L, "Görev Liste 4"));


    }
}
