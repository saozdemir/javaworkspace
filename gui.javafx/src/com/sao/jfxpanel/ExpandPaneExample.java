package com.sao.jfxpanel;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.jfxpanel
 * @date 30.Kas.2023
 * <p>
 * @description:
 */
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExpandPaneExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Expand Panel Example");
            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JFXPanel jfxPanel = new JFXPanel();
            frame.add(jfxPanel, BorderLayout.CENTER);

            Platform.runLater(() -> {
                initJavaFX(jfxPanel);
            });

            frame.setVisible(true);
        });
    }

    private static void initJavaFX(JFXPanel jfxPanel) {
        VBox vBox = new VBox(10); // 10 piksel boşluk ile dikey bir VBox oluştur
        Scene scene = new Scene(vBox, 300, 200);
        scene.getStylesheets().add(ExpandPaneExample.class.getResource("styles.css").toExternalForm());
        vBox.getStyleClass().add("vbox-background");
        Button expandButton = new Button("Expand");
        expandButton.setOnAction(e -> {
            // VBox'ın boyutunu artır
            vBox.setPrefHeight(vBox.getPrefHeight() + 50); // Örneğin, her tıklandığında 50 piksel artırabilirsiniz
        });

        vBox.getChildren().add(expandButton);

        jfxPanel.setScene(scene);
    }
}

