package com.sao.lambda.syntax;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.lambda.syntax
 * @date 26.Eki.2023
 * <p>
 * @description:
 */
public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("alpha", "bravo", "charlie", "delta"));

        /**
         * Normal bir foreach döngüsü
         */
        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("------------------------");

        /**
         * Lambda ifae ile for each kullanımı
         */
        list.forEach((s) -> System.out.println(s));

        System.out.println("------------------------");

        /**
         * Küme parantezi ile daha fazla satırdan oluşan kodlar yazışabilir.
         */
        list.forEach((s) -> {
            char first = s.charAt(0);
            System.out.println(s + " means " + first);
        });


        System.out.println("-----------------------");
        /**
         * Lambda ve lokal değişken kullanımları
         */
        /**
         * Doğru kullanım bu şekilde olmalıdır.
         * Lambda içinde kullanılacak lokal değişken başka bir yerde değiştirilirse kod hata verecektir.
         */
        final String prefix = "nato";
        //String prefix = "NATO"; bu tanımlama kullanılır ancak değiştirilirse hata verecektir.
        list.forEach((s) -> {
            //prefix = "**"; Hata verecektir.
            char first = s.charAt(0);
            System.out.println(prefix + " " + s + " means " + first);//Üstte tanımlanan local değişken kullanıldı.
        });

        //System.out.println(s); // lambda içinde kullanılan değişkenler scope dışında kullanılamaz.


        /**
         * Functiona Interface yardımı ile oluşturulmuş bir lambda expression ifadesi
         */
        int result = calculator((a, b) -> a + b, 5, 2);
        var result2 = calculator((a, b) -> a / b, 10.0, 2.5);

        //Sadece sayı değil benzer işlemleri String ile de yapabilir.
        var result3 = calculator((a, b) -> a.toUpperCase() + " " + b.toUpperCase(), "Cat", "Dog");

        //return ifadesi küme parantezi ile kullanılabilir ancak sona ";" eklenmeli
        var result4 = calculator((a, b) -> {return a * b;}, 7, 8);

    }

    public static <T> T calculator(Operation<T> function, T value1, T value2) {
        T result = function.operate(value1, value2);
        System.out.println("Result of operation : " + result);
        return result;
    }
}
