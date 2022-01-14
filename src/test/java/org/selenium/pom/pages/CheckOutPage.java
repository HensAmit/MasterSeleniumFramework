package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;

public class CheckOutPage extends BasePage {
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    private final By firstNameFld = By.cssSelector("#billing_first_name");
    private final By lastNameFld = By.cssSelector("#billing_last_name");
    private final By countryDropdown = By.cssSelector("#select2-billing_country-container");
    private final By addressLineOneFld = By.cssSelector("#billing_address_1");
    private final By billingCityFld = By.cssSelector("#billing_city");
    private final By state = By.cssSelector("#select2-billing_state-container");
    private final By billingZipCodeFld = By.cssSelector("#billing_postcode");
    private final By billingEmailFld = By.cssSelector("#billing_email");
    private final By placeOrderBtn = By.cssSelector("#place_order");
    private final By successNotice = By.cssSelector(".woocommerce-notice");

    public CheckOutPage enterFirstName(String firstName){
        driver.findElement(firstNameFld).sendKeys(firstName);
        return this;
    }

    public CheckOutPage enterLastName(String lastName){
        driver.findElement(lastNameFld).sendKeys(lastName);
        return this;
    }

    public CheckOutPage enterAddressLineOne(String addressLineOne){
        driver.findElement(addressLineOneFld).sendKeys(addressLineOne);
        return this;
    }

    public CheckOutPage enterCity(String city){
        driver.findElement(billingCityFld).sendKeys(city);
        return this;
    }

    public CheckOutPage enterZipCode(String zipCode){
        driver.findElement(billingZipCodeFld).sendKeys(zipCode);
        return this;
    }

    public CheckOutPage enterEmail(String email){
        driver.findElement(billingEmailFld).sendKeys(email);
        return this;
    }

    public CheckOutPage clickPLaceOrderBtn(){
        driver.findElement(placeOrderBtn).click();
        return this;
    }

    public String getSuccessNotice(){
        return driver.findElement(successNotice).getText();
    }
}
