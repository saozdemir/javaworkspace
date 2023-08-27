package com.sao.components.combobox;

/**
 * @author saozd
 * @project com.sao.components.combobox javaworkspace
 * @date 27.08.2023 Ağu 2023
 * <p>
 * @description:
 */
public class Mission {
    private long id;
    private String name;

    public Mission(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
