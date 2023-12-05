package com.sao.swingandfx.swingfxusage;

import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

import javax.swing.*;
import java.awt.*;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.swingandfx.swingfxusage
 * @date 01.Ara.2023
 * <p>
 * @description:
 */
public class Client extends JFrame {
    private JFXPanel pnlJfx = new JFXPanel();
    private Label lblFx= new Label("JFX Panel");

    public Client() throws HeadlessException {
        init();
        initJFXPanel();
    }

    private void initJFXPanel() {
        StackPane pnStackPane = new StackPane();
        pnStackPane.getChildren().add(lblFx);
        Scene scene = new Scene(pnStackPane, 400, 400);
        pnlJfx.setScene(scene);

    }

    private void init() {
        this.setTitle("Client Screen");
        this.setLayout(new BorderLayout());
        this.add(pnlJfx,BorderLayout.CENTER);
        this.setSize(400, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
