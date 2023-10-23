package com.sao.pane;

import com.sao.CtrCommon;
import com.sao.pane.borderpane.PnBorderPane;
import com.sao.pane.flowpane.PnFlowPane;
import com.sao.pane.gridpane.PnGridPane;
import com.sao.pane.gridpane.PnGridPaneButton;
import com.sao.pane.hbox.PnHBox;
import com.sao.pane.titledpane.PnTitledPane;
import com.sao.pane.vbox.PnVBox;
import javafx.scene.Scene;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.pane
 * @date 24.Ağu.2023
 * <p>
 * @description:
 */
public class StgPaneCommon extends Stage {
    /**BorderPane*/
    //private PnBorderPane pnCommon = new PnBorderPane();

    /**HBox*/
    //private PnHBox pnCommon = new PnHBox();

    /**VBox*/
    //private PnVBox pnCommon = new PnVBox();

    /**TitlePane*/
    //private PnTitledPane pnCommon = new PnTitledPane();

    /**FlowPane*/
    //private PnFlowPane pnCommon = new PnFlowPane();

    /**GridPane*/
    //private PnGridPane pnCommon = new PnGridPane();
    private PnGridPaneButton pnCommon = new PnGridPaneButton();

    private CtrCommon controller;


    public StgPaneCommon() {
        init();
        initController();
    }

    private void initController() {
        controller = new CtrCommon(this);
    }

    private void init() {
        StackPane pnStackPane = new StackPane();
        pnStackPane.getChildren().add(pnCommon);
        Scene scene = new Scene(pnStackPane, 400, 400);
        this.setTitle("Stage Example");
        this.setScene(scene); // Root panel ekleme
//        this.setWidth(400);
//        this.setHeight(400);
        this.show();
    }

    public PnGridPaneButton getPnCommon() {
        return pnCommon;
    }
}
