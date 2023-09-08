package com.sao.components.list.listcombobox;

/**
 * @author saozd
 * @project com.sao.components.list.listcombobox javaworkspace
 * @date 8.09.2023 Eyl 2023
 * <p>
 * @description:
 */
public class Selection {
    private int id;
    private String selection;

    public Selection(int id, String selection) {
        this.id = id;
        this.selection = selection;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection;
    }

    @Override
    public String toString() {
        return selection;
    }
}
