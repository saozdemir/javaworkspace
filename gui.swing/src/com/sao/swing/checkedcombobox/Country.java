package com.sao.swing.checkedcombobox;

/**
 * @author saozdemir
 * @project javaworkspace
 * @date 21 Tem 2026
 * <p>
 * @description:
 */
public final class Country {
    private final String code;
    private final String name;

    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }
    public String getCode() { return code; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return name;
    }
}
