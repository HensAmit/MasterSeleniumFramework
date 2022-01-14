package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final By storeMenuLink = By.cssSelector("[id='menu-item-1227']>a");

    public StorePage clickStoreMenuLink(){
        driver.findElement(storeMenuLink).click();
        return new StorePage(driver);
    }
}
