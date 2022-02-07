package testScenarios;

import java.io.File;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.CancelTicket;
import pageObjects.Home;
import pageObjects.Login;
import pageObjects.TicketStatus;
import pageObjects.TrackService;
import testBatches.TestBatches;

public class TestCases
{
	WebDriver driver; //null
	Login login;
	Home home;
	TicketStatus ticketStatus;
	TrackService trackService;
	CancelTicket cancelTicket;
	ExtentTest child;
	public TestCases(WebDriver driver)
	{	
		this.driver = driver;
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "D:\\Softwares\\JarFiles\\chromedriver-win32-90\\chromedriver.exe"); driver =
		 * new ChromeDriver();
		 */  //if session ID is : 1234 then all pageobjects should work on the same ID
		login = new Login(driver); //session ID : 1234
		home = new Home(driver); //session ID : 1234
		ticketStatus = new TicketStatus(driver); //session ID : 1234
		trackService = new TrackService(driver); //session ID : 1234
		cancelTicket = new CancelTicket(driver);//session ID : 1234
	}
	//launch,login,bookTicket,PrintTicket,logout,close  - Test Steps
	//TC-001 : Step1 : 1.1,1.2,1.3
	boolean result;
	public void logReport(boolean flag,String stepName)
	{
		if(flag)
		{
			child.log(LogStatus.PASS, stepName,"Successfull");
		}
		else
		{
			child.log(LogStatus.FAIL,child.addScreenCapture(TakeErrorScreenShot(stepName)) ,stepName);
		}
	}
	String screenshotfilepath;
	public String TakeErrorScreenShot(String fname)
	{
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				screenshotfilepath = new File(".").getCanonicalPath()+"\\ScreenShots\\"+fname+new Random().nextInt(9999)+".png";
				FileUtils.copyFile(scrFile, new File(screenshotfilepath));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}     
	          scrFile = null;
	        return screenshotfilepath;
	}

	@Test
	public void bookBusTicketAndPrint() //TestCase  // I will create my own object and i will add myself to my parent
	{
		child = TestBatches.extent.startTest("BookBusTicketAndPrint");
		TestBatches.parent.appendChild(child);
		System.out.println("Test Case : BookBusTicketAndPrint");
		result = login.launchApplication();
		if(result)
		{
			child.log(LogStatus.PASS, "LaunchApplication","Successfull");
		}
		else
		{
			child.log(LogStatus.FAIL, "LaunchApplication","Failed");
		}
		
		result = login.loginToApplication(); 
		logReport(result,"Login");
		logReport(home.navigateToHome(),"NavigateToHome");
		logReport(home.bookTicket(),"bookTicket");
		logReport(home.printTicket(),"printTicket");
		logReport(login.logoutFromApplication(),"logoutFromApplication");
		logReport(login.closeApplication(),"closeApplication");
				
	}
	@Test
	public void bookBusTicketAndCheckStatus() //TestCase
	{
		child = TestBatches.extent.startTest("BookBusTicketAndCheckStatus");
		TestBatches.parent.appendChild(child);
		System.out.println("Test Case : bookBusTicketAndCheckStatus");
			
		logReport(login.launchApplication(),"launchApplication");
		logReport(login.loginToApplication(),"loginToApplication");
		logReport(home.navigateToHome(),"NavigateToHome");
		logReport(home.bookTicket(),"bookTicket");
		logReport(ticketStatus.navigateToTicketStatus(),"navigateToTicketStatus");
		logReport(ticketStatus.checkTicketStatus(),"checkTicketStatus");
		logReport(login.logoutFromApplication(),"logoutFromApplication");
		logReport(login.closeApplication(),"closeApplication");
	}
	@Test
	public void bookBusTicketAndTrackService() //TestCase
	{
		child = TestBatches.extent.startTest("BookBusTicketAndTrackService");
		TestBatches.parent.appendChild(child);
		System.out.println("Test Case : bookBusTicketAndTrackService");
				
		logReport(login.launchApplication(),"launchApplication");
		logReport(login.loginToApplication(),"loginToApplication");
		logReport(home.navigateToHome(),"NavigateToHome");
		logReport(home.bookTicket(),"bookTicket");
		logReport(trackService.navigateToTrackService(),"navigateToTrackService");
		logReport(trackService.trackTicketService(),"trackTicketService");
		logReport(login.logoutFromApplication(),"logoutFromApplication");
		logReport(login.closeApplication(),"closeApplication");
		
	}
	@Test
	public void bookBusTicketAndCancel() //TestCase
	{
		child = TestBatches.extent.startTest("BookBusTicketAndCancel");
		TestBatches.parent.appendChild(child);
		System.out.println("Test Case : bookBusTicketAndCancel");
				
		logReport(login.launchApplication(),"launchApplication");
		logReport(login.loginToApplication(),"loginToApplication");
		logReport(home.navigateToHome(),"NavigateToHome");
		logReport(home.bookTicket(),"bookTicket");
		logReport(cancelTicket.navigateToCancelTicket(),"navigateToCancelTicket");
		logReport(cancelTicket.cancelTheTicket(),"cancelTheTicket");
		logReport(login.logoutFromApplication(),"logoutFromApplication");
		logReport(login.closeApplication(),"closeApplication");
	}
	@Test
	public void bookBusTicketPrintAndTrackService() //TestCase
	{
		child = TestBatches.extent.startTest("BookBusTicketPrintAndTrackService");
		TestBatches.parent.appendChild(child);
		System.out.println("Test Case : bookBusTicketPrintAndTrackService");
				
		logReport(login.launchApplication(),"launchApplication");
		logReport(login.loginToApplication(),"loginToApplication");
		logReport(home.navigateToHome(),"NavigateToHome");
		logReport(home.bookTicket(),"bookTicket");
		logReport(home.printTicket(),"printTicket");
		logReport(trackService.navigateToTrackService(),"navigateToTrackService");
		logReport(trackService.trackTicketService(),"trackTicketService");
		logReport(login.logoutFromApplication(),"logoutFromApplication");
		logReport(login.closeApplication(),"closeApplication");
	}
	
	

}
