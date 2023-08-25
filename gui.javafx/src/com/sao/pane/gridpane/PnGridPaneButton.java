package com.sao.pane.gridpane;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;

import java.util.List;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.pane.gridpane
 * @date 25.Ağu.2023
 * <p>
 * @description:
 */
public class PnGridPaneButton extends GridPane {
    private Button btn1 = new Button("Button 1");
    private Button btn2 = new Button("Button 2");
    private Button btn3 = new Button("Button 3");
    private Button btn4 = new Button("Button 4");
    private Button btn5 = new Button("Button 5");
    private Button btn6 = new Button("Button 6");
    private Button btn7 = new Button("Button 7");

    public PnGridPaneButton() {
        init();
    }

    private void init() {
        this.setVgap(1);
        this.setHgap(1);
        this.setPadding(new Insets(1));
//        this.setGridLinesVisible(true);
//        this.setAlignment(Pos.CENTER);

        this.add(btn1, 0, 0);
        this.add(btn2, 0, 1);
        this.add(btn3, 1, 0, 2, 2);
        this.add(btn4, 0, 2, 3, 1);
        this.add(btn5, 0, 3);
        this.add(btn6, 1, 3);
        this.add(btn7, 2, 3);

        btn1.setTooltip(new Tooltip("Btn1"));
//        btn3.setMaxSize(100,100);
//        GridPane.setFillHeight(btn3,true);


        //this.setMaxSize(200,200);
        List<Node> nodeList = this.getChildren();
        for (Node node : nodeList) {
            if(node instanceof Button){
                ((Button) node).setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
            }
        }
    }
}
