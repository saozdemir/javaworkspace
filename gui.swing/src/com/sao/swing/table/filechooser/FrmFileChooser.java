package com.sao.swing.table.filechooser;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.swing.table.filechooser
 * @date 22.Kas.2023
 * <p>
 * @description:
 */
public class FrmFileChooser extends JFrame {
    private JPanel pnlCommon = new JPanel();
    private JButton btnChoose = new JButton("Resim Seç");
    private JLabel lblImage = new JLabel();
    private JFileChooser fileChooser = new JFileChooser();

    public FrmFileChooser() throws HeadlessException {
        init();
        actions();
    }

    private void actions() {
        btnChoose.addActionListener(e -> {
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
                lblImage.setIcon(imageIcon);
            }
        });
    }

    private void init() {
        fileChooser.setFileFilter(new FileNameExtensionFilter("Resim Dosyaları", "jpg", "jpeg", "png", "gif"));

        pnlCommon.add(btnChoose);
        pnlCommon.add(lblImage);

        this.getContentPane().add(BorderLayout.CENTER, pnlCommon);
        this.setSize(400, 300);
        this.setVisible(true);
    }
}
