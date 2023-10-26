package com.sao.lambda.basic;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.lambda.basic
 * @date 26.Eki.2023
 * <p>
 * @description:
 */
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "%-8s %d".formatted(name, age);
    }
}
