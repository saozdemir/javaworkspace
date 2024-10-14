package com.sao.threads.performancediff;

/**
 * @author saozdemir
 * @project javaworkspace
 * @date 08 Eki 2024
 * <p>
 * @description:
 */
public class Personnel {
    long id;
    String name;

    public Personnel(long id, String name) {
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
}
