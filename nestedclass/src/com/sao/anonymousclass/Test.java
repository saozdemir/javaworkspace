package com.sao.anonymousclass;

import com.sao.staticnestedclass.StudentStaticNested;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.anonymousclass
 * @date 18.Eki.2023
 * <p>
 * @description: Comparator anonymous class kullanımı
 */
public class Test {
    public static void main(String[] args) {
        List<StudentAnonymous> studentList = new ArrayList<>(Arrays.asList(
                new StudentAnonymous("Esra", 26),
                new StudentAnonymous("Ahmet", 32),
                new StudentAnonymous("Emir", 1)
        ));

        //Anonymous class olarak comparator kullanımı
        var anonymousComparator = new Comparator<StudentAnonymous>() {

            @Override
            public int compare(StudentAnonymous o1, StudentAnonymous o2) {
                return o1.getAge() - o2.getAge();
            }
        };

        studentList.sort(anonymousComparator);
        System.out.println("Comparator: " + anonymousComparator);
        for(StudentAnonymous s : studentList){
            System.out.println(s);
        }
    }
}
