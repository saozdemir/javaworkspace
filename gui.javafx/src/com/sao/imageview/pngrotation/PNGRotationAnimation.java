package com.sao.imageview.pngrotation;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.imageview.pngrotation
 * @date 21.Ara.2023
 * <p>
 * @description:
 */

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.Scene;
import javafx.scene.chart.Axis;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.image.Image;

import java.awt.*;

public class PNGRotationAnimation extends Application {

    @Override
    public void start(Stage primaryStage) {
        // PNG dosyasını yükle
        Image image = new Image("/images/cancel.png");
        ImageView imageView = new ImageView(image);
        Button button = new Button("Stop");

        // İmajı bir pane'a yerleştir
        StackPane root = new StackPane();
        root.getChildren().addAll(button, imageView);

//        Rotate rotation = new Rotate(0,0,0,0, Rotate.Y_AXIS);
        // Döndürme animasyonu oluştur
        Thread thread = new Thread() {
            public void run() {
                RotateTransition rotateTransition = new RotateTransition(Duration.seconds(5), imageView);
                rotateTransition.setAxis(Rotate.Y_AXIS);
                rotateTransition.setByAngle(360); // 360 derece döndür
                rotateTransition.setCycleCount(RotateTransition.INDEFINITE); // Sonsuz döngü

                rotateTransition.play(); // Animasyonu başlat
            }
        };
        thread.setDaemon(true);
        thread.start();

//        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(5), imageView);
//        rotateTransition.setAxis(Rotate.Y_AXIS);
//        rotateTransition.setByAngle(360); // 360 derece döndür
//        rotateTransition.setCycleCount(RotateTransition.INDEFINITE); // Sonsuz döngü
//
//        rotateTransition.play(); // Animasyonu başlat

        // Sahneyi oluştur ve göster
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("PNG Rotation Animation");
        primaryStage.setScene(scene);
        primaryStage.show();

        button.setOnAction((e) -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
