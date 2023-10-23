package com.sao.postit.util.tsg;

import javax.swing.*;

/**
 * @author saozd
 * @project dummy.example.tsg courseexample
 * 31.07.2023 Tem 2023
 */
public class TsgApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmTsg();
            }
        });
    }
}
