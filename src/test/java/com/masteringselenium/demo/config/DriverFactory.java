package com.masteringselenium.demo.config;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {

    private RemoteWebDriver webDriver;
    private WebDriverType selectedWebDriverType;
    private final String operationSystem = System.getProperty("os.name").toUpperCase();
    private final String systemArchitecture = System.getProperty("os.arch");

    public DriverFactory() {
        WebDriverType webDriverType = WebDriverType.CHROME;
        String browser = System.getProperty("browser").toUpperCase();
        try {
            webDriverType = WebDriverType.valueOf(browser);
        } catch (IllegalArgumentException ex) {
            System.err.println("Unknown driver specified, default browser is " + webDriverType);
        } catch (NullPointerException ex) {
            System.err.println("No driver specified, default browser is " + webDriverType);
        }

        selectedWebDriverType = webDriverType;
    }

    public RemoteWebDriver getDriver() {
        if (webDriver == null) {
            instantiateWebDriver(selectedWebDriverType);
        }

        return webDriver;
    }

    public void quitDriver() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }

    private void instantiateWebDriver(WebDriverType type) {
        System.out.println(" ");
        System.out.println("Local Operation System: " + operationSystem);
        System.out.println("Local Architecture: " + systemArchitecture);
        System.out.println("Selected Browser: " + selectedWebDriverType);
        System.out.println(" ");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        webDriver = type.getDriverObject(desiredCapabilities);
    }
}
