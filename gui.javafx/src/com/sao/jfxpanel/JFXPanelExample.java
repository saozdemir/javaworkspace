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
import javafx.scene.layout.StackPane;

import javax.swing.*;
import java.awt.*;

public class JFXPanelExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("JFXPanel Example");
            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // JFrame'i dekorasyonsuz yap
            frame.setUndecorated(true);

            // Close button'u gizle
            frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);

            // JFrame'i merkeze yerleştir
            frame.setLocationRelativeTo(null);

            // JFXPanel oluştur
            JFXPanel jfxPanel = new JFXPanel();
            frame.add(jfxPanel, BorderLayout.CENTER);

            // JavaFX içeriğini başlat
            Platform.runLater(() -> initJavaFX(jfxPanel));

            frame.setVisible(true);
        });
    }

    private static void initJavaFX(JFXPanel jfxPanel) {
        // JavaFX sahnesi ve bileşenleri oluştur
        StackPane stackPane = new StackPane();
        Scene scene = new Scene(stackPane, 300, 200);
        Button button = new Button("Click me!");
        button.setOnAction(e -> JOptionPane.showMessageDialog(null, "Button clicked!"));

        // StackPane'e JavaFX bileşenini ekle
        stackPane.getChildren().add(button);

        // JFXPanel'e JavaFX sahnesini ayarla
        jfxPanel.setScene(scene);
    }
}

