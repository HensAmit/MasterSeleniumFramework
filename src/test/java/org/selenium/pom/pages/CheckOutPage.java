package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.objects.BillingAddress;

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
    private final By clickHereToLoginLink = By.className("showlogin");
    private final By usernameFld = By.id("username");
    private final By passwordFld = By.id("password");
    private final By loginBtn = By.name("login");

    public CheckOutPage enterFirstName(String firstName){
        driver.findElement(firstNameFld).clear();
        driver.findElement(firstNameFld).sendKeys(firstName);
        return this;
    }

    public CheckOutPage enterLastName(String lastName){
        driver.findElement(lastNameFld).clear();
        driver.findElement(lastNameFld).sendKeys(lastName);
        return this;
    }

    public CheckOutPage enterAddressLineOne(String addressLineOne){
        driver.findElement(addressLineOneFld).clear();
        driver.findElement(addressLineOneFld).sendKeys(addressLineOne);
        return this;
    }

    public CheckOutPage enterCity(String city){
        driver.findElement(billingCityFld).clear();
        driver.findElement(billingCityFld).sendKeys(city);
        return this;
    }

    public CheckOutPage enterZipCode(String zipCode){
        driver.findElement(billingZipCodeFld).clear();
        driver.findElement(billingZipCodeFld).sendKeys(zipCode);
        return this;
    }

    public CheckOutPage enterEmail(String email){
        driver.findElement(billingEmailFld).clear();
        driver.findElement(billingEmailFld).sendKeys(email);
        return this;
    }

    public CheckOutPage setBillingAddress(BillingAddress billingAddress){
        return enterFirstName(billingAddress.getFirstName())
                .enterLastName(billingAddress.getLastName())
                .enterAddressLineOne(billingAddress.getAddressLineOne())
                .enterCity(billingAddress.getCity())
                .enterZipCode(billingAddress.getZipCode())
                .enterEmail(billingAddress.getEmail());
    }

    public CheckOutPage placeOrder(){
        driver.findElement(placeOrderBtn).click();
        return this;
    }

    public String getSuccessNotice(){
        return driver.findElement(successNotice).getText();
    }

    public CheckOutPage clickHereToLoginLink(){
        driver.findElement(clickHereToLoginLink).click();
        return this;
    }

    public CheckOutPage enterUsername(String username){
        driver.findElement(usernameFld).sendKeys(username);
        return this;
    }

    public CheckOutPage enterPassword(String password){
        driver.findElement(passwordFld).sendKeys(password);
        return this;
    }

    public CheckOutPage clickLoginBtn(){
        driver.findElement(loginBtn).click();
        return this;
    }

    public CheckOutPage login(String username, String password){
        return enterUsername(username).enterPassword(password).clickLoginBtn();
    }
}
