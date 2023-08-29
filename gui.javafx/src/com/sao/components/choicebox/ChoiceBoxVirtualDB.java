package com.sao.components.choicebox;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.components.choicebox
 * @date 29.Ağu.2023
 * <p>
 * @description:
 */
public class ChoiceBoxVirtualDB {
    public static List<ChoiceBoxItem> cBoxItems = new ArrayList<>();

    static {
        cBoxItems.add(new ChoiceBoxItem(1, "Item 1"));
        cBoxItems.add(new ChoiceBoxItem(2, "Item 2"));
        cBoxItems.add(new ChoiceBoxItem(3, "Item 3"));
        cBoxItems.add(new ChoiceBoxItem(4, "Item 4"));
    }
}
