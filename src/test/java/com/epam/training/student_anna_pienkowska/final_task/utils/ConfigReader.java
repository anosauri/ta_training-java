package com.epam.training.student_anna_pienkowska.final_task.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("final_task/config.properties")) {

            if (input == null) {
                throw new RuntimeException("File not found");
            }

            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file");
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
