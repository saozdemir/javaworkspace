package com.sao.components.list.listcombobox;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @author saozd
 * @project com.sao.components.list.listcombobox javaworkspace
 * @date 8.09.2023 Eyl 2023
 * <p>
 * @description:
 */
public class StgComboList extends Stage {
    private Label lblInfo = new Label("Seçilen: -");
    private ListView<Selection> lstSelectionListView;
    private ObservableList<Selection> selectionObservableList = FXCollections.observableArrayList();
    private ObservableList selectionComboList = FXCollections.observableArrayList();

    /**
     * Creates a new instance of decorated {@code Stage}.
     *
     * @throws IllegalStateException if this constructor is called on a thread
     *                               other than the JavaFX Application Thread.
     */
    public StgComboList() {
        init();
        actions();
    }

    private void init() {
        BorderPane pane = new BorderPane();
        selectionObservableList.addAll(SelectionVirtualDB.selectionList);
        selectionComboList.addAll(SelectionVirtualDB.selectionComboList);
        lstSelectionListView = new ListView(selectionObservableList);

        lstSelectionListView.setEditable(true);
        pane.setTop(lblInfo);
        pane.setCenter(lstSelectionListView);


        lstSelectionListView.setItems(selectionObservableList);
        lstSelectionListView.setCellFactory(ComboBoxListCell.forListView(selectionComboList));

        Scene scene = new Scene(pane, 400, 400);
        this.setTitle("List Combobox Example");
        this.setScene(scene);
        this.show();
    }

    private void actions() {
        lstSelectionListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Selection>() {
            @Override
            public void changed(ObservableValue<? extends Selection> observable, Selection oldValue, Selection newValue) {
                Selection selection = lstSelectionListView.getSelectionModel().getSelectedItem();
                lblInfo.setText("Seçilen: " + selection.getId() + " " + selection.getSelection());
            }
        });

//        lstSelectionListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
//            Selection selection = lstSelectionListView.getSelectionModel().getSelectedItem();
//            lblInfo.setText("Seçilen: " + selection.getId() + " " + selection.getSelection());
//        });
    }

}
