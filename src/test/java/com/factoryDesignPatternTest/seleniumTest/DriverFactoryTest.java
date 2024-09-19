package com.factoryDesignPatternTest.seleniumTest;

import com.factoryDesignPattern.seleniumFactoryDesign.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class DriverFactoryTest {

    protected WebDriver driver;


    @BeforeTest
    @Parameters("browser")
    public void setUp(String browser) {

        driver = DriverFactory.getDriver(browser);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();


    }

    @Test
    public void googleTitleTest() {
        driver.get("https://www.google.com");
        System.out.println(Thread.currentThread().getName());
        System.out.println("Google URL: " + driver.getCurrentUrl());

        Assert.assertEquals(driver.getTitle(), "Google");

    }

    @Test
    public void facebookTitleTest() {
        driver.get("https://www.facebook.com/");
        System.out.println(Thread.currentThread().getName());
        System.out.println("Google URL: " + driver.getCurrentUrl());

        Assert.assertEquals(driver.getTitle(), "Facebook – log in or sign up");


    }

    @Test
    public void orangeHRMTitleTest() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        System.out.println(Thread.currentThread().getName());
        System.out.println("Google URL: " + driver.getCurrentUrl());

        Assert.assertEquals(driver.getTitle(), "OrangeHRM");

    }

    @AfterTest
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
