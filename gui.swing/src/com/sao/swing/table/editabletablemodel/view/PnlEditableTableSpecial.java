package com.sao.swing.table.editabletablemodel.view;



import com.sao.swing.table.editabletablemodel.abstractmodel.SpecialAbstractTableModel;
import com.sao.swing.table.editabletablemodel.abstractmodel.SpecialTableModel;
import com.sao.swing.table.editabletablemodel.data.Person;
import com.sao.swing.table.editabletablemodel.rowdescription.EditableTableRowDescription;
import com.sao.swing.table.editabletablemodel.rowdescription.EditableTableRowDescriptionSpecial;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PnlEditableTableSpecial extends JPanel {
    private TblEditableTableSpecial table;
    private EditableTableRowDescription rowDesc;
    private EditableTableRowDescriptionSpecial rowDescSpecial;
    private SpecialAbstractTableModel<Person> tableModelSpecial;

    private JLabel lblSelected = new JLabel("...");
    private JButton btnUpdate = new JButton("Update");

    public PnlEditableTableSpecial() {
        this.setLayout(new BorderLayout());
        //init();
        initSpecial();

        actions();

    }


    private void init() {
        rowDesc = new EditableTableRowDescription(createPersonList());
    }

    private List<Person> createPersonList() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(100, "Ahmet", "Özdemir"));
        personList.add(new Person(101, "Esra", "Özdemir"));
        personList.add(new Person(102, "Emir", "Özdemir"));
        return personList;
    }

    private void initSpecial() {
        rowDescSpecial = new EditableTableRowDescriptionSpecial();
        tableModelSpecial = new SpecialTableModel<Person>(createPersonList(), rowDescSpecial);
        table = new TblEditableTableSpecial(tableModelSpecial);

        this.add(lblSelected, BorderLayout.PAGE_START);
        this.add(new JScrollPane(table), BorderLayout.CENTER);
        this.add(btnUpdate, BorderLayout.PAGE_END);
    }

    private void actions() {
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Person> actualPersonList = createPersonList();
                actualPersonList.add(new Person(104, "EEEE", "WWWW"));
                tableModelSpecial.setData(actualPersonList);
                table.clearSelection();
                tableModelSpecial.fireTableDataChanged();
            }
        });

//        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
//            @Override
//            public void valueChanged(ListSelectionEvent e) {
//                Person selectedPerson = (Person) table.getSelectedObject();
//                if (selectedPerson != null) {
//                    lblSelected.setText(selectedPerson.getId() + " " +
//                            selectedPerson.getName() + " " +
//                            selectedPerson.getSurname());
//                }
//            }
//        });

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                System.out.println("valueChanged");
                int row = table.getSelectedRow();
                int column = table.getSelectedColumn();
                String name = (String) tableModelSpecial.getValueAt(row, column);//Burada nesne olacak.
                System.out.println(name);
                if(!name.equals("Date") && column == EditableTableRowDescription.NAME){
                    table.getColumnModel().getColumn(EditableTableRowDescription.SURNAME).
                            setCellEditor(new DefaultCellEditor(new JTextField()));
                }
            }
        });

//        table.getModel().addTableModelListener(new TableModelListener() {
//            @Override
//            public void tableChanged(TableModelEvent e) {
//                System.out.println(e.getColumn());
//
//            }
//        });

        tableModelSpecial.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    int column = table.getSelectedColumn();
                    if (column == EditableTableRowDescription.NAME) {
                        int row = e.getFirstRow();
                        System.out.println("col " + column + " row " + row);
                        String firstName = (String) tableModelSpecial.getValueAt(row, column);
                        if (firstName.equals("Date")) {
                            String[] str = {"AAA", "BBB", "CCC"};
                            table.getColumnModel().getColumn(EditableTableRowDescription.SURNAME).
                                    setCellEditor(new DefaultCellEditor(new JComboBox<String>(new DefaultComboBoxModel<>(str))));
                            //table.setCellEditor(new DefaultCellEditor(new JComboBox<String>(new DefaultComboBoxModel<>(str))));
                        } else {
                            table.getColumnModel().getColumn(EditableTableRowDescription.SURNAME).
                                    setCellEditor(new DefaultCellEditor(new JTextField()));
                        }
                    }
                }
//                System.out.println("Table type " + e.getType());
//                System.out.println("Table model " + table.getSelectedColumn());
            }
        });
    }

}
