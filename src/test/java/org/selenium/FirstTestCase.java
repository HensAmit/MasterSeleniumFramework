package org.selenium;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.BillingAddress;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.CheckOutPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.selenium.pom.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;

public class FirstTestCase extends BaseTest {
    @Test
    public void guestCheckOutUsingDirectBankTransfer() throws InterruptedException, IOException {
        HomePage homePage = new HomePage(driver).loadURL();
        StorePage storePage = homePage.navigateToStoreUsingMenu();
        Thread.sleep(10000);

        storePage.enterTextInSearchInputField("Blue");
        storePage.clickSearchBtn();
        Thread.sleep(5000);
        Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”");
        storePage.clickAddToCartBtn("Blue Shoes");
        Thread.sleep(10000);

        CartPage cartPage = storePage.clickViewCartLink();
        Assert.assertEquals(cartPage.getProductName(), "Blue Shoes");
        CheckOutPage checkOutPage = cartPage.checkOut();

        BillingAddress billingAddress = JacksonUtils.deserializeJson("src\\test\\resources\\myBillingAddress.json", BillingAddress.class);
        checkOutPage
                .setBillingAddress(billingAddress)
                .placeOrder();
        Thread.sleep(15000);
        Assert.assertEquals(checkOutPage.getSuccessNotice(), "Thank you. Your order has been received.");
    }

    @Test
    public void logInAndCheckOutUsingDirectBankTransfer() throws InterruptedException {
        HomePage homePage = new HomePage(driver).loadURL();
        StorePage storePage = homePage.navigateToStoreUsingMenu();
        Thread.sleep(10000);

        storePage.enterTextInSearchInputField("Blue");
        storePage.clickSearchBtn();
        Thread.sleep(5000);
        Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”");
        storePage.clickAddToCartBtn("Blue Shoes");
        Thread.sleep(5000);

        CartPage cartPage = storePage.clickViewCartLink();
        Assert.assertEquals(cartPage.getProductName(), "Blue Shoes");
        CheckOutPage checkOutPage = cartPage.checkOut();
        checkOutPage.clickHereToLoginLink();
        Thread.sleep(3000);

        checkOutPage
                .login("hens1", "demopassword")
                .enterFirstName("Paul")
                .enterLastName("Adams")
                .enterAddressLineOne("NY City")
                .enterCity("NY")
                .enterZipCode("45678")
                .enterEmail("paul@ishere.com")
                .placeOrder();
        Thread.sleep(10000);
        Assert.assertEquals(checkOutPage.getSuccessNotice(), "Thank you. Your order has been received.");
    }
}
