package practiceTestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGPractice 
{
	@BeforeTest
	public void launchApplication()
	{
		System.out.println("RC : LaunchApplication");
	}
	@BeforeMethod
	public void loginApplication()
	{
		System.out.println("RC : LoginApplication");
	}
	@Test
	public void sendMail()  //A
	{
		System.out.println("TC : SendMail");
	}
	@Test(dependsOnMethods={"sendMail"})
	public void replyMail() // B
	{
		System.out.println("TC : ReplyMail");
	}
	@Test(dependsOnMethods={"sendMail","replyMail"})
	public void deleteMail() // C
	{
		System.out.println("TC : DeleteMail");
	}
	@AfterMethod
	public void logoutApplication()
	{
		System.out.println("RC : LogoutApplication");
	}
	@AfterTest
	public void closeApplication()
	{
		System.out.println("RC : closeApplication");
	}


}
