package com.sao.postit.controller;

import com.sao.postit.business.PostItBusiness;
import com.sao.postit.model.dto.Team;
import com.sao.postit.view.main.FrmPostIt;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * @author saozd
 * @project com.sao.postit.controller courseexample
 * 4.06.2023 Haz 2023
 */
public class CtrPostIt {
    private final FrmPostIt frame;
    private PostItBusiness business = new PostItBusiness();

    public CtrPostIt(FrmPostIt frame) {
        this.frame = frame;
        loadData();
        initForActions();
    }

    private void loadData() {
        frame.getPnlPostIt().getPnlUserTeam().getListModel().addAll(business.getTeamList());
    }

    private void initForActions() {
        frame.getPnlPostIt().getPnlUserTeam().getListUserTeam().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Team team = frame.getPnlPostIt().getPnlUserTeam().getListUserTeam().getSelectedValue();
            }
        });
    }
}
