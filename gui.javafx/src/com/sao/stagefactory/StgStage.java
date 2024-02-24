package com.sao.stagefactory;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.stage
 * @date 24.Ağu.2023
 * <p>
 * @description:
 */
public class StgStage extends Stage {
    private Scene scene;
    private Label lblInfo = new Label("Info");
    private Button btnOk = new Button("Ok");
    private static int count = 0;

    public StgStage() {
        init();
        actions();
    }

    private void init() {
        StackPane pnCommon = new StackPane();
        pnCommon.getChildren().addAll(lblInfo, btnOk);
        scene = new Scene(pnCommon, 300, 200);
        this.setTitle("Stage Example");
        this.setScene(scene); // Root panel ekleme
        this.setWidth(100);
        this.setHeight(200);
        this.show();
    }

    private void actions() {
        btnOk.setOnAction(event -> {
            lblInfo.setText("Ok Pressed." + count);
            count++;
        });
    }
}
