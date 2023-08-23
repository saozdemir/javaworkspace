package com.sao.swing.table.selectedrowobject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PnlStudent extends JPanel {
    private PnlStudentButton pnlStudentButton;
    private StudentTable tblStudent;
    private StudentTableModel studentTableModel;
    private List<Student> studentList = new ArrayList<>();

    public PnlStudent() {
        init();
    }

    private void init() {
        this.setLayout(new BorderLayout());
        createList();
        initTable();
    }

    private void createList() {
        Student s1 = new Student(1, "Ahmet", 20);
        Student s2 = new Student(2, "Esra", 50);
        Student s3 = new Student(3, "Badem", 60);
        Student s4 = new Student(4, "Tarçın", 90);
        Student s5 = new Student(5, "Bebem", 100);
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s4);
        studentList.add(s5);

    }

    private void initTable() {
        pnlStudentButton = new PnlStudentButton();
        studentTableModel = new StudentTableModel(studentList);
        tblStudent = new StudentTable(studentTableModel);


        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createTitledBorder("Table Panel"));
        this.add(new JScrollPane(tblStudent), BorderLayout.CENTER);
        this.add(pnlStudentButton, BorderLayout.PAGE_END);
    }

    public StudentTable getTblStudent() {
        return tblStudent;
    }

    public StudentTableModel getStudentTableModel() {
        return studentTableModel;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public PnlStudentButton getPnlStudentButton() {
        return pnlStudentButton;
    }
}
