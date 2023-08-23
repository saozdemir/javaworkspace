package com.sao.swing.table.editabletablemodel.view;

import javax.swing.*;
import java.awt.*;

public class FrmEditableTableSpecial extends JFrame {
    private PnlEditableTableSpecial pnlCommon = new PnlEditableTableSpecial();

    public FrmEditableTableSpecial() throws HeadlessException {
        this.setSize(new Dimension(500, 500));
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.add(pnlCommon, BorderLayout.CENTER);
        this.setVisible(true);
    }
}
