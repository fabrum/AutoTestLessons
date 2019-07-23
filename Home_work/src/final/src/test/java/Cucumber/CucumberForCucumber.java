package Cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"features/CucumberNegotive.feature","features/CucumberPositibe.feature"})
public class CucumberForCucumber {
}



