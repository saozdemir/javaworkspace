package com.sao.components.button;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.components.button
 * @date 25.Ağu.2023
 * <p>
 * @description:
 */
public class ButtonApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        new StgButton();
    }
}
