package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    private final By productName = By.cssSelector("td[class='product-name'] > a");
    private final By checkOutBtn = By.cssSelector(".checkout-button");

    public String getProductName(){
        return driver.findElement(productName).getText();
    }

    public CheckOutPage clickCheckOutBtn(){
        driver.findElement(checkOutBtn).click();
        return new CheckOutPage(driver);
    }
}
