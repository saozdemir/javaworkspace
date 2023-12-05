package com.sao.swing.table.filechooser;

import javax.swing.*;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.swing.table.filechooser
 * @date 22.Kas.2023
 * <p>
 * @description:
 */
public class FileChooserApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmFileChooser();
            }
        });
    }
}
