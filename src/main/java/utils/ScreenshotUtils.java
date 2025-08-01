package utils;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.appium.java_client.android.AndroidDriver;

import java.io.ByteArrayInputStream;

public class ScreenshotUtils {
    public static void takeScreenshot(AndroidDriver driver, String nome) {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment(nome, "image/png", new ByteArrayInputStream(screenshot), ".png");
    }
}

