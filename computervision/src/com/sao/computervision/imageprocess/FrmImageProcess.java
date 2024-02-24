package com.sao.computervision.imageprocess;

import javax.swing.*;
import java.awt.*;

/**
 * @author saozd
 * @project com.sao.computervision.imageprocess javaworkspace
 * @date 26.10.2023 Eki 2023
 * <p>
 * @description:
 */
public class FrmImageProcess extends JFrame {
    private PnlImageProcess pnlCommon = new PnlImageProcess();
    private CtrImageProcess controller;

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
    public FrmImageProcess() throws HeadlessException {
        init();
        initController();
    }

    private void init() {
        this.setLayout(new BorderLayout());
        this.setTitle("Image Process");
        this.add(pnlCommon);
        this.setMinimumSize(new Dimension(500, 500));
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void initController() {
        controller = new CtrImageProcess(this);
    }


    public JTextField getTxtPath() {
        return pnlCommon.getTxtPath();
    }

    public JButton getBtnOpenImage() {
        return pnlCommon.getBtnOpenImage();
    }

    public JPanel getPnlImage() {
        return pnlCommon.getPnlImage();
    }

    public JLabel getLblNormalPicture() {
        return pnlCommon.getLblNormalPicture();
    }

    public JLabel getLblProcessedPicture() {
        return pnlCommon.getLblProcessedPicture();
    }

    public JButton getBtnInvert (){
        return pnlCommon.getBtnInvert();
    }
}
