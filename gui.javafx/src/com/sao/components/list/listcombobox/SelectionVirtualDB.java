package com.sao.components.list.listcombobox;

import java.util.ArrayList;
import java.util.List;

/**
 * @author saozd
 * @project com.sao.components.list.listcombobox javaworkspace
 * @date 8.09.2023 Eyl 2023
 * <p>
 * @description:
 */
public class SelectionVirtualDB {
    public static List<Selection> selectionComboList = new ArrayList<>();
    public static List selectionList = new ArrayList<>();

    static {
        selectionComboList.add(new Selection(1, "Selection 1"));
        selectionComboList.add(new Selection(2, "Selection 2"));
        selectionComboList.add(new Selection(3, "Selection 3"));
        selectionComboList.add(new Selection(4, "Selection 4"));

        selectionList.add(new Selection(0,"-"));
        selectionList.add(new Selection(0,"-"));
        selectionList.add(new Selection(0,"-"));
    }
}
