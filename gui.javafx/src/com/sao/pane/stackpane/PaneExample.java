package com.sao.pane.stackpane;

import com.sao.stage.StgStage;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.pane.stackpane
 * @date 24.Ağu.2023
 * <p>
 * @description: Pane = JPanel + Layout
 */
public class PaneExample extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        new StgPaneAndLayout();
    }
}
