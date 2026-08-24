package com.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private Properties prop;

    public ConfigReader() {

        try {
            FileInputStream fis = new FileInputStream(
                    "src/test/resources/config/config.properties");

            prop = new Properties();
            prop.load(fis);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getBrowser() {
        return prop.getProperty("browser");
    }

    public String getUrl() {
        return prop.getProperty("url");
    }
}