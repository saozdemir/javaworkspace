package com.sao.mvctemplate.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.mvctemplate.view
 * @date 23.Eki.2023
 * <p>
 * @description: Login ekranı ve componentlerini içeren Pane
 */
public class PnLogin extends GridPane {
    private Label lblName = new Label("Kullanıcı Adı");
    private TextField txtName = new TextField();

    private Label lblPass = new Label("Şifre");
    private PasswordField txtPass = new PasswordField();

    private Button btnOk = new Button("Tamam");

    public PnLogin() {
        init();
    }

    private void init() {
        this.setVgap(10);
        this.setHgap(10);
        this.setPadding(new Insets(10));
        //this.setGridLinesVisible(true);// Grid çizgileri
        placeComponent();
    }

    private void placeComponent() {
        this.add(lblName,0,0,1,1);
        this.add(txtName,1,0,1,1);

        this.add(lblPass,0,1,1,1);
        this.add(txtPass,1,1,1,1);

        this.add(btnOk,1,2,2,1);
    }

    public TextField getTxtName() {
        return txtName;
    }

    public PasswordField getTxtPass() {
        return txtPass;
    }

    public Button getBtnOk() {
        return btnOk;
    }
}
