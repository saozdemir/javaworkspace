package com.sao.swingandfx.swingfxusage;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.swingandfx.swingfxusage
 * @date 01.Ara.2023
 * <p>
 * @description:
 */
public class App {
    public static void main(String[] args) throws InterruptedException, InvocationTargetException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                SplashScreen splashScreen = new SplashScreen();
                new JFXPanel();//Mock instance
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        new LoginScreen(splashScreen);
                    }
                });
            }
        };
        //UIUtilities();
        if(SwingUtilities.isEventDispatchThread()){
            runnable.run();
        }else{
            SwingUtilities.invokeAndWait(runnable);
        }
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new FrmSwing();
//                //Test-1
////                new JFXPanel();//Mock instance
////                Platform.runLater(new Runnable() {
////                    @Override
////                    public void run() {
////                        new FrmJFX();
////                    }
////                });
//                //Test-2
////                AppFX.main(args);
//                //Test-3
////                new JFXPanel();//Mock instance
////                Platform.runLater(new Runnable() {
////                    @Override
////                    public void run() {
////                        new StgFX();
////                    }
////                });
//            }
//        });
    }
}
