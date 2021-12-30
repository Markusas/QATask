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
}
