package com.sao.swing.table.editabletablemodel.rowdescription;



import com.sao.swing.table.editabletablemodel.data.Person;
import com.sao.swing.table.editabletablemodel.data.PersonDBVirtual;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class EditableTableRowDescription extends AbstractTableModel {
    public List<Person> personList = new ArrayList<>();

    public static final int ID = 0;
    public static final int NAME = 1;
    public static final int SURNAME = 2;

    public EditableTableRowDescription(List<Person> personList) {
        this.personList = personList;
    }

    private String[] COLUMN_NAMES = {
            "ID", "ADI", "SOYADI"
    };

    private int[] COLUMN_INDEX = {ID, NAME, SURNAME};

    private Class[] COLUMN_CLASS = {Integer.class, String.class, String.class};


    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return super.getColumnClass(columnIndex);
    }

    @Override
    public int getRowCount() {
        return personList.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Person person = PersonDBVirtual.personDB.get(rowIndex);
        switch (columnIndex) {
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
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Person person = PersonDBVirtual.personDB.get(rowIndex);
        switch (columnIndex) {
            case ID:
                person.setId(Integer.parseInt(aValue.toString()));
                break;
            case NAME:
                person.setName((String) aValue);
                break;
            case SURNAME:
                person.setSurname((String) aValue);
                break;
        }
    }
}
