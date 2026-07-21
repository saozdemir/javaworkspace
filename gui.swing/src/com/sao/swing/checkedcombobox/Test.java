package com.sao.swing.checkedcombobox;

import com.sao.swing.dragdrop.FrmNews;

import javax.swing.*;

/**
 * @author saozdemir
 * @project javaworkspace
 * @date 21 Tem 2026
 * <p>
 * @description:
 */
public class Test {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmTest();
            }
        });
    }
}
