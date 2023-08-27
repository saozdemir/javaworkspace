package com.sao.components.basic;


import com.sao.pane.hbox.PnHBox;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.*;

import java.awt.*;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

/**
 * @author saozd
 * @project com.sao.components.basic javaworkspace
 * @date 26.08.2023 Ağu 2023
 * <p>
 * @description:
 */
public class StgBasic extends Stage {
    private Label lblInfo = new Label("Info");
    private TextField txtField = new TextField();
    private PasswordField txtPass = new PasswordField();
    private IntegerTextField txtFieldInt = new IntegerTextField(0, 9);
    private TextArea txtArea = new TextArea();

    /**
     * Creates a new instance of decorated {@code Stage}.
     *
     * @throws IllegalStateException if this constructor is called on a thread
     *                               other than the JavaFX Application Thread.
     */
    public StgBasic() {
        init();
    }

    private void init() {
        BorderPane paneCommon = new BorderPane();
        HBox paneTop = new HBox();

        initTextFields();
        initTextArea();


        paneTop.getChildren().addAll(lblInfo, txtField, txtPass, txtFieldInt);
        paneCommon.setTop(paneTop);

        paneCommon.setCenter(txtArea);


        Scene scene = new Scene(paneCommon, 400, 400);
        this.setScene(scene);
        this.setTitle("Basic Components");
        this.show();
    }

    private void initTextFields() {
        //txtField.setTextFormatter(createTextFormatter());

    }

    private void initTextArea() {
    }


    private TextFormatter<?> createTextFormatter() {
        int MAX_VALUE = 2;
        int MIN_VALUE = 0;
        UnaryOperator<TextFormatter.Change> filter = change -> {
            String newText = change.getControlNewText();
            if (Pattern.matches("[0-9]*", newText)) {
                if (newText.length() >= MIN_VALUE) {
                    return change;
                }

                if (newText.length() > MAX_VALUE) {
                    return null;
                }
            }
            return null;
        };
        return new TextFormatter<Object>(filter);
    }
}
