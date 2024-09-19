package com.factoryDesignPattern.seleniumFactoryDesign;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class MsEdgeDriverManager implements BrowserDriver {

    @Override
    public WebDriver createDriver() {
        return new EdgeDriver();
    }
}
