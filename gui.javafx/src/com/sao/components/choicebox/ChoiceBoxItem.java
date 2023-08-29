package com.sao.components.choicebox;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.components.choicebox
 * @date 29.Ağu.2023
 * <p>
 * @description:
 */
public class ChoiceBoxItem {
    private int number;
    private String name;

    public ChoiceBoxItem(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
