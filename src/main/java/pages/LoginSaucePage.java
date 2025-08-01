package pages;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.WaitUtils;

import java.io.ByteArrayInputStream;


public class LoginSaucePage {
    AndroidDriver   driver;

    public LoginSaucePage(AndroidDriver driver){
        this.driver = driver;
    }

    public AndroidDriver getDriver(){
        return this.driver;
    }
    public void validatePageLogin(){
        driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]"));
        driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]"));

        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Print da tela de login", new ByteArrayInputStream(screenshot));
    }
    public void inputUserName(String name){
        driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]")).sendKeys(name);
    }

    public void inputPassword(String senha){
        driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]")).sendKeys(senha);
    }

    public void clickLogin(){
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]/android.widget.TextView")).click();
    }

    public void validatePageHome(){
        WaitUtils.waitForElementVisible(driver, By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView\n"), 10);

    }
}
