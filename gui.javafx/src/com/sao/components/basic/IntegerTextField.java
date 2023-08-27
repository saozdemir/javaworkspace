package com.sao.components.basic;

import javafx.scene.control.TextField;

/**
 * @author saozd
 * @project com.sao.components.basic javaworkspace
 * @date 26.08.2023 Ağu 2023
 * <p>
 * @description:
 */
public class IntegerTextField extends TextField {
    private final int minValue;
    private final int maxValue;

    public IntegerTextField(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;

        this.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                setText(newValue.replaceAll("[^\\d]", ""));
            }

            validateValue();
        });
    }

    public int getIntegerValue() {
        validateValue();
        return Integer.parseInt(getText());
    }

    private void validateValue() {
        int currentValue = getText().isEmpty() ? 0 : Integer.parseInt(getText());
        if (currentValue < minValue) {
            setText(String.valueOf(minValue));
        } else if (currentValue > maxValue) {
            setText(String.valueOf(maxValue));
        }
    }
}
