package com.sao.swing.table.editabletablemodel.data;

import java.util.ArrayList;
import java.util.List;

public class PersonDBVirtual {
    public static List<Person> personDB = new ArrayList<>();

    static {
        personDB.add(new Person(100, "Ahmet", "Özdemir"));
        personDB.add(new Person(101, "Esra", "Özdemir"));
        personDB.add(new Person(102, "Emir", "Özdemir"));
    }
}
