package org.selenium.pom.utils;

import java.io.*;
import java.util.Properties;

public class PropertyUtils {
    public static Properties propertyLoader(String filePath){
        Properties properties = new Properties();
        FileReader reader;
        try {
            reader = new FileReader(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("PROPERTIES FILE NOT FOUND AT: " + filePath);
        }
        try {
            properties.load(reader);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("FAILED TO LOAD PROPERTIES FILE: " + filePath);
        }
        return properties;
    }
}
