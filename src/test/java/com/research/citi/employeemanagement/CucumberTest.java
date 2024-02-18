package com.research.citi.employeemanagement;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions( features = "classpath:/features", glue = "com.research.citi.employeemanagement.cucumberglue", plugin = {"pretty",
        "junit:target/cucumber-results.xml",
        "json:target/cucumber.json",
        "html:target/cucumber-html-report.html"
},
        monochrome = true)
public class CucumberTest {
}
