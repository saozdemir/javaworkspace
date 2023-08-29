package com.sao.components.choicebox;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.components.choicebox
 * @date 29.Ağu.2023
 * <p>
 * @description:
 */
public class StgChoiceBox extends Stage {
    private ChoiceBox<ChoiceBoxItem> cBoxItem;
    private ObservableList cBoxModel;
    private Label lblItems = new Label("Selected Items: -");

    public StgChoiceBox() {
        init();
        actions();
    }

    private void init() {
        BorderPane pane = new BorderPane();

        cBoxModel = FXCollections.observableArrayList(ChoiceBoxVirtualDB.cBoxItems);
        cBoxItem = new ChoiceBox<>(cBoxModel);


        pane.setTop(lblItems);
        pane.setCenter(cBoxItem);

        Scene scene = new Scene(pane, 400, 400);

        this.setTitle("ChoiceBox Example");
        this.setScene(scene);
        this.show();
    }

    private void actions() {
        cBoxItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lblItems.setText(cBoxItem.getValue().toString());
            }
        });
    }
}
