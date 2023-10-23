package com.sao.postit.util.tsg;

import javax.swing.*;
import java.awt.*;

/**
 * @author saozd
 * @project dummy.example.tsg courseexample
 * 31.07.2023 Tem 2023
 */
public class FrmTsg extends JFrame {
    TsgPanel tsgPanel = new TsgPanel(TsgConstants.GGAAAYYYY,10);
    /**
     * Constructs a new frame that is initially invisible.
     * <p>
     * This constructor sets the component's locale property to the value
     * returned by <code>JComponent.getDefaultLocale</code>.
     *
     * @throws HeadlessException if GraphicsEnvironment.isHeadless()
     *                           returns true.
     * @see GraphicsEnvironment#isHeadless
     * @see Component#setSize
     * @see Component#setVisible
     * @see JComponent#getDefaultLocale
     */
    public FrmTsg() throws HeadlessException {
        init();
    }

    private void init() {
        this.setLayout(new BorderLayout());
        this.setTitle("Title");
        this.add(tsgPanel, BorderLayout.PAGE_START);
        this.setMinimumSize(new Dimension(250, 200));
        this.setSize(250, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
