package com.sao.staticnestedclass;

import com.sao.staticnestedclass.StudentStaticNested;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao
 * @date 18.Eki.2023
 * <p>
 * @description: Static Nested Class olarak comparator kullanımı
 */
public class Test {
    public static void main(String[] args) {
        List<StudentStaticNested> studentList = new ArrayList<>(Arrays.asList(
                new StudentStaticNested("Esra", 26),
                new StudentStaticNested("Ahmet", 32),
                new StudentStaticNested("Emir", 1)
        ));

        //Static Nested Class
        var staticNestedComparator = new StudentStaticNested.StudentComparator<StudentStaticNested>(); // Inner class burada static nested olduğu için "new" key'i ile çağrılmadı.
        studentList.sort(staticNestedComparator);
        System.out.println("Comparator: " + staticNestedComparator);
        for(StudentStaticNested s : studentList){
            System.out.println(s);
        }
    }
}
