package com.sao.postit.app;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.sao.postit.util.theme.ThemeEditor;
import com.sao.postit.util.theme.ThemeFlatLaf;
import com.sao.postit.view.password.FrmPassword;

import javax.swing.*;

/**
 * @author saozd
 * @project com.sao.postit.app courseexample
 * 6.06.2023 Haz 2023
 */
public class PortItGUIApp {
    public static void main(String[] args) {
        try {
            //UIManager.setLookAndFeel(new FlatMacLightLaf());//m
            UIManager.setLookAndFeel(ThemeEditor.getTheme(ThemeFlatLaf.DARK));
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmPassword();
            }
        });
    }
}
