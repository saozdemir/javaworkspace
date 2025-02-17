package com.sao.swing.slider;

import javax.swing.*;

/**
 * @author saozdemir
 * @project javaworkspace
 * @date 17 Şub 2025
 * <p>
 * @description:
 */
public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FrmSlider();
            }
        });
    }
}
