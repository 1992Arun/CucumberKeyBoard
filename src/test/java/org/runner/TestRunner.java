package org.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.utility.Utility;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources", glue="org.stepDefinition", 
									
                                      											monochrome=true, plugin= {"pretty",
                            		"json:src\\test\\resources\\Reports\\JSON\\JSONReports.json"})
public class TestRunner								 {
	
	
	@AfterClass
	public static void JVMReport() {
		
		Utility.getJVMReport("src\\test\\resources\\Reports\\JSON\\JSONReports.json");
									
	}

}
																			