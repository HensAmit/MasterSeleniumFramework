package org.selenium.pom.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void loadURL(String endPoint){
        driver.get("https://askomdch.com" + endPoint);
    }

    public void waitForOverlaysToDisappear(By overlay){
        List<WebElement> overlays = driver.findElements(overlay);
        if(overlays.size() > 0){
            wait.until(ExpectedConditions.invisibilityOfAllElements(overlays));
        }
        else {
            System.out.println("OVERLAYS NOT FOUND");
        }
    }
}
