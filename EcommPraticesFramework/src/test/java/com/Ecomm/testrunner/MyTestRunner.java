package com.Ecomm.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/Appfeatures"},
		glue= {"com/Ecomm/stepdefination","com/Ecomm/AppHooks"},
		plugin= {"pretty", 
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/"
				,"json:target/cucumber-reports/cucumber.json"
				,"html:target/cucumber-reports/htmlReport.html"
				}
		
		
		)
public class MyTestRunner {

}
