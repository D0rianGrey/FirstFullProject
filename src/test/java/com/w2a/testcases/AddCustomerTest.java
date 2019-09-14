package com.w2a.testcases;

import com.w2a.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddCustomerTest extends TestBase {

    @Test(dataProvider = "getData")
    public void addCustomer(String firstName, String lastName, String postCode, String alertText) throws InterruptedException {

        driver.findElement(By.cssSelector(OR.getProperty("bmlBtn_CSS"))).click();
        driver.findElement(By.cssSelector(OR.getProperty("addCustBtn_CSS"))).click();
        driver.findElement(By.cssSelector(OR.getProperty("firstname_CSS"))).sendKeys(firstName);
        driver.findElement(By.xpath(OR.getProperty("lastname_XPATH"))).sendKeys(lastName);
        driver.findElement(By.cssSelector(OR.getProperty("postcode_CSS"))).sendKeys(postCode);
        driver.findElement(By.cssSelector(OR.getProperty("addbtn_CSS"))).click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertTrue(alert.getText().contains(alertText));
        Thread.sleep(3000);
        alert.accept();
        Thread.sleep(3000);


    }





    @DataProvider
    public Object[][] getData() {

        String sheetName = "AddCustomerTest";
        int rows = excel.getRowCount(sheetName);
        int cols = excel.getColumnCount(sheetName);

        Object[][] data = new Object[rows - 1][cols];

        for (int rowNum = 2; rowNum <= rows; rowNum++) { //2

            for (int colNum = 0; colNum < cols; colNum++) {

                //data [0][0]
                data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);

            }


        }

        return data;

    }

}
