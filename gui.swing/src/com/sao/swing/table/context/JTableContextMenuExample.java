package com.sao.swing.table.context;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.swing.table.context
 * @date 29.Kas.2023
 * <p>
 * @description:
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JTableContextMenuExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("JTable Context Menu Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JTable table = createTable();
            JScrollPane scrollPane = new JScrollPane(table);

            frame.add(scrollPane);
            frame.setSize(400, 300);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    private static JTable createTable() {
        String[] columnNames = {"ID", "Name", "Age", "Status"};
        Object[][] data = {
                {1, "John", 25, "Valid"},
                {2, "Jane", 30, "Invalid"},
                {3, "Doe", 22, "Valid"}
        };

        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Durum sütunu dışındaki hücreleri düzenleme izni verme
                return column != 3;
            }
        };

        JTable table = new JTable(model);

        // Sağ tıklayınca çağrılacak olan context menu oluşturucu
        JPopupMenu popupMenu = createPopupMenu(table);

        // MouseAdapter kullanarak sağ tıklama olaylarını dinleme
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    int row = table.rowAtPoint(e.getPoint());
                    int col = table.columnAtPoint(e.getPoint());

                    // Seçili hücreyi belirleme
                    table.clearSelection();
                    table.addRowSelectionInterval(row, row);
                    table.addColumnSelectionInterval(col, col);

                    // Sağ tıklama olayını işleme
                    if (e.isPopupTrigger()) {
                        popupMenu.show(table, e.getX(), e.getY());
                    }
                }
            }
        });

        return table;
    }

    private static JPopupMenu createPopupMenu(JTable table) {
        JPopupMenu popupMenu = new JPopupMenu();

        JMenuItem makeValidItem = new JMenuItem("Geçerli Yap");
        makeValidItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    table.setValueAt("Valid", selectedRow, 3);
                }
            }
        });
        popupMenu.add(makeValidItem);

        JMenuItem makeInvalidItem = new JMenuItem("Geçersiz Yap");
        makeInvalidItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    table.setValueAt("Invalid", selectedRow, 3);
                }
            }
        });
        popupMenu.add(makeInvalidItem);

        return popupMenu;
    }
}


