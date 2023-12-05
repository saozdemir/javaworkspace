package com.sao.swingandfx.swingfxusage;

import javax.swing.*;
import java.awt.*;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.swingandfx.swingfxusage
 * @date 01.Ara.2023
 * <p>
 * @description:
 */
public class SplashScreen extends JFrame {
    private JPanel pnlCommon = new JPanel(new BorderLayout());

    public SplashScreen() throws HeadlessException {
        init();
    }

    private void init() {
        this.setTitle("Splash Screen");
        this.getContentPane().add(BorderLayout.CENTER, pnlCommon);
        this.setSize(400, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}
