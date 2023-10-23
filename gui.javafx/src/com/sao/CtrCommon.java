package com.sao;

import com.sao.pane.StgPaneCommon;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao
 * @date 23.Eki.2023
 * <p>
 * @description:
 */
public class CtrCommon {
    private final StgPaneCommon stage;

    public CtrCommon(StgPaneCommon stage) {
        this.stage = stage;
        acctions();
    }

    private void acctions() {
        stage.getPnCommon().getBtn1().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
    }
}
