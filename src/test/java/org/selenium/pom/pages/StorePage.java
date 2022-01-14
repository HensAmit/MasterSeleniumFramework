package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;

public class StorePage extends BasePage {
    public StorePage(WebDriver driver) {
        super(driver);
    }

    private final By searchInputField = By.cssSelector("input[class='search-field']");
    private final By searchBtn = By.cssSelector("button[value='Search']");
    private final By title = By.cssSelector(".woocommerce-products-header__title.page-title");

    public void enterTextInSearchInputField(String text){
        driver.findElement(searchInputField).sendKeys(text);
    }

    public void clickSearchBtn(){
        driver.findElement(searchBtn).click();
    }

    public String getTitle(){
        return driver.findElement(title).getText();
    }

    private By getAddToCartBtn(String productName){
        return By.cssSelector("a[aria-label='Add “"+productName+"” to your cart']");
    }

    public void clickAddToCartBtn(String productName){
        By addToCartBtn = getAddToCartBtn(productName);
        driver.findElement(addToCartBtn).click();
    }
}
