package com.sao.swing.table.selectedrowobject;

public class Student {
    private int id;
    private  String name;
    private int exam;

    public Student(int id, String name, int exam) {
        this.id = id;
        this.name = name;
        this.exam = exam;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExam() {
        return exam;
    }

    public void setExam(int exam) {
        this.exam = exam;
    }
}
