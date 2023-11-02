package com.sao.imageview;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.net.URL;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.imageview
 * @date 02.Kas.2023
 * <p>
 * @description:
 */
public class StgImageView extends Stage {
    public StgImageView() {
        init();
    }

    private void init() {
        // URL'den resmi yükle
        //Image image = new Image("/images/accept.png");
        // SSL sertifikasını doğrulamamak için
        System.setProperty("javax.net.ssl.trustStoreType", "WINDOWS-ROOT");
        System.setProperty("javax.net.ssl.trustStore", "PATH_TO_TRUSTSTORE_FILE");
        Image image = new Image("https://static.hvkk.tsk.tr/Images/news/9476_Default.png");

        // ImageView oluştur ve içeriği ayarla
        ImageView imageView = new ImageView(image);

        // Bir StackPane'e ekleyerek görüntüle
        StackPane root = new StackPane();
        root.getChildren().add(imageView);

        Scene scene = new Scene(root, 400, 400);
        this.setScene(scene);
        this.show();
    }
}
