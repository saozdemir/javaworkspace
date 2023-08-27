package com.sao.components.basic;

import com.sao.components.button.StgButton;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author saozd
 * @project com.sao.components.basic javaworkspace
 * @date 26.08.2023 Ağu 2023
 * <p>
 * @description:
 */
public class BasicApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        new StgBasic();
    }
}
