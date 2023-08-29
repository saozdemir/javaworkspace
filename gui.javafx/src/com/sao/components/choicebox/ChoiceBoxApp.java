package com.sao.components.choicebox;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.components.choicebox
 * @date 29.Ağu.2023
 * <p>
 * @description:
 */
public class ChoiceBoxApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        new StgChoiceBox();
    }
}
