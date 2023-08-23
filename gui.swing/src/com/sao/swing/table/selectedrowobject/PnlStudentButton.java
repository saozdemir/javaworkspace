package com.sao.swing.table.selectedrowobject;

import javax.swing.*;
import java.awt.*;

public class PnlStudentButton extends JPanel {
    JButton btnShow = new JButton("Göster");
    JLabel lblShow = new JLabel("-");

    public PnlStudentButton() {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setBorder(BorderFactory.createTitledBorder("Buton"));
        this.add(btnShow);
        this.add(lblShow);
    }

    public JButton getBtnShow() {
        return btnShow;
    }

    public JLabel getLblShow() {
        return lblShow;
    }
}
