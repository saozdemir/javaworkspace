package com.sao.swing.table.editabletablemodel;


import com.sao.swing.table.editabletablemodel.view.FrmEditableTableSpecial;

import javax.swing.*;

public class TableApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmEditableTableSpecial();
            }
        });
    }
}
