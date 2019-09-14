package com.w2a.testcases;

import com.w2a.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import resources.utilities.TestUtil;

public class AddCustomerTest extends TestBase {

    @Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
    public void addCustomerTest(String firstName, String lastName, String postCode, String alertText) throws InterruptedException {

        click("bmlBtn_CSS");
        click("addCustBtn_CSS");
        type("firstname_CSS", firstName);
        type("lastname_XPATH", lastName);
        type("postcode_CSS", postCode);
        click("addbtn_CSS");

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertTrue(alert.getText().contains(alertText));

        alert.accept();

        Assert.fail("Customer not added successfully");


    }



}
