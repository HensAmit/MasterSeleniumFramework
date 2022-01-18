package org.selenium.pom.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

    public WebDriver initializeDriver(String browser){
        WebDriver driver;
        switch (browser.toLowerCase()){
            case "chrome" :
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox" :
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default :
                throw new IllegalArgumentException("INVALID BROWSER NAME: " + browser);
        }
        driver.manage().window().maximize();
        return driver;
    }
}
