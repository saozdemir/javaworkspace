package com.sao.components.list;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author saozd
 * @project com.sao.components.list javaworkspace
 * @date 28.08.2023 Ağu 2023
 * <p>
 * @description:
 */
public class StgList extends Stage {
    private Label lblDuty = new Label("Seçilen: -");
    private ListView<Duty> lstDuty;
    private ObservableList<Duty> lstModel = FXCollections.observableArrayList(DutyVirtualDB.dutyList);

    /**
     * Creates a new instance of decorated {@code Stage}.
     *
     * @throws IllegalStateException if this constructor is called on a thread
     *                               other than the JavaFX Application Thread.
     */
    public StgList() {
        init();
        action();
    }

    private void init() {
        BorderPane pane = new BorderPane();
        VBox paneList = new VBox();
        lstDuty = new ListView<Duty>(lstModel);

        paneList.getChildren().add(lstDuty);

        pane.setTop(lblDuty);
        pane.setCenter(paneList);

        Scene scene = new Scene(pane, 400, 400);
        this.setTitle("List Example");
        this.setScene(scene);
        this.show();
    }

    private void action() {
        lstDuty.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Duty>() {
            @Override
            public void changed(ObservableValue<? extends Duty> observable, Duty oldValue, Duty newValue) {
                Duty selectedDuty = lstDuty.getSelectionModel().getSelectedItem();
                lblDuty.setText("Seçilen: " + selectedDuty.toString());
            }
        });
    }
}
