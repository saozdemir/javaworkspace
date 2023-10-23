package com.sao.postit.view.main;

import com.sao.postit.view.main.panels.PnlFooter;
import com.sao.postit.view.main.panels.PnlMessages;
import com.sao.postit.view.main.panels.PnlUserTeam;
import com.sao.postit.view.main.panels.PnlUserInfo;

import javax.swing.*;
import java.awt.*;

/**
 * @author saozd
 * @project com.sao.postit.view.main courseexample
 * 4.06.2023 Haz 2023
 */
public class PnlPostIt extends JPanel {
    private JPanel pnlUserArea = new JPanel(new GridBagLayout());
    private PnlUserInfo pnlUserInfo = new PnlUserInfo();
    private PnlUserTeam pnlUserTeam = new PnlUserTeam();
    private PnlMessages pnlMessages = new PnlMessages();
    private PnlFooter pnlFooter = new PnlFooter();

    /**
     * Creates a new <code>JPanel</code> with a double buffer
     * and a flow layout.
     */
    public PnlPostIt() {
        init();
    }

    private void init() {
        this.setLayout(new BorderLayout());
        initSubPanels();
    }

    private void initSubPanels() {
        pnlUserArea.add(pnlUserInfo, new GridBagConstraints(0, 0, 1, 1, 1.0, 0.1, GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(1, 5, 1, 1), 1, 1));
        pnlUserArea.add(pnlUserTeam, new GridBagConstraints(0, 1, 1, 1, 1.0, 0.9, GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(1, 5, 1, 1), 1, 1));

        pnlUserArea.setPreferredSize(new Dimension(200, 60));

        this.add(pnlUserArea, BorderLayout.LINE_START);
        this.add(pnlMessages, BorderLayout.CENTER);
        this.add(pnlFooter, BorderLayout.PAGE_END);
    }

    public PnlUserInfo getPnlUserInfo() {
        return pnlUserInfo;
    }

    public PnlUserTeam getPnlUserTeam() {
        return pnlUserTeam;
    }

    public PnlMessages getPnlMessages() {
        return pnlMessages;
    }
}
