package com.sao.components.combobox;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author saozd
 * @project com.sao.components.combobox javaworkspace
 * @date 27.08.2023 Ağu 2023
 * <p>
 * @description:
 */
public class StgComboBox extends Stage {
    private ComboBox<Mission> cmbMission;
    private ObservableList<Mission> missions;

    private ComboBox<String> cmbDetails;
    private ObservableList<String> details;

    /**
     * Creates a new instance of decorated {@code Stage}.
     *
     * @throws IllegalStateException if this constructor is called on a thread
     *                               other than the JavaFX Application Thread.
     */
    public StgComboBox() {
        init();
    }

    private void init() {
        HBox pane = new HBox();

        initCombo();

        pane.getChildren().addAll(cmbMission, cmbDetails);
        Scene scene = new Scene(pane, 400, 400);
        this.setTitle("ComboBox Example");
        this.setScene(scene); // Root panel ekleme
        this.setWidth(400);
        this.setHeight(400);
        this.show();
        actions();
    }

    private void initCombo() {
        missions = FXCollections.observableArrayList(MissionVirtualDB.missions);
        cmbMission = new ComboBox<>(missions);

        cmbDetails = new ComboBox<>();
    }


    private void actions() {

        /**
         * 1- FXCollections.observableArrayList(..) içine alacağı bir list ile elemanları set eder.
         * 2- Combobox dan seçim yapıldığında çalışacak olan kod cmbMission.setOnAction(..) kodudur.
         * 3- Combobox dan seçilen elemanı alma kodu -> cmbMission.getValue()
         */
        cmbMission.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cmbDetails.setItems(FXCollections.observableArrayList(MissionVirtualDB.missionAndDetailsMap.get(cmbMission.getValue())));
            }
        });
    }
}
