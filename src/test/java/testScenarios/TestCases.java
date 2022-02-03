package testScenarios;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.CancelTicket;
import pageObjects.Home;
import pageObjects.Login;
import pageObjects.TicketStatus;
import pageObjects.TrackService;

public class TestCases
{
	WebDriver driver; //null
	Login login;
	Home home;
	TicketStatus ticketStatus;
	TrackService trackService;
	CancelTicket cancelTicket;
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
	@Test
	public void bookBusTicketAndPrint() //TestCase
	{
		System.out.println("Test Case : BookBusTicketAndPrint");
		login.launchApplication();
		login.loginToApplication();
		home.navigateToHome();
		home.bookTicket();
		home.printTicket();
		login.logoutFromApplication();
		login.closeApplication();		
	}
	@Test
	public void bookBusTicketAndCheckStatus() //TestCase
	{
		System.out.println("Test Case : bookBusTicketAndCheckStatus");
		login.launchApplication();
		login.loginToApplication();
		home.navigateToHome();
		home.bookTicket();
		ticketStatus.navigateToTicketStatus();
		ticketStatus.checkTicketStatus();
		login.logoutFromApplication();
		login.closeApplication();
	}
	@Test
	public void bookBusTicketAndTrackService() //TestCase
	{
		System.out.println("Test Case : bookBusTicketAndTrackService");
		login.launchApplication();
		login.loginToApplication();
		home.navigateToHome();
		home.bookTicket();
		trackService.navigateToTrackService();
		trackService.trackTicketService();
		login.logoutFromApplication();
		login.closeApplication();
	}
	@Test
	public void bookBusTicketAndCancel() //TestCase
	{
		System.out.println("Test Case : bookBusTicketAndCancel");
		login.launchApplication();
		login.loginToApplication();
		home.navigateToHome();
		home.bookTicket();
		cancelTicket.navigateToCancelTicket();
		cancelTicket.cancelTheTicket();
		login.logoutFromApplication();
		login.closeApplication();
	}
	@Test
	public void bookBusTicketPrintAndTrackService() //TestCase
	{
		System.out.println("Test Case : bookBusTicketPrintAndTrackService");
		login.launchApplication();
		login.loginToApplication();
		home.navigateToHome();
		home.bookTicket();
		home.printTicket();
		trackService.navigateToTrackService();
		trackService.trackTicketService();
		login.logoutFromApplication();
		login.closeApplication();
	}
	
	

}
