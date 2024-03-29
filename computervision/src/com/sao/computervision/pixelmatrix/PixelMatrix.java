package com.sao.computervision.pixelmatrix;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;

import java.awt.*;
import java.net.URL;

/**
 * @author Seyit Ahmet ÖZDEMİR
 * @project com.sao.computervision.pixelmatrix javaworkspace
 * @date 19.10.2023 Eki 2023
 * <p>
 * @description: 100x100 px çözünürlüğe sahip görüntünün OpenCV kütüphanesi ile RGB matrisini yazdıran uygulama.
 * @gitRepo: {https://github.com/saozdemir/javaworkspace/tree/master/computervision}
 */
public class PixelMatrix {
    public static void main(String[] args) {
        System.out.println("--- Bilgisayarlı Görü ---");
        loadOpenCvLibrary();
        process();
    }

    private static void loadOpenCvLibrary() {
        try {
            System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
            System.out.println("Open CV kütüphanesi yüklendi.");
        } catch (Exception e) {
            System.out.println("Open CV kütüphanesi yüklenemedi. Hata: " + e.getMessage());
        }
    }

    private static void process() {
        //String imagePath = "C:\\Users\\xsaozdemir\\IdeaProjects\\javaworkspace\\computervision\\resources\\images\\100x100_color.png";
        //String imagePath = PixelMatrix.class.getResource("/images/100x100_color.png").getPath();
        URL imageUrl = PixelMatrix.class.getResource("/images/100x100_color.png");
        String imagePath = imageUrl.getPath().substring(1);
        Mat image = Imgcodecs.imread(imagePath);
        int rows = image.rows();
        int columns = image.cols();
        System.out.println("Resim Boyutu: " + rows + "x" + columns);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                double[] pixel = image.get(i, j);
                System.out.println("Pixel (" + i + ", " + j + "): " + "[" + pixel[2] + ", " + pixel[1] + ", " + pixel[0] + "]");//pixel[0]:B, pixel[1]:G, pixel[2]:R,
            }
        }
        showImage(image);
    }

    private static void showImage(Mat image) {
        HighGui.imshow("Image", image);
        HighGui.resizeWindow("Image", 200, 200);
        HighGui.waitKey();
        HighGui.destroyAllWindows();
    }
}
