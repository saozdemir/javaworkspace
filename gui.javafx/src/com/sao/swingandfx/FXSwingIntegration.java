package com.sao.swingandfx;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.swingandfx
 * @date 15.Kas.2023
 * <p>
 * @description:
 */
import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;

public class FXSwingIntegration extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button("Swing Ekranını Aç");
        btn.setOnAction(e -> openSwingScreen());

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("JavaFX Ana Ekran");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void openSwingScreen() {
        JFrame frame = new JFrame("Swing Ekranı");
        frame.setSize(300, 200);

        // Swing bileşenlerini burada ekleyin
        JPanel panel = new JPanel();
        panel.add(new JLabel("Swing Ekranı"));

        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

