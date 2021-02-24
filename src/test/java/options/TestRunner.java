package options;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
         plugin = {"pretty","io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"},
        //plugin = {"html:target/cucumber-report/smoketest", "json:target/cucumber.json"},
        glue = {"steps"},
        features = {"src/test/features"})
public class TestRunner {

}
