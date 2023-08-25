package com.sao.components.button;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.swing.*;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.components.button
 * @date 25.Ağu.2023
 * <p>
 * @description:
 */
public class StgButton extends Stage {
    private Button btnOk = new Button("Ok");

    public StgButton() {
        init();
    }

    private void init() {
        StackPane pane = new StackPane();

        initButton();

        pane.getChildren().add(btnOk);

        Scene scene = new Scene(pane, 400, 400);
        this.setTitle("Button Example");
        this.setScene(scene); // Root panel ekleme
        this.setWidth(100);
        this.setHeight(200);
        this.show();
    }

    private void initButton() {
        btnOk.setTooltip(new Tooltip("Button1 Tooltip Text"));
        ImageView icon = new ImageView(new Image("/images/accept.png"));
        icon.setFitHeight(24);
        icon.setFitWidth(24);
        btnOk.setGraphic(icon);
    }
}
