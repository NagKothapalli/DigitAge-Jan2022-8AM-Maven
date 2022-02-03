package pageObjects;

import org.openqa.selenium.WebDriver;

import appUtilities.ApplicationUtilities;
import gUtilities.ReadProperties;
import testBatches.TestBatches;

public class Login
{
	WebDriver driver;
	ReadProperties data;
	ApplicationUtilities appUtils;
	public Login(WebDriver driver)
	{
		this.driver = driver;		
		data = new ReadProperties("TestData/"+TestBatches.env+"Data.properties");//ProdData
		appUtils = new ApplicationUtilities(driver);
	}
	public void launchApplication()
	{
		System.out.println("RC : Launch Application");	
		driver.get(data.readData("URL"));
	}
	public void loginToApplication()
	{
		System.out.println("RC : Login To Application");		
	}
	public void logoutFromApplication()
	{
		System.out.println("RC : Logout From Application");
		appUtils.getElement("//a[@title='Home']").click();
	}
	public void closeApplication()
	{
		System.out.println("RC : Close Application");		
	}

}
