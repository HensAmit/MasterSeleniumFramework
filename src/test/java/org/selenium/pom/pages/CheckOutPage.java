package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.objects.BillingAddress;
import org.selenium.pom.objects.User;

public class CheckOutPage extends BasePage {
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    private final By firstNameFld = By.cssSelector("#billing_first_name");
    private final By lastNameFld = By.cssSelector("#billing_last_name");
    private final By countryDropdown = By.id("billing_country");
    private final By alternateCountryDropdown = By.id("select2-billing_country-container");
    private final By addressLineOneFld = By.cssSelector("#billing_address_1");
    private final By billingCityFld = By.id("billing_city");
    private final By stateDropdown = By.id("billing_state");
    private final By alternateStateDropdown = By.id("select2-billing_state-container");
    private final By billingZipCodeFld = By.cssSelector("#billing_postcode");
    private final By billingEmailFld = By.cssSelector("#billing_email");
    private final By placeOrderBtn = By.cssSelector("#place_order");
    private final By successNotice = By.cssSelector(".woocommerce-notice");
    private final By clickHereToLoginLink = By.className("showlogin");
    private final By usernameFld = By.id("username");
    private final By passwordFld = By.id("password");
    private final By loginBtn = By.name("login");
    private final By overlay = By.cssSelector(".blockUI.blockOverlay");
    private final By directBankTransferRadioBtn = By.id("payment_method_bacs");

    public CheckOutPage enterFirstName(String firstName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameFld));
        driver.findElement(firstNameFld).clear();
        driver.findElement(firstNameFld).sendKeys(firstName);
        return this;
    }

    public CheckOutPage enterLastName(String lastName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameFld));
        driver.findElement(lastNameFld).clear();
        driver.findElement(lastNameFld).sendKeys(lastName);
        return this;
    }

    public CheckOutPage selectCountry(String countryName){
//        Select select = new Select(driver.findElement(countryDropdown));
//        select.selectByVisibleText(countryName);
        wait.until(ExpectedConditions.elementToBeClickable(alternateCountryDropdown)).click();
        WebElement countryElement = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//li[text()='"+countryName+"']"))));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", countryElement);
        countryElement.click();
        return this;
    }

    public CheckOutPage enterAddressLineOne(String addressLineOne){
        wait.until(ExpectedConditions.visibilityOfElementLocated(addressLineOneFld));
        driver.findElement(addressLineOneFld).clear();
        driver.findElement(addressLineOneFld).sendKeys(addressLineOne);
        return this;
    }

    public CheckOutPage enterCity(String city){
        wait.until(ExpectedConditions.elementToBeClickable(billingCityFld));
        driver.findElement(billingCityFld).clear();
        driver.findElement(billingCityFld).sendKeys(city);
        return this;
    }

    public CheckOutPage selectState(String stateName){
//        Select select = new Select(driver.findElement(stateDropdown));
//        select.selectByVisibleText(stateName);
        wait.until(ExpectedConditions.elementToBeClickable(alternateStateDropdown)).click();
        WebElement stateElement = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//li[text()='"+stateName+"']"))));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", stateElement);
        stateElement.click();
        return this;
    }

    public CheckOutPage enterZipCode(String zipCode){
        wait.until(ExpectedConditions.visibilityOfElementLocated(billingZipCodeFld));
        driver.findElement(billingZipCodeFld).clear();
        driver.findElement(billingZipCodeFld).sendKeys(zipCode);
        return this;
    }

    public CheckOutPage enterEmail(String email){
        wait.until(ExpectedConditions.visibilityOfElementLocated(billingEmailFld));
        driver.findElement(billingEmailFld).clear();
        driver.findElement(billingEmailFld).sendKeys(email);
        return this;
    }

    public CheckOutPage setBillingAddress(BillingAddress billingAddress){
        return enterFirstName(billingAddress.getFirstName())
                .enterLastName(billingAddress.getLastName())
                .selectCountry(billingAddress.getCountry())
                .enterAddressLineOne(billingAddress.getAddressLineOne())
                .enterCity(billingAddress.getCity())
                .selectState(billingAddress.getState())
                .enterZipCode(billingAddress.getZipCode())
                .enterEmail(billingAddress.getEmail());
    }

    public CheckOutPage placeOrder(){
        waitForOverlaysToDisappear(overlay);
        driver.findElement(placeOrderBtn).click();
        return this;
    }

    public String getSuccessNotice(){
        waitForOverlaysToDisappear(overlay);
        return driver.findElement(successNotice).getText();
    }

    public CheckOutPage clickHereToLoginLink(){
        wait.until(ExpectedConditions.elementToBeClickable(clickHereToLoginLink));
        driver.findElement(clickHereToLoginLink).click();
        return this;
    }

    public CheckOutPage enterUsername(String username){
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameFld));
        driver.findElement(usernameFld).sendKeys(username);
        return this;
    }

    public CheckOutPage enterPassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordFld));
        driver.findElement(passwordFld).sendKeys(password);
        return this;
    }

    public CheckOutPage clickLoginBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        driver.findElement(loginBtn).click();
        return this;
    }

    public CheckOutPage login(User user){
        return enterUsername(user.getUsername()).enterPassword(user.getPassword()).clickLoginBtn();
    }

    public CheckOutPage selectDirectBankTransfer(){
        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(directBankTransferRadioBtn));
        if(!e.isSelected()){
            e.click();
        }
        return this;
    }
}
