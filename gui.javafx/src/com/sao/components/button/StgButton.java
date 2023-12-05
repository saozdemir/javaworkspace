package com.sao.components.button;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
    private ToggleButton btnToggle = new ToggleButton("Switch");
    private ToggleButton btnToggle2 = new ToggleButton("Switch2");

    private RadioButton btnMale = new RadioButton("Male");
    private RadioButton btnFemale = new RadioButton("Female");
    private ToggleGroup bgpGender = new ToggleGroup();

    private ToggleGroup getBgpSwitch = new ToggleGroup();


    public StgButton() {
        init();
    }

    private void init() {
        HBox pane = new HBox();

        initButton();

        btnMale.setToggleGroup(bgpGender);
        btnFemale.setToggleGroup(bgpGender);

        btnToggle.setToggleGroup(getBgpSwitch);
        btnToggle2.setToggleGroup(getBgpSwitch);
        btnToggle2.setSelected(true);

        pane.getChildren().addAll(btnToggle,btnToggle2, btnMale, btnFemale, btnOk);
        Scene scene = new Scene(pane, 400, 400);

        this.setTitle("Button Example");
        this.setScene(scene); // Root panel ekleme
        this.setWidth(400);
        this.setHeight(400);
        this.show();
    }

    private void initButton() {
        btnOk.setTooltip(new Tooltip("Button1 Tooltip Text"));
        ImageView icon = new ImageView(new Image("/images/accept.png"));
        icon.setFitHeight(24);
        icon.setFitWidth(24);
        btnOk.setGraphic(icon);
        actions();
    }

    private void actions() {
        bgpGender.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {

            }
        });

    }
}
