package com.sao.swing.table.selectedrowobject;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrStudent {
    private final FrmStudent frame;

    public CtrStudent(FrmStudent frame) {
        this.frame = frame;
        initActions();
    }

    private void initActions() {
        frame.getPnlCommon().getStudentTableModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (frame.getPnlCommon().getTblStudent().isRowSelected(1)) {
                    JOptionPane.showMessageDialog(frame, "Seçildi", "Uyarı", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        frame.getPnlCommon().getPnlStudentButton().btnShow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(frame,"Basıldı","Uyarı",JOptionPane.INFORMATION_MESSAGE);
                Student student = (Student) frame.getPnlCommon().getStudentTableModel().getData(frame.getPnlCommon().getTblStudent().getSelectedRow());

                frame.getPnlCommon().getPnlStudentButton().lblShow.setText("" + student.getId() + " " +
                        student.getName() + " " + student.getExam());
            }
        });

        frame.getPnlCommon().getTblStudent().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                Student student = (Student) frame.getPnlCommon().getStudentTableModel().getData(frame.getPnlCommon().getTblStudent().getSelectedRow());

                frame.getPnlCommon().getPnlStudentButton().lblShow.setText("" + student.getId() + " " +
                        student.getName() + " " + student.getExam() + " [SELECTED] ");
            }
        });

    }

}
