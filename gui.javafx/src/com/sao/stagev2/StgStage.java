package com.sao.stagev2;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
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
public class StgStage extends Application {
    private Stage stage =new Stage();
    private Scene scene;
    private Label lblInfo = new Label("Info");

    public StgStage() {
        initStage();
        actions();
    }

    private void initStage() {
        StackPane pnCommon = new StackPane();
        pnCommon.getChildren().add(lblInfo);
        scene = new Scene(pnCommon, 300, 200);
        stage.setTitle("Stage Example");
        stage.setScene(scene); // Root panel ekleme
        stage.setWidth(100);
        stage.setHeight(200);
//        this.show();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void actions() {
        /**
         * Ekran kapaılırken yapılacaklar.
         */
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {

            }
        });
    }

    public Stage getStage() {
        return stage;
    }
}
