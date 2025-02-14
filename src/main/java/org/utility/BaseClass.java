package org.utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {

	public static WebDriver driver;

	public static void browserLaunch(String browser) {
		
		
		ChromeOptions ch = new ChromeOptions();
		
		ch.addArguments("--headless");

		switch( browser) {


		case "Chrome": driver = new ChromeDriver(ch);

		break;



		case "Edge": driver = new EdgeDriver();

		break;

		}


	}


	public static String launchURL(String url) {

		driver.get(url);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		return url;
		
		

	}

	public static String getCurrentURL() {

		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public static void sendKeys(WebElement e, String value) {

		try {

			e.sendKeys(value);

		}catch(Exception a) {

			JavascriptExecutor js = (JavascriptExecutor)driver;

			js.executeScript("arguments[0].value='"+value+"';", e);

		}

	}


	public static void click(WebElement e) {

		try {

			e.click();

		}catch(Exception a) {

			JavascriptExecutor js = (JavascriptExecutor)driver;

			
			js.executeScript("arguments[0].click();", e);

		}

	}

	public static String getText(WebElement e) {

		String text = e.getText();


		return text;

	}

	public static String getAttribute(WebElement e, String name) {

		String text = e.getAttribute(name);


		return text;

	}

	public static String takeScreenShots(String name) throws IOException{

		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(screenshotAs, new File(System.getProperty("user.dir")+"\\Screenshots\\"+name+".png"));
		
		String loc = System.getProperty("user.dir")+"\\Screenshots\\"+name+".png";		
		
		return loc;
		
		
	}


   public static void selectByIndex(WebElement e, int num){
	   
	   Select s = new Select(e);
	   
	   s.selectByIndex(num);

    }
   
   
 public static void selectByValue(WebElement e, String value){
	   
	   Select s = new Select(e);
	   
	   s.selectByValue(value);

    }
 
 
 public static void selectByText(WebElement e, String value){
	   
	   Select s = new Select(e);
	   
	   s.selectByVisibleText(value);

  }
 
  public static String getSelectedValue(WebElement e, int index){
	  
	  Select s = new Select(e);
	  
	  List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
	  
	  String text = allSelectedOptions.get(index).getText();
	  
	  
	return text;
	  
  }
  
  public static void switchWindow(int num){
	  
	  
	  List<String> li = new LinkedList();
	  
	  
	  try {
	   Set<String> windowHandles = driver.getWindowHandles();
	   
	   String windowHandle = driver.getWindowHandle();
	   
	   for(String x:windowHandles) {
		   
		   if(!windowHandle.equals(x)) {
	   
	   driver.switchTo().window(x);
	   
		   }
	   
	   }
	   
	  }catch(NoSuchElementException a) {
		  
		  
		  Set<String> windowHandles = driver.getWindowHandles();
		   
		   String windowHandle = driver.getWindowHandle();
		   
		 int count=1;
		   
		   for(String x:windowHandles) {
			   
			   if(count==num) {
		   
		         driver.switchTo().window(x);
		         
		         
		   
			   }
			   
			   count++;
		   
		   }
		  
	  } catch(Exception a) {
		  
		

		  Set<String> windowHandles = driver.getWindowHandles();
		  
		  li.addAll(windowHandles);
		   
		   driver.switchTo().window(li.get(num));
		         
		   
		  
	  }
	   
	   
	   
	  
  }
 
  public static void doublClick() {
	  
	  Actions a = new Actions(driver);
	  
	  a.doubleClick();
  }
  
 public static void quit(){
	  
	 driver.quit();
	  
  }
 
 public static void sleep(int num) {
	 
	  int time= num*1000;
	 
	 try {
		Thread.sleep(time);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
 }
 
 public static void previousPage(){
	 
	 driver.navigate().back();
 }
 
 
 public static String getSelected(WebElement e){
	 
	 Select s = new Select(e);
	 
	 WebElement firstSelectedOption = s.getFirstSelectedOption();
	 
	 String text = firstSelectedOption.getText();
	 
	return text;
	 
	 
 }
 
 public static void robot(String key, int times) {
	 Robot r = null ;
	 
	 try {
		 r = new Robot();
	} catch (AWTException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 
	 if(key.equalsIgnoreCase("TAB")) {
		 
		 for(int i=0;i<times;i++) {
		 
		 r.keyPress(KeyEvent.VK_TAB);
		 
		 r.keyRelease(KeyEvent.VK_TAB);
		 
		 }
		 
	 } else if(key.equalsIgnoreCase("ENTER")) {

           r.keyPress(KeyEvent.VK_ENTER);
		 
		 r.keyRelease(KeyEvent.VK_ENTER);
		 
	 }else if(key.equalsIgnoreCase("UPARROW")) {

		 for(int i=0;i<times;i++) {
			 
			 r.keyPress(KeyEvent.VK_UP);
			 
			 r.keyRelease(KeyEvent.VK_U);
			 
			 }
			 
	 }else if(key.equalsIgnoreCase("DOWNARROW")) {

		 for(int i=0;i<times;i++) {
			 
			 r.keyPress(KeyEvent.VK_DOWN);
			 
			 r.keyRelease(KeyEvent.VK_DOWN);
			 
			 }
			 
	 }else if(key.equalsIgnoreCase("SPACE")) {

		 for(int i=0;i<times;i++) {
			 
			 r.keyPress(KeyEvent.VK_SPACE);
			 
			 r.keyRelease(KeyEvent.VK_SPACE);
			 
			 }
			 
	 }else if(key.equalsIgnoreCase("BACKSPACE")) {

		 for(int i=0;i<times;i++) {
			 
			 r.keyPress(KeyEvent.VK_BACK_SPACE);
			 
			 r.keyRelease(KeyEvent.VK_BACK_SPACE);
			 
			 }
			 
	 }else if(key.equalsIgnoreCase("HOME")) {

		 for(int i=0;i<times;i++) {
			 
			 r.keyPress(KeyEvent.VK_HOME);
			 
			 r.keyRelease(KeyEvent.VK_HOME);
			 
			 }
			 
	 }
	 
	 
	 
 }
 

}

  