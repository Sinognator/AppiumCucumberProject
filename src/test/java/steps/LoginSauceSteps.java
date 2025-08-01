package steps;

import pages.LoginSaucePage;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import utils.DriverFactory;
import utils.ScreenshotUtils;

public class LoginSauceSteps {
    LoginSaucePage loginSauce;

    @Before
    public void setUp() throws Exception{
        DriverFactory.initialize();
        loginSauce = new LoginSaucePage(DriverFactory.getDriver());
    }

    @After
    public void tearDown() {
        DriverFactory.quit();
    }

    @Given("the app is opened")
    public void app_is_opened() {
        // já está aberto via DriverFactory
        loginSauce.validatePageLogin();
    }
    @When("I input the username")
    public void input_username(){
        loginSauce.inputUserName("standard_user");
    }

    @And("I input the password")
    public void input_use_password(){
        loginSauce.inputPassword("secret_sauce");
    }

    @And("I press Login")
    public void press_login(){
        loginSauce.clickLogin();
    }

    @Then("I should be at homepage")
    public void validate_homepage(){
        loginSauce.validatePageHome();
        ScreenshotUtils.takeScreenshot(loginSauce.getDriver(), "Print de validacao manual");
    }

}
