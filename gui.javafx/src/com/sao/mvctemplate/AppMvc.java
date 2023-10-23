package com.sao.mvctemplate;

import com.sao.mvctemplate.view.StgMvcTemplate;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.mvctemplate
 * @date 23.Eki.2023
 * <p>
 * @description: Uygulamayı çalıştıran App sınıfı StgMvcTemplate() sınfını çağırarak uygulamayı başlatır
 */
public class AppMvc extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        new StgMvcTemplate();
    }
}
