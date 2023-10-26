package com.sao.lambda.basic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.lambda.basic
 * @date 26.Eki.2023
 * <p>
 * @description:
 */
public class LambdaBasic {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Ahmet", 31));
        people.add(new Person("Emir", 1));
        people.add(new Person("Esra", 25));

        /**
         * Anonymous class kullanımı
         */
        people.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        for (Person person : people) {
            System.out.println(person);
        }

        /**
         * Lambda expression kullanımı
         */
        people.sort((o1, o2) -> o1.getAge() - o2.getAge());

        for (Person person : people) {
            System.out.println(person);
        }
        /**
         * Comparator sınıfını genişletip yeni yetenek eklendi
         */
        interface EnhanceComparator<T> extends Comparator<T> {
            int second(T o1, T o2);
        }

        var comparatorMixed = new EnhanceComparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int result = o1.getName().compareTo(o2.getName());
                return result == 0 ? second(o1, o2) : result;
            }

            @Override
            public int second(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        };

        System.out.println("Comparator Mixed");
        people.sort(comparatorMixed);

        for (Person person : people) {
            System.out.println(person);
        }
    }
}
