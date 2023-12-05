package com.sao.swing.dragdrop;

import javax.swing.*;
import java.awt.*;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.swing.dragdrop
 * @date 28.Kas.2023
 * <p>
 * @description:
 */
public class FrmNews extends JFrame {
    private JPanel pnlCommon = new JPanel(new GridLayout(1,2));
    private JPanel pnlInput = new JPanel(new GridBagLayout());
    private JPanel pnlPhoto = new JPanel(new BorderLayout());


    public FrmNews() throws HeadlessException {
        init();
    }

    private void init() {



        this.getContentPane().add(BorderLayout.CENTER, pnlCommon);
        this.setSize(400, 300);
        this.setVisible(true);
    }
}
