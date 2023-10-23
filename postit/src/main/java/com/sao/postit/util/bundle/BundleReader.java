package com.sao.postit.util.bundle;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * @author saozd
 * @project com.sao.postit.util.bundle courseexample
 * 6.06.2023 Haz 2023
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
