package com.sao.postit.view.password;

import com.sao.postit.controller.CtrPassword;
import com.sao.postit.util.bundle.BundleReader;

import javax.swing.*;
import java.awt.*;

/**
 * @author saozd
 * @project com.sao.postit.view.password courseexample
 * 4.06.2023 Haz 2023
 */
public class FrmPassword extends JFrame {
    private PnlPassword pnlPassword = new PnlPassword();
    private CtrPassword controller;

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

    public FrmPassword() throws HeadlessException {
        init();
        initController();
    }

    private void init() {
        this.setLayout(new BorderLayout());
        this.setTitle(BundleReader.getString("PST.enter.title"));
        this.add(pnlPassword);
        this.setMinimumSize(new Dimension(250, 200));
        this.setSize(250, 200);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }


    private void initController() {
        this.controller = new CtrPassword(this);
    }

    public PnlPassword getPnlPassword() {
        return pnlPassword;
    }

    public CtrPassword getController() {
        return controller;
    }
}
