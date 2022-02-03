package practiceTestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumTestsFirefox {
	  @Test
		public void replyToEmail()
		{
			goToInbox();
			open();
			read();
			reply();
		}
		@Test
		public void forwardToEmail()
		{
			goToInbox();
			open();
			read();
			forward();
		}
		@BeforeMethod
		public void beforeMethod()
		{
			System.out.println("Login in to gmail on Firefox");
		}
		@AfterMethod
		public void afterMethod()
		{
			System.out.println("Logout from gmail on Firefox");
		}
	 
	 public void goToInbox()
		{
			System.out.println("Inbox Method on Firefox");
		}
		public void open()
		{
			System.out.println("open Method on Firefox");
		}
		public void forward()
		{
			System.out.println("forward Method on Firefox");
		}
		public void read()
		{
			System.out.println("read Method");
		}
		public void reply()
		{
			System.out.println("reply Method");
		}
		@BeforeTest
		public void launch()
		{
			System.out.println("Launch gmail on Firefox");
		}
		@AfterTest
		public void close()
		{
			System.out.println("close gmail on firefox");
		}
}
