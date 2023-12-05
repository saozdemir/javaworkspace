package com.sao.swingandfx.swingfxusage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import javax.swing.*;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.swingandfx.swingfxusage
 * @date 01.Ara.2023
 * <p>
 * @description:
 */
public class LoginScreen extends Stage {
    private Scene scene;
    private Label lblInfo = new Label("Info");
    private Button btnOpen = new Button("Open");
    private SplashScreen splashScreen;

    public LoginScreen(SplashScreen splashScreen) {
        this.splashScreen = splashScreen;
        init();
        action();
    }

    private void action() {
        btnOpen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Test-1
//                SwingUtilities.invokeLater(new Runnable() {
//                    @Override
//                    public void run() {
//                        new FrmJFX();
//                    }
//                });
                //Test-2
//                JFXPanel jfxPanel = new JFXPanel();
//                Platform.runLater(new Runnable() {
//                    @Override
//                    public void run() {
//                        new FrmJFX();
//                    }
//                });
                //Test-3
                new Client();
//                LoginScreen.super.hide();
                LoginScreen.super.hide();
                splashScreen.setVisible(false);
                splashScreen.dispose();
            }
        });
    }

    private void init() {
        StackPane pnCommon = new StackPane();
        pnCommon.getChildren().addAll(lblInfo, btnOpen);
        scene = new Scene(pnCommon, 300, 200);
        this.setTitle("Login Screen");
        this.setScene(scene); // Root panel ekleme
        this.setWidth(400);
        this.setHeight(300);
        this.show();
        this.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                close();
            }
        });
    }
}
