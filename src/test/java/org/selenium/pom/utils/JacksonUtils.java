package org.selenium.pom.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileReader;
import java.io.IOException;

public class JacksonUtils {

    public static <T> T deserializeJson(String filePath, Class<T> T) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new FileReader(filePath), T);
    }
}
