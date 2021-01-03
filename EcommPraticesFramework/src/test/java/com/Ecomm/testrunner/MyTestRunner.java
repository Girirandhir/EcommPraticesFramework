package com.Ecomm.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/Appfeatures/login.feature"},
		glue= {"com/Ecomm/stepdefination","com/Ecomm/AppHooks"},
		plugin= {"pretty", 
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				,"json:target/cucumber-reports/cucumber.json"
				,"html:target/cucumber-reports/htmlReport.html"
				}
			
		
		)
public class MyTestRunner {

}
