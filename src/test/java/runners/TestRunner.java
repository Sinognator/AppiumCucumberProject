package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",   // Caminho das suas features
        glue = {"steps"},                           // Pacote onde estão seus Step Definitions
        plugin = {
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "pretty"                                // Opcional, apenas melhora a saída no terminal
        },
        monochrome = true                           // Deixa a saída do console mais "limpa"
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
