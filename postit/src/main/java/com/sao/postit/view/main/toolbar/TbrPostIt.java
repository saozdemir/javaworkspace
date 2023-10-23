package com.sao.postit.view.main.toolbar;

import com.sao.postit.util.bundle.BundleReader;

import javax.swing.*;
import java.awt.*;

/**
 * @author saozd
 * @project com.sao.postit.view.main.toolbar courseexample
 * 6.06.2023 Haz 2023
 */
public class TbrPostIt extends JToolBar {
    private JButton btnUserManager = new JButton();

    /**
     * Creates a new tool bar; orientation defaults to <code>HORIZONTAL</code>.
     */
    public TbrPostIt() {
        init();
    }

    private void init() {
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setRollover(true);

        btnUserManager.setText(BundleReader.getString("PST.user.title"));
        btnUserManager.setToolTipText(BundleReader.getString("PST.user.title"));

        this.add(btnUserManager);
    }
}
