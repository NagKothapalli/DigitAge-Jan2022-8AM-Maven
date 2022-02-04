package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
		PageFactory.initElements(driver, this);
	}
	//-----------------WebElements-----------------
		@FindBy(xpath = "//a[@title='Home']")  WebElement homeBtn;
	//---------------------------------------------
	public void launchApplication()
	{
		System.out.println("RC : Launch Application");	
		//driver.get(data.readData("URL"));
	}
	public void loginToApplication()
	{
		System.out.println("RC : Login To Application");		
	}
	public void logoutFromApplication()
	{
		System.out.println("RC : Logout From Application");
		//appUtils.getElement("//a[@title='Home']").click();
		homeBtn.click();
	}
	public void closeApplication()
	{
		System.out.println("RC : Close Application");		
	}

}
