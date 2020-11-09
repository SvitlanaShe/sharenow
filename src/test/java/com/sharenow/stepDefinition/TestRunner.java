package com.sharenow.stepDefinition;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = ".//src/test/resources/features/",
        glue = {"com/sharenow/stepDefinition"},
        monochrome = true,
//        dryRun = false,
        plugin = {"pretty", "html:target/htmlReport.html"})
public class TestRunner {
}