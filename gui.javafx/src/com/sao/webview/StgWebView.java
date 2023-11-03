package com.sao.webview;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.imageview
 * @date 02.Kas.2023
 * <p>
 * @description:
 */
public class StgWebView extends Stage {
    public StgWebView() {
        init();
    }

    private void init() {
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();

        System.setProperty("javax.net.ssl.trustStoreType", "WINDOWS-ROOT");
        System.setProperty("javax.net.ssl.trustStore", "PATH_TO_TRUSTSTORE_FILE");
        // Gösterilecek web sayfasının URL'sini belirtin
        webEngine.load("https://www.haberler.com/dunya/hizbullah-koordineli-bir-sekilde-lubnan-16495606-haberi/");

        // Bir StackPane'e ekleyerek görüntüle
        StackPane root = new StackPane();
        root.getChildren().add(webView);

        Scene scene = new Scene(root, 400, 400);
        this.setScene(scene);
        this.show();
    }
}
