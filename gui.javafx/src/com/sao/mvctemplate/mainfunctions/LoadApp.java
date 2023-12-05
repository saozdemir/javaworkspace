package com.sao.mvctemplate.mainfunctions;

import com.sao.mvctemplate.view.StgMvcTemplate;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.mvctemplate.mainfunctions
 * @date 20.Kas.2023
 * <p>
 * @description:
 */
public class LoadApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        new StgSample();
    }
}
