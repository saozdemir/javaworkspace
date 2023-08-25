package com.sao.pane.gridpane;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.pane.gridpane
 * @date 25.Ağu.2023
 * <p>
 * @description:
 */
public class PnGridPane extends GridPane {
    private Label lblName = new Label("Kullanıcı Adı");
    private TextField txtName = new TextField();

    private Label lblPass = new Label("Şifre");
    private PasswordField txtPass = new PasswordField();

    private Button btnOk = new Button("Tamam");

    public PnGridPane() {
        init();
    }

    private void init() {
        this.setVgap(10);
        this.setHgap(10);
        this.setPadding(new Insets(10));
        this.setGridLinesVisible(true);

        this.add(lblName,0,0,1,1);
        this.add(txtName,1,0,1,1);

        this.add(lblPass,0,1,1,1);
        this.add(txtPass,1,1,1,1);

        this.add(btnOk,1,2,2,1);
    }
}
