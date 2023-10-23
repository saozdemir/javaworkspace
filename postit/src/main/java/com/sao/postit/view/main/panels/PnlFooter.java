package com.sao.postit.view.main.panels;

import javax.swing.*;
import java.awt.*;

/**
 * @author saozd
 * @project com.sao.postit.view.main.panels courseexample
 * 8.06.2023 Haz 2023
 */
public class PnlFooter extends JPanel {
    private JLabel lblInfo = new JLabel();
    /**
     * Creates a new <code>JPanel</code> with a double buffer
     * and a flow layout.
     */
    public PnlFooter() {
        init();
    }

    private void init() {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(lblInfo);
        this.setBorder(BorderFactory.createEtchedBorder());
    }

    public JLabel getLblInfo() {
        return lblInfo;
    }
}
