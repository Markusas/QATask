package com.amazone.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestDataReader {
    static Properties properties;

    public static Properties getTestData() throws IOException {

        if (properties == null) {
            InputStream stream = TestDataReader.class.getResourceAsStream("/testdata.properties");
            properties = new Properties();
            properties.load(stream);
        }

        return properties;
    }

    public static String getUrl() throws IOException {
        return getTestData().getProperty("baseUrl");
    }
    public static String getNodeUrl() throws IOException {
        return getTestData().getProperty("nodeUrl");
    }

    public static String getEmail() throws IOException {
        return getTestData().getProperty("email");
    }

    public static String getPassword() throws IOException {
        return getTestData().getProperty("password");
    }

    public static String getToyName() throws IOException {
        return getTestData().getProperty("toyName");
    }

    public static String getBrowser() throws IOException {
        return getTestData().getProperty("browser");
    }

    public static String getToysAmount() throws IOException {
        return getTestData().getProperty("toysCount");
    }

    public static String getTime() throws IOException {
        return getTestData().getProperty("defaultTimeout");
    }
}
