package com.sao.computervision.imageprocess;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author saozd
 * @project com.sao.computervision.imageprocess javaworkspace
 * @date 26.10.2023 Eki 2023
 * <p>
 * @description:
 */
public class CtrImageProcess {
    private final FrmImageProcess frame;

    public CtrImageProcess(FrmImageProcess frame) {
        this.frame = frame;
        actions();
    }

    private void actions() {
        frame.getBtnOpenImage().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Resim Dosyaları", "bmp", "jpg", "png");
                fileChooser.setFileFilter(filter);
                File selectedFile = null;
                if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
                    selectedFile = fileChooser.getSelectedFile();
                    frame.getTxtPath().setText(selectedFile.getAbsolutePath());
                    loadImage(selectedFile);
                }
            }
        });

        frame.getBtnInvert().addActionListener((e) -> {
            new ImageProcessor().invertImage(frame.getLblNormalPicture().getIcon());
        });
    }

    /**
     * Resmi yükler
     *
     * @param selectedFile
     */
    private void loadImage(File selectedFile) {
        if (selectedFile != null) {
            try {
                BufferedImage imgLoad = ImageIO.read(selectedFile);
                ImageIcon icon = new ImageIcon(resizeImage(imgLoad));
                frame.getLblNormalPicture().setIcon(icon);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Seçilen resmi 300x300 px olacak şekilde boyutlandırır.
     *
     * @param imgLoad
     * @return
     */
    private BufferedImage resizeImage(BufferedImage imgLoad) {
        BufferedImage imgResized = new BufferedImage(300, 300, imgLoad.getType());
        Graphics2D graphics = imgResized.createGraphics();
        graphics.drawImage(imgLoad, 0, 0, 300, 300, null);
        graphics.dispose();
        return imgResized;
    }


}

class ImageProcessor {
    public ImageProcessor() {
    }

    public void invertImage(Icon image) {

    }
}
