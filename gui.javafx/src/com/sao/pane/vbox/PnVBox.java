package com.sao.pane.vbox;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.pane.vbox
 * @date 24.Ağu.2023
 * <p>
 * @description: VBox = JPanel + VerticalFlowLayout
 */
public class PnVBox extends VBox {
    private Button btn1 = new Button("Button 1");
    private Button btn2 = new Button("Button 2");
    private Button btn3 = new Button("Button 3");

    public PnVBox() {
        init();
    }

    private void init() {
        this.setPadding(new Insets(10, 10, 10, 10));
        this.setSpacing(10);
        this.getChildren().addAll(btn1, btn2, btn3);
    }
}
