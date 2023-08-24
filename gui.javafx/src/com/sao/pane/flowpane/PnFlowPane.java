package com.sao.pane.flowpane;

import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;

/**
 * @author saozd
 * @project com.sao.pane.flowpane javaworkspace
 * @date 25.08.2023 Ağu 2023
 * <p>
 * @description:
 */
public class PnFlowPane extends FlowPane {
    private Button btn1 = new Button("Button 1");
    private Button btn2 = new Button("Button 2");
    private Button btn3 = new Button("Button 3");

    /**
     * Creates a horizontal FlowPane layout with hgap/vgap = 0.
     */
    public PnFlowPane() {
        this.setHgap(10);
        this.setVgap(10);
        this.getChildren().addAll(btn1,btn2,btn3);

        btn1.setPrefSize(100,100);
        btn2.setPrefSize(100,100);
        btn3.setPrefSize(100,100);

    }
}
