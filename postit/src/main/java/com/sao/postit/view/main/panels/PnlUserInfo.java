package com.sao.postit.view.main.panels;

import com.sao.postit.util.bundle.BundleReader;

import javax.swing.*;
import java.awt.*;

/**
 * @author saozd
 * @project com.sao.postit.view.main.panels courseexample
 * 4.06.2023 Haz 2023
 */
public class PnlUserInfo extends JPanel {
    private JLabel lblName = new JLabel(BundleReader.getString("PST.name"));
    private JLabel lblSurname = new JLabel(BundleReader.getString("PST.surname"));

    /**
     * Creates a new <code>JPanel</code> with a double buffer
     * and a flow layout.
     */
    public PnlUserInfo() {
        init();
        placeComponents();
        setComponentSize();
    }

    private void init() {
        this.setLayout(new GridBagLayout());
        this.setBorder(BorderFactory.createTitledBorder(BundleReader.getString("PST.user.info")));
    }

    private void placeComponents() {
        this.add(lblName, new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE, new Insets(2, 2, 2, 2), 1, 1));
        this.add(lblSurname, new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0, GridBagConstraints.LINE_START, GridBagConstraints.NONE, new Insets(2, 2, 2, 2), 1, 1));
    }

    private void setComponentSize() {
        this.setPreferredSize(new Dimension(200, 100));
    }
}
