package testBatches;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import appUtilities.DriverSetUp;
import gUtilities.ReadProperties;
import testScenarios.TestCases;

public class TestBatches
{
	//Relative path using canonical file path
	//Generate random number using Random class
	//Generate dynamic HTML file using extentreports API .
	//Generate new file for every execution . Append execution type in the filename like smoke / regression
	//Take Error screenshot dynamically . Save it as png file . Append the same in to the report in file case.
	WebDriver driver;
	TestCases testCases;
	ReadProperties config;
	public static String env;
	public static ExtentReports extent;
	public static ExtentTest parent;
	String root;
	public TestBatches()
	{
		driver = new DriverSetUp().getDriver();
		config = new ReadProperties("TestData/Config.properties");
		env = config.readData("Environment");
		testCases = new TestCases(driver);
		String ttype = config.readData("TestingType");
		int ran = new Random().nextInt(9999); // 1234/6578/6532 ....
		try {
			root = new File(".").getCanonicalPath();
			System.out.println("My root dir :" + root);
		} catch (IOException e) {
			e.printStackTrace();
		}		
		//extent = new ExtentReports("D:\\WorkSpace\\Java\\DigitAge-Jan2022-8AM-Maven\\Reports\\ApsrtcReport-"+ttype+"-"+ran+".html");
		extent = new ExtentReports(root+"\\Reports\\ApsrtcReport-"+ttype+"-"+ran+".html");
	}
	@Test
	public void runUserChoice()
	{
		System.out.println("*************Execution Summary********************");
		System.out.println("TestingType :" + config.readData("TestingType").toUpperCase() );
		System.out.println("Environent / Server :" + config.readData("Environment").toUpperCase());
		System.out.println("Execution Type :" +config.readData("ExecutionType").toUpperCase() );
		System.out.println("Browser :" + config.readData("Browser").toUpperCase());
		parent = extent.startTest(config.readData("TestingType").toUpperCase()); //smoke or regression or UAT or sanity ......
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
		
		//ExtentTest smoke = extent.startTest("SMOKE"); //parent table
		//ExtentTest child1 = extent.startTest("BookBusTicketAndCancel");
		//ExtentTest child2 = extent.startTest("BookBusTicketAndPrint");
		//ExtentTest child3 = extent.startTest("BookBusTicketAndTrackService");
		//smoke.appendChild(child1); smoke.appendChild(child2); smoke.appendChild(child3);
		System.out.println("Test Suite : SMOKE");
		testCases.bookBusTicketAndCancel(); //pass or fail
		//child1.log(LogStatus.PASS, "BookBusTicketAndCancel", "Successfull");
		//child1.log(LogStatus.INFO, "It is a Smoke Test , it took 50 seconds of time to finish ");
		testCases.bookBusTicketAndPrint();
		//child2.log(LogStatus.PASS, "bookBusTicketAndPrint", "Successfull");
		//child2.log(LogStatus.INFO, "It is a Smoke Test , it took 50 seconds of time to finish ");
		testCases.bookBusTicketAndTrackService();
		//child3.log(LogStatus.PASS, "bookBusTicketAndTrackService", "Successfull");
		//child3.log(LogStatus.INFO, "It is a Smoke Test , it took 50 seconds of time to finish ");
		
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
	@After   // Junit   //@AfterTest   // TestNG	
	public void cleanUp()
	{
		extent.endTest(parent);
		extent.flush();
		driver.quit();
	}
	
	//Assignment for 7thFeb-22:  Reproduce the below things on your own 
	
	//Relative path using canonical file path
		//Generate random number using Random class
		//Generate dynamic HTML file using extentreports API .
		//Generate new file for every execution . Append execution type in the filename like smoke / regression
		//Take Error screenshot dynamically . Save it as png file . Append the same in to the report in file case.

}
