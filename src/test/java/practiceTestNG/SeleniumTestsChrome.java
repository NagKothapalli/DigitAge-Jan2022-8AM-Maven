package practiceTestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumTestsChrome
{
	@BeforeTest
	public void launch()
	{
		System.out.println("Launch gmail on Chrome");
	}
	@AfterTest
	public void close()
	{
		System.out.println("close gmail on Chrome");
	}
	
	  @Test
		public void replyToEmail()
		{
		  System.out.println("TestCase :replyToEmail ");
		    goToInbox();
			open();
			read();
			reply();
		}
		@Test
		public void forwardToEmail()
		{
			System.out.println("TestCase :forwardToEmail ");
			goToInbox();
			open();
			read();
			forward();
		}
		@BeforeMethod
		public void beforeMethod()
		{
			System.out.println("Login to gmail on Chrome");
		}
		@AfterMethod
		public void afterMethod()
		{
			System.out.println("Logout from gmail on Chrome");
		}
	 
		public void goToInbox()
		{
			System.out.println("Inbox Method on Chrome");
		}
		public void open()
		{
			System.out.println("open Method on Chrome");
		}
		public void forward()
		{
			System.out.println("forward Method on Chrome");
		}
		public void read()
		{
			System.out.println("read Method on Chrome");
		}
		public void reply()
		{
			System.out.println("reply Method on Chrome");
		}
		
}
