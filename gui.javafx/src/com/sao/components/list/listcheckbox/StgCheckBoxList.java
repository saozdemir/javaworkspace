package com.sao.components.list.listcheckbox;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * @author saozd
 * @project com.sao.components.list.listcheckbox javaworkspace
 * @date 8.09.2023 Eyl 2023
 * <p>
 * @description:
 */
public class StgCheckBoxList extends Stage {
    private ListView<String> lstCheck;
    private ObservableList<String> observableList = FXCollections.observableArrayList(
            "Item 1", "Item 2", "Item 3"
    );

    /**
     * Creates a new instance of decorated {@code Stage}.
     *
     * @throws IllegalStateException if this constructor is called on a thread
     *                               other than the JavaFX Application Thread.
     */
    public StgCheckBoxList() {
        init();
    }

    private void init() {
        BorderPane pane = new BorderPane();
        lstCheck = new ListView<>(observableList);

        pane.setCenter(lstCheck);

//        lstCheck.setCellFactory(CheckBoxListCell.forListView(new Callback<String, ObservableList<String>>() {
//            @Override
//            public ObservableList<String> call(String param) {
//                ObservableList<String> item = FXCollections.observableArrayList();
//                item.add(param);
//                return item;
//            }
//        }));

        Scene scene = new Scene(pane,400,400);
        this.setTitle("List CheckBox Example");
        this.setScene(scene);
        this.show();
    }
}
