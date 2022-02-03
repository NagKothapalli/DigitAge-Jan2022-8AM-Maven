package com.DigitAge_Jan2022_8AM_Maven;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppTest 
{
	String expectedTitle = "Gmail"; //TestData 
	public WebDriver driver;//null
	String name = "Ram"; //null
	
	public AppTest()
	{
	  System.out.println("My name :" + name);
	  System.setProperty("webdriver.chrome.driver",
	  "D:\\Softwares\\JarFiles\\chromedriver-win32-90\\chromedriver.exe"); 
	  driver = new ChromeDriver(); // a new empty chrome browser will be opened
	}	
	//-----------------------------
	@Before
	public void launchApplication()
	{
		System.out.println("Test Case : Launch Application");			
		driver.get("https://gmail.com"); //We have to call URL of AUT 
		String actualTitle = driver.getTitle();
		System.out.println("My title :" + actualTitle);
		System.out.println("My url :" + driver.getCurrentUrl());
		System.out.println("My session ID :" + driver.getWindowHandle());
		if(expectedTitle.equals(actualTitle)) //Custom validation
		{
			System.out.println("Title Validation Passed"); //We will report it in a html file
		}
		else
		{
			System.out.println("Title Validation Failed");
		}
		Assert.assertEquals(expectedTitle, actualTitle);		
	}
	@Test
	public void loginToApplication()
	{
		//launchApplication();
		System.out.println("Test Case : Login To Application");
		//driver.findElement(By.name("identifier")).sendKeys("nag022@gmail.com");
		driver.findElement(By.id("identifierId")).sendKeys("nag022@gmail.com");
		driver.findElement(By.className("VfPpkd-vQzf8d")).click();
	}
}
