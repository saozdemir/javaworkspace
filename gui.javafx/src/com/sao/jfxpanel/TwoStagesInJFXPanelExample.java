package com.sao.jfxpanel;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.jfxpanel
 * @date 30.Kas.2023
 * <p>
 * @description:
 */
import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TwoStagesInJFXPanelExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Two Stages in JFXPanel Example");
            frame.setSize(600, 400);
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
        StackPane stackPane = new StackPane();
        Scene scene1 = new Scene(stackPane, 300, 200);
        Stage stage1 = new Stage();
        stage1.setScene(scene1);

        Button button1 = new Button("Scene 1");
        button1.setOnAction(e -> {
            JOptionPane.showMessageDialog(null, "Button in Scene 1 clicked!");
        });

        stackPane.getChildren().add(button1);

        Scene scene2 = new Scene(new Button("Scene 2"), 300, 200);
        Stage stage2 = new Stage();
        stage2.setScene(scene2);

        JButton switchStageButton = new JButton("Switch Stage");
        switchStageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // İki stage arasında geçiş yap
                if (stage1.isShowing()) {
                    stage1.hide();
                    stage2.show();
                } else {
                    stage2.hide();
                    stage1.show();
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(switchStageButton);

        jfxPanel.setScene(scene1);
        jfxPanel.setLayout(new BorderLayout());
        jfxPanel.add(buttonPanel, BorderLayout.SOUTH);

        stage1.show();
    }
}

