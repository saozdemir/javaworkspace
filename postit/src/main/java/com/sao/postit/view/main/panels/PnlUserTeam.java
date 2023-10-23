package com.sao.postit.view.main.panels;

import com.sao.postit.model.dto.Team;
import com.sao.postit.util.bundle.BundleReader;

import javax.swing.*;
import java.awt.*;

/**
 * @author saozd
 * @project com.sao.postit.view.main.panels courseexample
 * 4.06.2023 Haz 2023
 */
public class PnlUserTeam extends JPanel {
    private DefaultListModel<Team> listModel = new DefaultListModel<>();
    private JList<Team> listUserTeam = new JList(listModel);

    /**
     * Creates a new <code>JPanel</code> with a double buffer
     * and a flow layout.
     */
    public PnlUserTeam() {
        init();
    }

    private void init() {
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createTitledBorder(BundleReader.getString("PST.main.userTeam")));

        listUserTeam.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.add(new JScrollPane(listUserTeam), BorderLayout.CENTER);

    }

    public DefaultListModel<Team> getListModel() {
        return listModel;
    }

    public JList<Team> getListUserTeam() {
        return listUserTeam;
    }
}
