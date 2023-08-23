package com.sao.swing.table.selectedrowobject;

import javax.swing.*;

public class AppSelectedRowObject {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmStudent();
            }
        });
    }
}
