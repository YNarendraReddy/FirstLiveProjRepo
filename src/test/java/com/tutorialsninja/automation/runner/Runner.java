package com.tutorialsninja.automation.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/FeatureFiles", // folder containing feature files
    glue = {"com.tutorialsninja.automation.stepdef"}, // step definitions & hooks
    plugin = {
        "html:target/cucumber-reports/cucumber.html",
        "json:target/cucumber-reports/cucumber.json",
        "junit:target/cucumber-reports/cucumber.xml"})
public class Runner {
}
