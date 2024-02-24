package com.sao.stagefactory;

import javafx.application.Application;

/**
 * @author saozd
 * @project com.sao.stagefactory javaworkspace
 * @date 23 Kas 2023
 * <p>
 * @description:
 */
public class BaseLoader {
    public void startApplication(String[] args){
        StageFactoryExample.main(args);
    }


    public static void main(String[] args) {
        BaseLoader loader = new BaseLoader();
        loader.startApplication(args);
    }
}
