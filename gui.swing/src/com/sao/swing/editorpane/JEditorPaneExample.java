package com.sao.swing.editorpane;

import javax.swing.*;
import java.awt.*;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.swing.editorpane
 * @date 05.Ara.2023
 * <p>
 * @description:
 */
public class JEditorPaneExample {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("JEditorPane Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JEditorPane editorPane = new JEditorPane();
            editorPane.setContentType("text/html");
            editorPane.setText("<html><body><h1>Hello, JEditorPane!</h1></body></html>");

            JScrollPane scrollPane = new JScrollPane(editorPane);

            frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
            frame.setSize(400, 300);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
