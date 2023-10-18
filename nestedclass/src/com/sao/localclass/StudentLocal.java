package com.sao.localclass;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.localclass
 * @date 18.Eki.2023
 * <p>
 * @description:
 */
public class StudentLocal {
    private String name;
    private int age;

    public StudentLocal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public StudentLocal() {
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "%-8s %d".formatted(name, age);
    }
}
