package org.selenium.pom.utils;

import org.selenium.pom.constants.EnvType;

import java.util.Properties;

public class ConfigLoader {
    private final Properties properties;
    private static ConfigLoader configLoader;

    private ConfigLoader(){
        String env = System.getProperty("env", EnvType.STAGE.toString());
        switch (EnvType.valueOf(env.toUpperCase())){
            case STAGE:
                properties = PropertyUtils.propertyLoader("src/test/resources/config.properties");
                break;
            case PRODUCTION:
                properties = PropertyUtils.propertyLoader("src/test/resources/prod_config.properties");
                break;
            default:
                throw new RuntimeException("INVALID ENV NAME: " + env);
        }
    }

    public static ConfigLoader getInstance(){
        if(configLoader == null){
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    public String getBaseUrl(){
        String baseUrl = properties.getProperty("baseUrl");
        if(baseUrl != null)
            return baseUrl;
        else
            throw new RuntimeException("Property baseUrl is not specified in the config.prop");
    }

    public String getUsername(){
        String username = properties.getProperty("username");
        if(username != null)
            return username;
        else
            throw new RuntimeException("Property username is not specified in the config.prop");
    }

    public String getPassword(){
        String password = properties.getProperty("password");
        if(password != null)
            return password;
        else
            throw new RuntimeException("Property password is not specified in the config.prop");
    }
}
