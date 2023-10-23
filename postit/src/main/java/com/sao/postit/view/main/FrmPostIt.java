package com.sao.postit.view.main;

import com.sao.postit.controller.CtrPostIt;
import com.sao.postit.util.bundle.BundleReader;
import com.sao.postit.view.main.toolbar.TbrPostIt;

import javax.swing.*;
import java.awt.*;

/**
 * @author saozd
 * @project com.sao.postit.view.main courseexample
 * 4.06.2023 Haz 2023
 */
public class FrmPostIt extends JFrame {
    private PnlPostIt pnlPostIt = new PnlPostIt();
    private CtrPostIt controller;

    private TbrPostIt toolBar = new TbrPostIt();

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
    public FrmPostIt() throws HeadlessException {
        init();
        initController();
    }

    private void init() {
        this.setLayout(new BorderLayout());
        this.setTitle(BundleReader.getString("PST.main.title"));
        this.add(toolBar, BorderLayout.PAGE_START);
        this.add(pnlPostIt, BorderLayout.CENTER);
        this.setMinimumSize(new Dimension(500, 450));
        this.setSize(500, 450);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }


    private void initController() {
        controller = new CtrPostIt(this);
    }

    public PnlPostIt getPnlPostIt() {
        return pnlPostIt;
    }

    public CtrPostIt getController() {
        return controller;
    }

    public TbrPostIt getToolBar() {
        return toolBar;
    }
}
