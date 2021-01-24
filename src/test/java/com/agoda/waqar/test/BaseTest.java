package com.agoda.waqar.test;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;


public class BaseTest {

    protected WebDriver driver;
    private DesiredCapabilities dc;
    private String host;
    private String completeUrl;
    private ExtentHtmlReporter htmlReporter;
    private ExtentReports extent;
    private ExtentTest logger;


    public BaseTest() {

        this.htmlReporter = new ExtentHtmlReporter("extent.html");
        this.extent = new ExtentReports();
        extent.attachReporter(htmlReporter);


        if (System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
            dc = DesiredCapabilities.firefox();
        } else {
            dc = DesiredCapabilities.chrome();
        }

        if (System.getProperty("HUB_HOST") != null) {
            host = System.getProperty("HUB_HOST");
        } else {
            host = "localhost";
        }

        completeUrl = "http://" + host + ":4444/wd/hub";
    }

    @BeforeTest
    protected void start() throws MalformedURLException {

        logger=extent.createTest("PassTest");
       driver = new RemoteWebDriver(new URL(completeUrl), dc);
        logger.log(Status.PASS,"Test Case Pass");

    }

//    @BeforeSuite
//    protected void start() throws MalformedURLException {
//        System.setProperty("webdriver.chrome.driver", "C:\\Driver\\WebDriver\\chromedriver (2).exe");
//
//        driver = new ChromeDriver();
//    }

    @AfterTest
    protected void end() {
        driver.quit();
    }
}
