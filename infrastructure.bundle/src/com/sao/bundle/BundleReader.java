package com.sao.bundle;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * @author saozd
 * @project com.sao.bundle javaworkspace
 * @date 28.08.2023 Ağu 2023
 * <p>
 * @description:
 */
public class BundleReader {
    private static final URL PATH = BundleReader.class.getResource("/bundle/language.properties");

    private BundleReader() {
    }

    public static String getString(String key) {
        Properties properties = new Properties();
        InputStream inputStream = null;
        String value = key;

        try {
            inputStream = new FileInputStream(PATH.getPath());
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            properties.load(inputStreamReader);

            value = properties.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return value;
    }
}
