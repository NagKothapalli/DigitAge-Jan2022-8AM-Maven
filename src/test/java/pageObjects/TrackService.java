package pageObjects;

import org.openqa.selenium.WebDriver;

import appUtilities.ApplicationUtilities;
import gUtilities.ReadProperties;
import testBatches.TestBatches;

public class TrackService
{
	WebDriver driver;
	ReadProperties data;
	ApplicationUtilities appUtils;
	public TrackService(WebDriver driver)
	{
		this.driver = driver;
		data = new ReadProperties("TestData/"+TestBatches.env+"Data.properties");//ProdData
		appUtils = new ApplicationUtilities(driver);
	}
	public void navigateToTrackService()
	{
		System.out.println("RC : Navigate to TrackService");
		appUtils.getElement("//a[@title='Track Service']").click();
	}
	public void trackTicketService()
	{
		System.out.println("RC : Track Ticket Service");
		appUtils.getElement("//input[@name='serviceCode']").sendKeys(data.readData("ServiceNumber"));
	}

}
