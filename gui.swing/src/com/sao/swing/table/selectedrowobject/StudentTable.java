package com.sao.swing.table.selectedrowobject;

import javax.swing.*;

public class StudentTable extends JTable {
    public StudentTable(StudentTableModel studentTableModel) {
        super(studentTableModel);
        init();
    }

    private void init() {
        this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.setRowHeight(23);
//        this.setDefaultRenderer(String.class, new StudentCellRenderer());
        //this.setSelectionBackground(blend(Color.RED, Color.LIGHT_GRAY));
//        this.setSelectionBackground(Color.RED);

    }

//    public static Color blend(Color c0, Color c1) {
//        double totalAlpha = c0.getAlpha() + c1.getAlpha();
//        double weight0 = c0.getAlpha() / totalAlpha;
//        double weight1 = c1.getAlpha() / totalAlpha;
//
//        double r = weight0 * c0.getRed() + weight1 * c1.getRed();
//        double g = weight0 * c0.getGreen() + weight1 * c1.getGreen();
//        double b = weight0 * c0.getBlue() + weight1 * c1.getBlue();
//        double a = Math.max(c0.getAlpha(), c1.getAlpha());
//
//        return new Color((int) r, (int) g, (int) b, (int) a);
//    }
}
