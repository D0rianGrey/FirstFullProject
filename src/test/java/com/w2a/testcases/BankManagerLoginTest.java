package com.w2a.testcases;

import com.w2a.base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class BankManagerLoginTest extends TestBase {

    @Test
    public void loginAsBankManager() throws InterruptedException, IOException {

        System.setProperty("org.uncommons.reportng.escape-output", "false");


        verifyEquals("abc", "xyz");
        Thread.sleep(3000);

        log.debug("Inside Login Test");
        click("bmlBtn_CSS");
        //driver.findElement(By.cssSelector(OR.getProperty("bmlBtn_CSS"))).click();

        Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("addCustBtn_CSS"))), "Login not successful");

        log.debug("Login successfully executed");

        Assert.fail("Login not succsessful");

    }
}
