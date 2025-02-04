package org.stepDefinition;

import org.utility.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HooksClass extends BaseClass {

	
	@Before
	public void setUp() {
		
		browserLaunch("Chrome");
		
		launchURL("https://tutorialsninja.com/demo/");
		
	}
	
	@After
	public void tearDown() {
		
		quit();
		
	}
	
	
}
