package com.sao.pane;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.pane
 * @date 24.Ağu.2023
 * <p>
 * @description:
 */
public class PaneApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        new StgPaneCommon();
    }
}
