package org.selenium;

import org.selenium.pom.base.BaseTest;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTestCase extends BaseTest {
    @Test
    public void guestCheckOutUsingDirectBankTransfer(){
        driver.get("https://askomdch.com/");
        HomePage homePage = new HomePage(driver);
        StorePage storePage = homePage.clickStoreMenuLink();
        storePage.enterTextInSearchInputField("Blue");
        storePage.clickSearchBtn();
        Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”");
        storePage.clickAddToCartBtn();
    }
}
