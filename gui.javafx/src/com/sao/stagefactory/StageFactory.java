package com.sao.stagefactory;

import javafx.application.Platform;

import java.util.function.Consumer;

/**
 * @author saozd
 * @project com.sao.stagefactory javaworkspace
 * @date 23 Kas 2023
 * <p>
 * @description:
 */
public class StageFactory {

    public static void createStage(Consumer<StgStage> stageConsumer) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                StgStage stage = new StgStage();
                stageConsumer.accept(stage);
            }
        });
    }
}
