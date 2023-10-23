package com.sao.postit.util.theme;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;

/**
 * @author saozd
 * @project com.sao.postit.util.theme courseexample
 * 8.06.2023 Haz 2023
 */
public final class ThemeEditor {

    private ThemeEditor() {
    }

    public static FlatLaf getTheme(ThemeFlatLaf theme) {
        switch (theme) {
            case DARK:
                return new FlatDarkLaf();
            case DRACULA:
                return new FlatDarculaLaf();
            default:
                return new FlatLightLaf();
        }
    }
}
