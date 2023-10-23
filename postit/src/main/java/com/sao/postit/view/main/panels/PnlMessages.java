package com.sao.postit.view.main.panels;

import com.sao.postit.model.dto.Message;
import com.sao.postit.model.dto.Team;
import com.sao.postit.util.bundle.BundleReader;

import javax.swing.*;
import java.awt.*;

/**
 * @author saozd
 * @project com.sao.postit.view.main.panels courseexample
 * 4.06.2023 Haz 2023
 */
public class PnlMessages extends JPanel {
    private DefaultListModel<Team> listModel = new DefaultListModel<>();
    private JList<Message> listTeamMessage = new JList(listModel);
    /**
     * Creates a new <code>JPanel</code> with a double buffer
     * and a flow layout.
     */
    public PnlMessages() {
        init();
    }

    private void init() {
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createTitledBorder(BundleReader.getString("PST.main.teamMessage")));

        listTeamMessage.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.add(new JScrollPane(listTeamMessage), BorderLayout.CENTER);
    }
}
