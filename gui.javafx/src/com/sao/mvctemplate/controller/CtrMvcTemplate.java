package com.sao.mvctemplate.controller;

import com.sao.mvctemplate.model.MvcTemplateModel;
import com.sao.mvctemplate.view.StgMvcTemplate;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.mvctemplate.controller
 * @date 23.Eki.2023
 * <p>
 * @description:
 */
public class CtrMvcTemplate {
    private final StgMvcTemplate stage;
    private MvcTemplateModel model = new MvcTemplateModel();

    public CtrMvcTemplate(StgMvcTemplate stage) {
        this.stage = stage;
        actions();
    }

    private void actions() {
        stage.getPnCommon().getPnLogin().getBtnOk().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert message = new Alert(Alert.AlertType.INFORMATION);
                message.setTitle("Login");
                message.setHeaderText(null);
                message.setContentText(stage.getPnCommon().getPnLogin().getTxtName().getText() + " Logged in successfully!");
                message.show();

                model.login();// model uzerinden veritabanı işlemlerini başlatmak için kullanılacak.
            }
        });
    }
}
