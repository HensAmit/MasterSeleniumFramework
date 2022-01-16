package org.selenium;

import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.BillingAddress;
import org.selenium.pom.objects.Product;
import org.selenium.pom.objects.User;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.CheckOutPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.selenium.pom.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class FirstTestCase extends BaseTest {
    @Test
    public void guestCheckOutUsingDirectBankTransfer() throws IOException {
        HomePage homePage = new HomePage(driver).loadURL();
        StorePage storePage = homePage.navigateToStoreUsingMenu();

        storePage.enterTextInSearchInputField("Blue");
        storePage.clickSearchBtn();
        Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”");

        Product product = new Product(1215);
        storePage.clickAddToCartBtn(product.getName());

        CartPage cartPage = storePage.clickViewCartLink();
        Assert.assertEquals(cartPage.getProductName(), product.getName());
        CheckOutPage checkOutPage = cartPage.checkOut();

        BillingAddress billingAddress = JacksonUtils.deserializeJson("src\\test\\resources\\myBillingAddress.json", BillingAddress.class);
        checkOutPage
                .setBillingAddress(billingAddress)
                .selectDirectBankTransfer()
                .placeOrder();
        Assert.assertEquals(checkOutPage.getSuccessNotice(), "Thank you. Your order has been received.");
    }

    @Test
    public void logInAndCheckOutUsingDirectBankTransfer() throws InterruptedException, IOException {
        HomePage homePage = new HomePage(driver).loadURL();
        StorePage storePage = homePage.navigateToStoreUsingMenu();

        storePage.enterTextInSearchInputField("Blue");
        storePage.clickSearchBtn();
        Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”");

        Product product = new Product(1215);
        storePage.clickAddToCartBtn(product.getName());

        CartPage cartPage = storePage.clickViewCartLink();
        Assert.assertEquals(cartPage.getProductName(), product.getName());
        CheckOutPage checkOutPage = cartPage.checkOut();
        checkOutPage.clickHereToLoginLink();

        BillingAddress billingAddress = JacksonUtils.deserializeJson("src\\test\\resources\\myBillingAddress.json", BillingAddress.class);
        User user = new User("hens1", "demopassword");
        checkOutPage
                .login(user)
                .setBillingAddress(billingAddress)
                .selectDirectBankTransfer()
                .placeOrder();
        Assert.assertEquals(checkOutPage.getSuccessNotice(), "Thank you. Your order has been received.");
    }
}
