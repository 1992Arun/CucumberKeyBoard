package org.stepDefinition;

import org.junit.BeforeClass;
import org.utility.BaseClass;

import io.cucumber.java.After;

public class HooksClass extends BaseClass {

	
	@BeforeClass
	public void setUp() {
		
		browserLaunch("Chrome");
		
		launchURL("https://tutorialsninja.com/demo/");
		
	}
	
	@After
	public void tearDown() {
		
		quit();
		
	}
	
	
}
