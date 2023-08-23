package com.sao.swing.table.editabletablemodel.rowdescription;


import com.sao.swing.table.editabletablemodel.abstractmodel.SpecialRowDescription;
import com.sao.swing.table.editabletablemodel.data.Person;

import java.util.List;

public class EditableTableRowDescriptionSpecial implements SpecialRowDescription<Person> {
    public static final int ID = 0;
    public static final int NAME = 1;
    public static final int SURNAME = 2;


    private String[] COLUMN_NAMES = {
            "ID", "ADI", "SOYADI"
    };

    private int[] COLUMN_INDEX = {ID, NAME, SURNAME};

    private Class[] COLUMN_CLASS = {Integer.class, String.class, String.class};

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }

    @Override
    public Person setCellValueAt(int column, Person data, Object value) {
        Person person = data;
        switch (column) {
            case ID:
                person.setId(Integer.parseInt(value.toString()));
                break;
            case NAME:
                person.setName((String) value);
                break;
            case SURNAME:
                person.setSurname((String) value);
                break;
            default:
                break;
        }
        return data;
    }

    @Override
    public Object getCellValueAt(int column, Person data) {
        Person person = data;
        switch (column) {
            case ID:
                return person.getId();
            case NAME:
                return person.getName();
            case SURNAME:
                return person.getSurname();
            default:
                return null;
        }
    }

    @Override
    public Person getNewObject() {
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex, Person data) {
        return true;
    }
}
