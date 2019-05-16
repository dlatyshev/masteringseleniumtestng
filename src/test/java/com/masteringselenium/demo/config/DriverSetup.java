package com.masteringselenium.demo.config;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public interface DriverSetup {
    RemoteWebDriver getDriverObject(DesiredCapabilities capabilities);
}
