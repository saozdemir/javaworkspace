package com.sao.mvctemplate.view;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.mvctemplate.view
 * @date 23.Eki.2023
 * <p>
 * @description: Tüm Paneleri kapsayan ortak bir Pane
 */
public class PnCommon extends BorderPane {
    private PnLogin pnLogin = new PnLogin();
    public PnCommon() {
        init();
    }

    private void init() {
        this.setCenter(pnLogin);// Common pane'in center lokasyonuna login pane eklendi
    }

    public PnLogin getPnLogin() {
        return pnLogin;
    }
}
