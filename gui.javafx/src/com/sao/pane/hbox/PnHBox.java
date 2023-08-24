package com.sao.pane.hbox;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Shape;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.pane.hbox
 * @date 24.Ağu.2023
 * <p>
 * @description: HBox = JPanel + FlowLayout
 */
public class PnHBox extends HBox {
    private Button btn1 = new Button("Button 1");
    private Button btn2 = new Button("Button 2");
    private Button btn3 = new Button("Button 3");

    public PnHBox() {
        init();
    }

    private void init() {
        this.setPadding(new Insets(10, 10, 10, 10));
        this.setSpacing(10);
        this.getChildren().addAll(btn1, btn2, btn3);
    }
}
