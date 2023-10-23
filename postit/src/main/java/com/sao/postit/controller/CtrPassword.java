package com.sao.postit.controller;

import com.sao.postit.util.exceptions.ExceptionHandler;
import com.sao.postit.view.main.FrmPostIt;
import com.sao.postit.view.password.FrmPassword;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author saozd
 * @project com.sao.postit.controller courseexample
 * 4.06.2023 Haz 2023
 */
public class CtrPassword {
    private final FrmPassword frame;

    public CtrPassword(FrmPassword frame) {
        this.frame = frame;
        initActions();
    }

    private void initActions() {
        frame.getPnlPassword().getBtnOk().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO password controller
                new FrmPostIt();
                frame.dispose();
            }
        });

        frame.getPnlPassword().getBtnCancel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Exception exception = new Exception("sssss");
                ExceptionHandler.showMessage(exception);
            }
        });
    }
}
