package com.sao.computervision.imageprocess;

/**
 * @author saozd
 * @project com.sao.computervision.imageprocess javaworkspace
 * @date 26.10.2023 Eki 2023
 * <p>
 * @description:
 */
import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.core.CvType;
import org.opencv.imgproc.Imgproc;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

public class GörüntüIslemeUygulamasi {

    static {
        System.loadLibrary(org.opencv.core.Core.NATIVE_LIBRARY_NAME);
    }

    private JFrame frame;
    private JLabel orijinalLabel;
    private JLabel invertLabel;

    public GörüntüIslemeUygulamasi() {
        frame = new JFrame("Görüntü İşleme Uygulaması");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JButton yukleButton = new JButton("Resim Yükle");
        yukleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int secimSonucu = fileChooser.showOpenDialog(null);

                if (secimSonucu == JFileChooser.APPROVE_OPTION) {
                    File secilenDosya = fileChooser.getSelectedFile();

                    try {
                        Mat orijinalMat = Imgcodecs.imread(secilenDosya.getAbsolutePath());
                        Mat boyutlandirilmisMat = new Mat();
                        Imgproc.resize(orijinalMat, boyutlandirilmisMat, new Size(300, 300));

                        BufferedImage orijinalImage = matToBufferedImage(boyutlandirilmisMat);
                        //BufferedImage orijinalImage = convertMatToBufferedImage(boyutlandirilmisMat);
                        ImageIcon orijinalIcon = new ImageIcon(orijinalImage);
                        orijinalLabel.setIcon(orijinalIcon);

                        Mat invertMat = new Mat();
                        Core.bitwise_not(boyutlandirilmisMat, invertMat);

                        BufferedImage invertImage = matToBufferedImage(invertMat);
                        //BufferedImage invertImage = convertMatToBufferedImage(invertMat);
                        ImageIcon invertIcon = new ImageIcon(invertImage);
                        invertLabel.setIcon(invertIcon);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        orijinalLabel = new JLabel();
        invertLabel = new JLabel();

        frame.add(yukleButton);
        frame.add(orijinalLabel);
        frame.add(invertLabel);

        frame.pack();
        frame.setVisible(true);
    }

    public BufferedImage matToBufferedImage(Mat mat) {
        int type = BufferedImage.TYPE_BYTE_GRAY;
        if (mat.channels() > 1) {
            type = BufferedImage.TYPE_3BYTE_BGR;
        }
        int bufferSize = mat.channels() * mat.cols() * mat.rows();
        byte[] buffer = new byte[bufferSize];
        mat.get(0, 0, buffer);
        BufferedImage image = new BufferedImage(mat.cols(), mat.rows(), type);
        final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        System.arraycopy(buffer, 0, targetPixels, 0, buffer.length);
        return image;
    }

    public  BufferedImage convertMatToBufferedImage(Mat mat) throws IOException {
        MatOfByte mob = new MatOfByte();
        Imgcodecs.imencode(".jpg", mat, mob);
        byte[] byteArray = mob.toArray();
        ByteArrayInputStream bais = new ByteArrayInputStream(byteArray);
        return ImageIO.read(bais);
    }

    public static void main(String[] args) {
        new GörüntüIslemeUygulamasi();
    }
}
