package com.sao.anonymousclass;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.anonymousclass
 * @date 18.Eki.2023
 * <p>
 * @description:
 */
public class StudentAnonymous {
    private String name;
    private int age;

    public StudentAnonymous(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public StudentAnonymous() {
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
