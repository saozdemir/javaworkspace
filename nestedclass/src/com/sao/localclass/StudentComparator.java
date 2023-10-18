package com.sao.localclass;

import java.util.Comparator;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.localclass
 * @date 18.Eki.2023
 * <p>
 * @description: Local bir sınıf için comparator tanımlandı. Normal nesne oluşturularak kullanılacak.
 */
public class StudentComparator<T extends StudentLocal> implements Comparator<StudentLocal> {

    @Override
    public int compare(StudentLocal o1, StudentLocal o2) {
        return o1.getAge() - o2.getAge();
    }
}
