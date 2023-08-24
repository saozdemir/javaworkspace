package com.sao.pane.titledpane;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * @author saozd
 * @project com.sao.pane.titledpane javaworkspace
 * @date 24.08.2023 Ağu 2023
 * <p>
 * @description: İçine tek bir bileşen aldığı için başka layout managerlerla kullanılır.
 */
public class PnTitledPane extends BorderPane {
    private TitledPane pnCenter;
    private VBox pnButton = new VBox();

    private Button btn1 = new Button("Button 1");
    private Button btn2 = new Button("Button 2");
    private Button btn3 = new Button("Button 3");

    /**
     * Creates a BorderPane layout.
     */
    public PnTitledPane() {
        init();
    }

    private void init() {
        this.setPadding(new Insets(10, 10, 10, 10));
        initButtonPane();
        pnCenter = new TitledPane("Buttons", pnButton);

        //pnCenter.setExpanded(true);
        pnCenter.setCollapsible(false); //Tık ile genişletmeyi kapama
        this.setCenter(pnCenter);


    }

    private void initButtonPane() {
        pnButton.getChildren().addAll(btn1, btn2, btn3);
    }
}
