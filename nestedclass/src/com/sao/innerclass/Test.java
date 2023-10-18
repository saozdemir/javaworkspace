package com.sao.innerclass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao
 * @date 18.Eki.2023
 * <p>
 * @description: Innercalss comparator kullanımı
 */
public class Test {
    public static void main(String[] args) {
        List<StudentInner> studentInnerList = new ArrayList<>(Arrays.asList(
                new StudentInner("Esra", 26),
                new StudentInner("Ahmet", 32),
                new StudentInner("Emir", 1)
        ));

        //InnerClass olarak comparator kullanımı
        var innerComparator = new StudentInner().new StudentComparator<StudentInner>(); // Inner class "new" key'i ile oluşturuldu.
        studentInnerList.sort(innerComparator);
        System.out.println("Comparator: " + innerComparator);
        for(StudentInner s : studentInnerList){
            System.out.println(s);
        }
    }
}
