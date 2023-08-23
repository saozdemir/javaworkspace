package com.sao.swing.table.selectedrowobject;

import javax.swing.*;
import java.awt.*;

public class FrmStudent extends JFrame {
    private PnlStudent pnlCommon = new PnlStudent();
    private CtrStudent controller;

    public FrmStudent() {
        init();
        initController();
    }

    private void init() {
        this.setVisible(true);
        this.setTitle("Table Example");
        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(800, 800));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.add(pnlCommon, BorderLayout.CENTER);
    }

    private void initController() {
        controller = new CtrStudent(this);
    }

    public PnlStudent getPnlCommon() {
        return pnlCommon;
    }

    public CtrStudent getController() {
        return controller;
    }
}
