package com.sao.swing.table.editabletablemodel.abstractmodel;

import java.util.List;

public class SpecialTableModel<T> extends SpecialAbstractTableModel<T> {
    public SpecialTableModel(List<T> rowDataList, SpecialRowDescription<T> rowDescription) {
        super(rowDataList, rowDescription);
    }
}
