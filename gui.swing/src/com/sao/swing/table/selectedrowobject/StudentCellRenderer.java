package com.sao.swing.table.selectedrowobject;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class StudentCellRenderer extends DefaultTableCellRenderer {

//    public StudentCellRenderer() {
//        super.setOpaque(true);
//    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//        Student rowData = (Student) value;


//        if (isSelected) {
//            super.setBackground(Color.red);
//        } else {
//            super.setBackground(Color.white);
//        }
        String name = (String) value;
        switch (column) {
            case 1:
                if (name == "Ahmet") {
                    super.setBackground(Color.YELLOW);
                }
                break;
        }


//        switch (column) {
//            case 2:
//                if (rowData.getExam() < 20) {
//                    component.setBackground(Color.RED);
//                } else if (rowData.getExam() >= 20 && rowData.getExam() < 70) {
//                    component.setBackground(Color.ORANGE);
//                } else {
//                    component.setBackground(Color.GREEN);
//                }
//                break;
//
//        }

        return component;
    }

    public static Color blend(Color c0, Color c1) {
        double totalAlpha = c0.getAlpha() + c1.getAlpha();
        double weight0 = c0.getAlpha() / totalAlpha;
        double weight1 = c1.getAlpha() / totalAlpha;

        double r = weight0 * c0.getRed() + weight1 * c1.getRed();
        double g = weight0 * c0.getGreen() + weight1 * c1.getGreen();
        double b = weight0 * c0.getBlue() + weight1 * c1.getBlue();
        double a = Math.max(c0.getAlpha(), c1.getAlpha());

        return new Color((int) r, (int) g, (int) b, (int) a);
    }
}
