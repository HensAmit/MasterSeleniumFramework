package org.selenium;

import org.selenium.pom.base.BaseTest;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.CheckOutPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTestCase extends BaseTest {
    @Test
    public void guestCheckOutUsingDirectBankTransfer() throws InterruptedException {
        driver.get("https://askomdch.com/");

        HomePage homePage = new HomePage(driver);
        StorePage storePage = homePage.navigateToStoreUsingMenu();

        storePage.enterTextInSearchInputField("Blue");
        storePage.clickSearchBtn();
        Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”");
        storePage.clickAddToCartBtn("Blue Shoes");
        Thread.sleep(5000);

        CartPage cartPage = storePage.clickViewCartLink();
        Assert.assertEquals(cartPage.getProductName(), "Blue Shoes");
        CheckOutPage checkOutPage = cartPage.checkOut();
        checkOutPage
                .enterFirstName("demo")
                .enterLastName("user")
                .enterAddressLineOne("line 1")
                .enterCity("NY")
                .enterZipCode("12334")
                .enterEmail("abc@gmail.com")
                .clickPLaceOrderBtn();
        Thread.sleep(15000);
        Assert.assertEquals(checkOutPage.getSuccessNotice(), "Thank you. Your order has been received.");
    }
}
