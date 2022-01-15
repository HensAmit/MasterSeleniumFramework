package org.selenium.pom.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.selenium.pom.objects.BillingAddress;

import java.io.FileReader;
import java.io.IOException;

public class JacksonUtils {

    public static BillingAddress deserializedJson(String filePath, BillingAddress billingAddress) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new FileReader(filePath), billingAddress.getClass());
    }
}
