package com.w2a.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import resources.utilities.ExcelReader;

public class TestBase {

    /*
    Webdriver -done
    Properties - done
    Logs -
    ExtentReports
    DB
    Excel
    Mail
    ReportNG, ExtentReports
    Jenkins
    etd
     */


    public static WebDriver driver;
    public Properties config = new Properties();
    public Properties OR = new Properties();
    public static FileInputStream fis;
    public static Logger log = Logger.getLogger("devpinoyLogger");
    public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\java\\resources\\excel\\testdata.xlsx");
    public static WebDriverWait wait;


    @BeforeTest
    public void setUp() {




            try {
                fis = new FileInputStream(
                        System.getProperty("user.dir") + "\\src\\test\\java\\resources\\properties\\Config.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                config.load(fis);
                log.debug("Config file loaded !!!");
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                fis = new FileInputStream(
                        System.getProperty("user.dir") + "\\src\\test\\java\\resources\\properties\\OR.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                OR.load(fis);
                log.debug("OR file loaded !!!");
            } catch (IOException e) {
                e.printStackTrace();
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
            wait = new WebDriverWait(driver,5);

        }




    public boolean isElementPresent(By by) {
        try {

            driver.findElement(by);
            return true;

        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @AfterTest
    public void tearDown() {

            driver.close();

        log.debug("Test execution completed !!!!");
    }


}