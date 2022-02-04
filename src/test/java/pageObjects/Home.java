package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import appUtilities.ApplicationUtilities;
import gUtilities.GeneralUtility;
import gUtilities.ReadProperties;
import testBatches.TestBatches;

public class Home 
{
	WebDriver driver;
	ReadProperties data;
	ApplicationUtilities appUtils;
	public Home(WebDriver driver)
	{
		this.driver = driver;
		data = new ReadProperties("TestData/"+TestBatches.env+"Data.properties");//ProdData
		appUtils = new ApplicationUtilities(driver);
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	//-----------------WebElements-----------------
		@FindBy(xpath = "//input[@name='source']")  WebElement fromCityObj;
		@FindBy(xpath = "//input[@name='destination']")  WebElement toCityObj;
		@FindBy(xpath = "//input[@name='txtJourneyDate']")  WebElement openCalendarBtn;
		@FindBy(xpath = "//input[@name='searchBtn']")  WebElement searchBtn;
		@FindBy(xpath = "//a[@title='Home']")  WebElement homeBtn;
		//---------------------------------------------
	public void navigateToHome()
	{
		System.out.println("RC : Navigate to Home");
		//explicit wait
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(homeBtn));
		//GeneralUtility.fixedWait(30);
		appUtils.getElement("//a[@title='Home']").click();
	}
	
	public void bookTicket()
	{
		System.out.println("RC : Book Ticket");
		fromCityObj.sendKeys(data.readData("FromCity"));
		GeneralUtility.fixedWait(1);
		appUtils.clickEnter();
		toCityObj.sendKeys(data.readData("ToCity"));
		GeneralUtility.fixedWait(1);
		appUtils.clickEnter();
		openCalendarBtn.click();
		appUtils.getElement("//a[text()='"+data.readData("JDate")+"']").click();
		searchBtn.click();
		GeneralUtility.fixedWait(1);
		homeBtn.click();
	}
	public void bookTicket_old()
	{
		System.out.println("RC : Book Ticket");
		appUtils.getElement("//input[@name='source']").sendKeys(data.readData("FromCity"));
		GeneralUtility.fixedWait(1);
		appUtils.clickEnter();
		appUtils.getElement("//input[@name='destination']").sendKeys(data.readData("ToCity"));
		GeneralUtility.fixedWait(1);
		appUtils.clickEnter();
		appUtils.getElement("//input[@name='txtJourneyDate']").click();
		//selectDate(data.readData("JDate"));  //a[text()='"+jDate+"']
		appUtils.getElement("//a[text()='"+data.readData("JDate")+"']").click();
		appUtils.getElement("//input[@name='searchBtn']").click();
		GeneralUtility.fixedWait(1);
		appUtils.getElement("//a[@title='Home']").click();
	}
	public void printTicket()
	{
		System.out.println("RC : Print Ticket");
	}

}
