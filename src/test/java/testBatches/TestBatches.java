package testBatches;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.Test;

import appUtilities.DriverSetUp;
import gUtilities.ReadProperties;
import testScenarios.TestCases;

public class TestBatches
{
	WebDriver driver;
	TestCases testCases;
	ReadProperties config;
	public static String env;
	public TestBatches()
	{
		driver = new DriverSetUp().getDriver();
		config = new ReadProperties("TestData/Config.properties");
		env = config.readData("Environment");
		testCases = new TestCases(driver);
	}
	@Test
	public void runUserChoice()
	{
		System.out.println("*************Execution Summary********************");
		System.out.println("TestingType :" + config.readData("TestingType").toUpperCase() );
		System.out.println("Environent / Server :" + config.readData("Environment").toUpperCase());
		System.out.println("Execution Type :" +config.readData("ExecutionType").toUpperCase() );
		System.out.println("Browser :" + config.readData("Browser").toUpperCase());
		if(config.readData("ExecutionType").equalsIgnoreCase("REMOTE"))
		{
			System.out.println("Browser Version :" + config.readData("BrowserVersion").toUpperCase());
			System.out.println("Operating System :" + config.readData("OS").toUpperCase());
		}
		System.out.println("*********************************");
		if(config.readData("TestingType").equalsIgnoreCase("SMOKE"))
		{
			smokeSuite();
		}
		else if(config.readData("TestingType").equalsIgnoreCase("REGRESSION"))
		{
			regressionSuite();
		}
		else
		{
			System.out.println("Testing type is not supported :" + config.readData("TestingType"));
		}
	}
	
	@Test
	public void smokeSuite()
	{
		System.out.println("Test Suite : SMOKE");
		testCases.bookBusTicketAndCancel();
		//testCases.bookBusTicketAndPrint();
		//testCases.bookBusTicketAndTrackService();
	}
	@Test
	public void regressionSuite()
	{
		System.out.println("Test Suite : REGRESSION");
		testCases.bookBusTicketAndCancel();
		testCases.bookBusTicketAndPrint();
		testCases.bookBusTicketAndTrackService();
		testCases.bookBusTicketPrintAndTrackService();
		testCases.bookBusTicketAndCheckStatus();
	}
	//@After   // Junit
	//@AfterTest   // TestNG
	public void cleanUp()
	{
		driver.quit();
	}

}
