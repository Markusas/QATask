package com.amazone.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestDataReader {
    public static Properties getTestData() throws IOException {
        FileInputStream fp = new FileInputStream("src\\main\\resources\\testdate.properties");
        Properties properties = new Properties();
        properties.load(fp);
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
