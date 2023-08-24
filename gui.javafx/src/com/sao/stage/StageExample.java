package com.sao.stage;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.stage
 * @date 24.Ağu.2023
 * <p>
 * @description: Stage = JFrame
 */
public class StageExample extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        new StgStage();
    }
}
