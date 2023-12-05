package com.sao.stagev2;

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
    public static void main(String[] args) throws Exception {
        launch(args);
        StageExample stageExample = new StageExample();
//        stageExample.start(new StgStage());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//        StgStage stage;
//        if (primaryStage == null) {
//            stage = new StgStage();
//        } else {
//            stage = (StgStage) primaryStage;
//        }
//        stage.show();
    }
}
