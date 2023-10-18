package com.sao.innerclass;

import java.util.Comparator;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.innerclass
 * @date 18.Eki.2023
 * <p>
 * @description:
 */
public class StudentInner {
    private String name;
    private int age;

    public StudentInner() {
    }

    public StudentInner(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public class StudentComparator<T extends StudentInner> implements Comparator<StudentInner> {

        @Override
        public int compare(StudentInner o1, StudentInner o2) {
            return o1.age - o2.age;
        }
    }

    @Override
    public String toString() {
        return "%-8s %d".formatted(name, age);
    }
}
