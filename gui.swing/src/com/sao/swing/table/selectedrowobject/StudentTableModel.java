package com.sao.swing.table.selectedrowobject;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class StudentTableModel extends AbstractTableModel {
    public static final int ID = 0;
    public static final int NAME = 1;
    public static final int EXAM = 2;
    private List<Student> studentList;

    public StudentTableModel(List<Student> studentList) {
        this.studentList = studentList;
    }

    private final String[] columnNames = new String[]{
            "ID", "NAME", "EXAM"
    };
    private final Class[] columnClass = new Class[]{
            Integer.class, String.class, Integer.class
    };

    @Override
    public int getRowCount() {
        return studentList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnClass[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        super.setValueAt(aValue, rowIndex, columnIndex);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student row = studentList.get(rowIndex);
        switch (columnIndex) {
            case ID:
                return row.getId();
            case NAME:
                return row.getName();
            case EXAM:
                return row.getExam();
            default:
                return null;
        }
    }

    public Student getData(int row) {
        Student data = new Student();
        for (int col = 0; col < columnNames.length; col++) {
            switch (col) {
                case ID:
                    data.setId((Integer) getValueAt(row, col));
                    break;
                case NAME:
                    data.setName((String) getValueAt(row, col));
                    break;
                case EXAM:
                    data.setExam((Integer) getValueAt(row, col));
            }
        }

        return data;
    }

//    public <T> T getData(int row) {
//        T data = null;
//
//
//        return data;
//    }
}
