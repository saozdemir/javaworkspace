package com.sao.localclass;

import com.sao.staticnestedclass.StudentStaticNested;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.localclass
 * @date 18.Eki.2023
 * <p>
 * @description:
 */
public class Test {
    public static void main(String[] args) {
        List<StudentLocal> studentList = new ArrayList<>(Arrays.asList(
                new StudentLocal("Esra", 26),
                new StudentLocal("Ahmet", 32),
                new StudentLocal("Emir", 1)
        ));

        //Local Class olarak comparator kullanımı
        var localComparator = new StudentComparator<StudentLocal>(); // Normal bir sınıf tanımlaması gibi kullanıldı.
        studentList.sort(localComparator);
        System.out.println("Comparator: " + localComparator);
        for(StudentLocal s : studentList){
            System.out.println(s);
        }
    }
}
