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
public class PnlImageProcess extends JPanel {
    private JTextField txtPath = new JTextField(30);
    private JButton btnOpenImage = new JButton("Resim Seç");
    private JPanel pnlTop = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pnlImage = new JPanel(new GridLayout(1, 2));
    private JLabel lblNormalPicture = new JLabel();
    private JLabel lblProcessedPicture = new JLabel();

    private JButton btnInvert = new JButton();

    /**
     * Creates a new <code>JPanel</code> with a double buffer
     * and a flow layout.
     */
    public PnlImageProcess() {
        init();
    }

    private void init() {
        this.setLayout(new BorderLayout());
        txtPath.setEditable(false);
        pnlTop.add(txtPath);
        pnlTop.add(btnOpenImage);

        pnlImage.add(lblNormalPicture);
        pnlImage.add(lblProcessedPicture);

        this.add(pnlTop, BorderLayout.PAGE_START);
        this.add(pnlImage, BorderLayout.CENTER);
    }

    public JTextField getTxtPath() {
        return txtPath;
    }

    public JButton getBtnOpenImage() {
        return btnOpenImage;
    }

    public JPanel getPnlImage() {
        return pnlImage;
    }

    public JLabel getLblNormalPicture() {
        return lblNormalPicture;
    }

    public JLabel getLblProcessedPicture() {
        return lblProcessedPicture;
    }

    public JButton getBtnInvert() {
        return btnInvert;
    }
}
