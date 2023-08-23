package com.sao.swing.table.editabletablemodel.abstractmodel;

public interface SpecialRowDescription<T> {
    int getColumnCount();

    String getColumnName(int column);

    T setCellValueAt(int column, T data, Object value);

    Object getCellValueAt(int column, T data);

    T getNewObject();

    boolean isCellEditable(int rowIndex, int columnIndex, T data);
}
