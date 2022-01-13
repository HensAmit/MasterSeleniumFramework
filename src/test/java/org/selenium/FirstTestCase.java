package org.selenium;

import org.selenium.pom.base.BaseTest;
import org.testng.annotations.Test;

public class FirstTestCase extends BaseTest {
    @Test
    public void demoTest(){
        driver.get("https://askomdch.com/");
        driver.manage().window().maximize();
    }
}
