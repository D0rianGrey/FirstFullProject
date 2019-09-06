package com.w2a.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import javax.print.attribute.standard.PrinterMessageFromOperator;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    /*
    Webdriver
    Properties
    Logs
    ExtentReports
    DB
    Excel
    Mail
    ReportNG, ExtentReports
    Jenkins
    
     */


    public static WebDriver driver;
    public Properties config = new Properties();
    public Properties OR = new Properties();
    public static FileInputStream fis;


    @BeforeSuite
    public void setUp() throws IOException {
        if (driver == null) {
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(System.getProperty("user.dir") + "/resources/properties/Config.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            config.load(fis);
            try {
                fis = new FileInputStream(System.getProperty("user.dir") + "/resources/properties/OR.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            OR.load(fis);
        }

        if (config.getProperty("browser").equals("firefox")) {
            //System.getProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/resources/executables/geckodriver.exe");
            driver = new FirefoxDriver();

        } else if (config.getProperty("browser").equals("chrome")) {
            //System.getProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/resources/executables/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (config.getProperty("browser").equals("safari")) {
            driver = new SafariDriver();
        }
        driver.get(config.getProperty("testsiteurl"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);

    }


    @AfterSuite
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}
