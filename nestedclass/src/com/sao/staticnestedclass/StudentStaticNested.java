package com.sao.staticnestedclass;

import java.util.Comparator;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.staticnestedclass
 * @date 18.Eki.2023
 * <p>
 * @description:
 */
public class StudentStaticNested {
    private String name;
    private int age;

    public StudentStaticNested() {
    }

    public StudentStaticNested(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static class StudentComparator<T extends StudentStaticNested> implements Comparator<StudentStaticNested> {

        @Override
        public int compare(StudentStaticNested o1, StudentStaticNested o2) {
            return o1.age - o2.age;
        }
    }

    @Override
    public String toString() {
        return "%-8s %d".formatted(name, age);
    }
}
