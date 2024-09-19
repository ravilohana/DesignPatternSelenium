package com.factoryDesignPattern.seleniumFactoryDesign;


import org.openqa.selenium.WebDriver;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

//    public static  BrowserDriver getDriver(String browserType){
//
//        switch (browserType.toLowerCase()){
//            case  "chrome":
//                return new ChromeDriverManager();
//            case "firefox":
//                return new FirefoxDriverManager();
//            case "edge":
//                return new MsEdgeDriverManager();
//            default:
//                throw new IllegalArgumentException("Invalid browser: " + browserType);
//        }
//    }


    // Method to get WebDriver instance for the current thread
    public static WebDriver getDriver(String browserType) {
        if (tlDriver.get() == null) {
            tlDriver.set(setDriver(browserType));
        }
        return tlDriver.get();
    }

    // Create driver based on browser type using the factory pattern
    private static WebDriver setDriver(String browserType) {
        BrowserDriver browserDriver = null;

        switch (browserType.toLowerCase()) {
            case "chrome":
                browserDriver = new ChromeDriverManager();
                break;
            case "firefox":
                browserDriver = new FirefoxDriverManager();
                break;
            case "edge":
                browserDriver = new MsEdgeDriverManager();
                break;
            default:
                throw new IllegalArgumentException("Invalid browser: " + browserType);
        }

        return browserDriver.createDriver();
    }

    // Method to quit the driver for the current thread
    public static void quitDriver() {
        if (tlDriver.get() != null) {
            tlDriver.get().quit();
            tlDriver.remove(); // Remove the driver instance to prevent memory leaks
        }
    }
}
