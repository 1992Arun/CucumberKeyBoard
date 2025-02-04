package org.utility;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.remote.RemoteWebDriver;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Utility extends BaseClass {
	
	
	public static String getBrowserName(){
		
		return ((RemoteWebDriver)driver).getCapabilities().getBrowserName();
		
		
		
	}
	

	
public static String getBrowserVersion(){
		
		return ((RemoteWebDriver)driver).getCapabilities().getBrowserVersion();
		
	}
	
	
	public static void getJVMReport(String json){
		
		File f = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Reports\\JVMReports.html");
		
		Configuration conf = new Configuration(f, "TestReport");
		
		conf.addClassifications("OS", System.getProperty("os.name"));
		
		conf.addClassifications("User Name", System.getProperty("user.name"));
		
		conf.addClassifications("Browser Version", getBrowserName());
		
		conf.addClassifications("Browser Version", getBrowserVersion());
		
		List<String> li = new LinkedList();
		
		li.add(json);
		
		ReportBuilder rb = new ReportBuilder(li, conf);
		
		rb.generateReports();
		
	}

}
