package com.sao.mvctemplate.mainfunctions;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.mvctemplate.mainfunctions
 * @date 20.Kas.2023
 * <p>
 * @description:
 */
public class StgSample extends Stage {
    public StgSample() {
        StackPane pnStackPane = new StackPane();
        Scene scene = new Scene(pnStackPane, 400, 400);
        this.setTitle("Stage Example");
        this.setScene(scene);
        this.show();
    }
}
