package com.sao.swing.table.editabletablemodel;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CellChangeAndUpdateExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Cell Change and Update Example");
        JTable table = new JTable();

        DefaultTableModel tableModel = new DefaultTableModel(
                new Object[][]{
                        {"1", "John", "Doe"},
                        {"2", "Jane", "Smith"},
                        {"3", "Bob", "Johnson"},
                },
                new String[]{"ID", "First Name", "Last Name"}
        );

        table.setModel(tableModel);

        tableModel.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    int column = e.getColumn();//Çalışan satır
                    if (column == 1) { // Eğer değişiklik "First Name" sütununda olduysa
                        int row = e.getFirstRow();
                        String firstName = (String) tableModel.getValueAt(row, column);
                        String updatedLastName = "Updated " + firstName; // Yeni Last Name değeri
                        tableModel.setValueAt(updatedLastName, row, 2); // Last Name sütununu güncelle
                    }
                }
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

