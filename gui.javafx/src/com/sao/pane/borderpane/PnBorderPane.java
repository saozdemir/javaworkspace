package com.sao.pane.borderpane;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import javax.swing.*;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.pane.borderpane
 * @date 24.Ağu.2023
 * <p>
 * @description:
 */
public class PnBorderPane extends BorderPane {
    private Button btnTop = new Button("Top");
    private Button btnBottom = new Button("Bottom");
    private Button btnCenter = new Button("Center");
    private Button btnLeft = new Button("Left");
    private Button btnRight = new Button("Right");
    public PnBorderPane() {
        init();
    }

    private void init() {
        this.setPadding(new Insets(10,10,10,10));
        this.setTop(btnTop);
        this.setBottom(btnBottom);
        this.setLeft(btnLeft);
        this.setRight(btnRight);
        this.setCenter(btnCenter);
    }
}
