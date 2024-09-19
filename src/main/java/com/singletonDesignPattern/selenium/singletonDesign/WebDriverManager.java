package com.singletonDesignPattern.selenium.singletonDesign;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverManager {

    // private static instance
    // volatile for making Thread-safe
    // Thread safe means that a method or class instance can be
    // used by multiple threads at the same time without any problem.
    private static volatile WebDriverManager instance;

    // ThreadLocal class for running test in parallel
    private static final ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();


    // private constructor for singleton class
    // so that constructor can be accessed in same class
    // no other class can make object using this class
    private WebDriverManager(){};


    // initialize the driver
    private void initDriver(String browser){

        switch (browser.toLowerCase()){
            case "chrome":
                tlDriver.set(new ChromeDriver());
                break;
            case "firefox":
                tlDriver.set(new FirefoxDriver());
                break;
            case "edge":
                tlDriver.set(new EdgeDriver());
                break;
            default:
                throw new IllegalArgumentException("Invalid browser: " + browser);
        }

    }

    // create an instance for this class only once
    public static WebDriverManager getInstance(String browser){
        if (instance == null){
            synchronized (WebDriverManager.class){
                if(instance == null){
                    instance = new WebDriverManager();
                }
            }
        }

        if(tlDriver.get() == null){
            instance.initDriver(browser);
        }

        return instance;
    }

    // get the local copy of the driver
    public WebDriver getDriver(){
        return  tlDriver.get();
    }

    // quit the driver/browser
    public static void quitBrowser(){
        if(tlDriver.get() !=null){
            tlDriver.get().quit();
            tlDriver.remove();
        }
    }
}
