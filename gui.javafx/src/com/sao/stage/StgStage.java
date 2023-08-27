package com.sao.stage;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

import java.awt.*;

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

    public StgStage() {
        init();
        actions();
    }

    private void init() {
        StackPane pnCommon = new StackPane();
        pnCommon.getChildren().add(lblInfo);
        scene = new Scene(pnCommon, 300, 200);
        this.setTitle("Stage Example");
        this.setScene(scene); // Root panel ekleme
        this.setWidth(100);
        this.setHeight(200);
        this.show();
        //this.initStyle(StageStyle.TRANSPARENT); Araç çubuğunu kaldırır
        //this.setIconified(true);
        //this.setResizable(false);
        //this.setFullScreen(true);

        //Pozisyon
//        this.setX(20);
//        this.setY(100);
//        this.setAlwaysOnTop(true);//En öne getir
        //this.hide();
        //this.close();


    }

    private void actions() {
        /**
         * Ekran kapaılırken yapılacaklar.
         */
        this.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {

            }
        });
    }
}
