package com.sao.mvctemplate.view;

import com.sao.mvctemplate.controller.CtrMvcTemplate;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.mvctemplate
 * @date 23.Eki.2023
 * <p>
 * @description:
 */
public class StgMvcTemplate extends Stage {
    private PnCommon pnCommon = new PnCommon();
    private CtrMvcTemplate controller;

    public StgMvcTemplate() {
        init();
        initController();
    }

    private void init() {
        StackPane pnStackPane = new StackPane();
        pnStackPane.getChildren().add(pnCommon);
        Scene scene = new Scene(pnStackPane, 400, 400);
        this.setTitle("Stage Example");
        this.setScene(scene);
        this.show();
    }

    private void initController() {
        controller = new CtrMvcTemplate(this); // Stage referans olarak gönderildi.
    }

    public PnCommon getPnCommon() {
        return pnCommon;
    }
}
