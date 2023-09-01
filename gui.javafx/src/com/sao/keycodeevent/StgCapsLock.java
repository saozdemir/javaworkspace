package com.sao.keycodeevent;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.keycodeevent
 * @date 01.Eyl.2023
 * <p>
 * @description:
 */
public class StgCapsLock extends Application {
    private TextField txtUserName = new TextField();
    private PasswordField txtPass = new PasswordField();
    private Label lblCapsLock = new Label("CapsLock is ON");

    private boolean capsLockIsOn;

    @Override
    public void start(Stage stage) {
        //CapsLock durumunu al
        lblCapsLock.setVisible(Toolkit.getDefaultToolkit().getLockingKeyState(java.awt.event.KeyEvent.VK_CAPS_LOCK));

        /**
         * Kullanıcı adı ve şifre alanlarına tıklandığını kontrol ediyor
         */
        EventHandler<MouseEvent> capsLockMouseEvent = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                lblCapsLock.setVisible(Toolkit.getDefaultToolkit().getLockingKeyState(java.awt.event.KeyEvent.VK_CAPS_LOCK));
            }
        };

        //Kullanıcı adı ve şifre için aynı EventHandler
        txtUserName.setOnMouseClicked(capsLockMouseEvent);
        txtPass.setOnMouseClicked(capsLockMouseEvent);


        EventHandler<javafx.scene.input.KeyEvent> capsLockKeyEvent = new EventHandler<javafx.scene.input.KeyEvent>() {
            @Override
            public void handle(javafx.scene.input.KeyEvent event) {
                if (event.getCode() == KeyCode.CAPS) {
                    capsLockIsOn = !capsLockIsOn;
                    lblCapsLock.setVisible(capsLockIsOn);
                }
            }
        };
        //Kullanıcı adı ve şifre için aynı EventHandler
        txtUserName.setOnKeyReleased(capsLockKeyEvent);
        txtPass.setOnKeyReleased(capsLockKeyEvent);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(txtUserName, txtPass, lblCapsLock);

        stage = new Stage();
        stage.setScene(new Scene(vBox));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
