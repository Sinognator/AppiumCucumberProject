package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;

public class DriverFactory {
    public static AndroidDriver driver;
    public static Properties props = new Properties();

    public static void initialize() throws Exception {
        FileInputStream fis = new FileInputStream("src/test/resources/config/config.properties");
        props.load(fis);

        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName(props.getProperty("platformName"))
                .setPlatformVersion(props.getProperty("platformVersion"))
                .setDeviceName(props.getProperty("deviceName"))
                .setApp(props.getProperty("app"))
                .setAppPackage(props.getProperty("appPackage"))
                .setAppActivity(props.getProperty("appActivity"))
                .setAutomationName(props.getProperty("automationName"));

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);

    }

    public static AndroidDriver getDriver() {
        return driver;
    }

    public static void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
