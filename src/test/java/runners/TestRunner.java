package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {
                "pretty",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm:target/allure-results"
        },
        features = "src/test/resources/features/LoginSauce.feature",
        glue = {"steps"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
