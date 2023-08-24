package com.sao.pane.stackpane;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.pane.stackpane
 * @date 24.Ağu.2023
 * <p>
 * @description: Component boyutu kadar bir panel oluşturuyor
 */
public class StgPaneAndLayout extends Stage {
    private Button btnOk = new Button("Ok");
    private Button btnCancel = new Button("Cancel");
    public StgPaneAndLayout() {
        init();
    }

    private void init() {
        StackPane pnStackPane = new StackPane();
        pnStackPane.getChildren().add(btnOk);
        Scene scene = new Scene(pnStackPane, 300, 200);
        this.setTitle("Stage Example");
        this.setScene(scene); // Root panel ekleme
        this.setWidth(100);
        this.setHeight(200);
        this.show();
    }
}
