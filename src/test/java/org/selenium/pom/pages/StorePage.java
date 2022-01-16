package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

public class StorePage extends BasePage {
    public StorePage(WebDriver driver) {
        super(driver);
    }

    private final By searchInputField = By.cssSelector("input[class='search-field']");
    private final By searchBtn = By.cssSelector("button[value='Search']");
    private final By title = By.xpath("//h1[contains(text(),'Search results')]");
    private final By viewCartLink = By.cssSelector("a[title='View cart']");

    public void enterTextInSearchInputField(String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchInputField));
        driver.findElement(searchInputField).sendKeys(text);
    }

    public void clickSearchBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
        driver.findElement(searchBtn).click();
    }

    public String getTitle(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(title));
        return driver.findElement(title).getText();
    }

    private By getAddToCartBtn(String productName){
        return By.cssSelector("a[aria-label='Add “"+productName+"” to your cart']");
    }

    public void clickAddToCartBtn(String productName){
        By addToCartBtn = getAddToCartBtn(productName);
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
        driver.findElement(addToCartBtn).click();
    }

    public CartPage clickViewCartLink(){
        wait.until(ExpectedConditions.elementToBeClickable(viewCartLink));
        driver.findElement(viewCartLink).click();
        return new CartPage(driver);
    }
}
