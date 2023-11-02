package com.sao.imageview;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.imageview
 * @date 02.Kas.2023
 * <p>
 * @description:
 */
public class ImageViewApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        new StgImageView();
    }
}
