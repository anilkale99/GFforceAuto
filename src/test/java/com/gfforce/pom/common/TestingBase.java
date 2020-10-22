package com.gfforce.pom.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestingBase {
	
	private static TestingBase instance;
    private static WebDriver driver;
    private static Thread CLOSE_DRIVER = new Thread() {
        @Override
        public void run() {
            driver.close();
        }

    };

    static {
        Runtime.getRuntime().addShutdownHook(CLOSE_DRIVER);
    }

    private TestingBase() {
    	System.setProperty("webdriver.chrome.driver", "/test/resources/lib/chromedriver_win32_ForChrome83/chromedriver.exe");
        driver = new ChromeDriver();
    }

    public static TestingBase getTestingBase() {
        if (instance == null) {
            instance = new TestingBase();
        }
        return instance;

    }

    public static WebDriver getDriver() {
        return getTestingBase().driver;
    }

}
