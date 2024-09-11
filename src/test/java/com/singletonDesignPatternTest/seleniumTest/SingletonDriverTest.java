package com.seleniumTest;

import com.selenium.singletonDesign.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SingletonDriverTest {

    protected WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setUp(String browser){

       driver =  WebDriverManager.getInstance(browser).getDriver();
       driver.manage().window().maximize();
       driver.manage().deleteAllCookies();
        System.out.println(WebDriverManager.getInstance(browser).hashCode());

    }

    @Test
    public void googleTitleTest(){
        driver.get("https://www.google.com");
        System.out.println(Thread.currentThread().getName());
        System.out.println("Google URL: " + driver.getCurrentUrl());
        Assert.assertEquals(driver.getTitle(),"Google");
    }

    @AfterTest
    public void tearDown(){
        WebDriverManager.quitBrowser();
    }
}
