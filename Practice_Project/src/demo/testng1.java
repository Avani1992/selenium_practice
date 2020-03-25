package demo;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class testng1  extends Base_testng{
	
	
	@Test(priority = 0)
	public void enterURL()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kothiya.kuman\\Desktop\\Testing\\selenium_sw\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://online.actitime.com/tcs/login.do");
	
		driver.manage().window().maximize();
	}
	@Test(priority=1)
	public void enterUsername()
	{
		driver.findElement(By.id("username")).sendKeys("patelavani42@gmail.com");
	}
	@Test(priority = 2)
	public void enterPassword()
	{
		driver.findElement(By.name("pwd")).sendKeys("manager1");
	}
	@Test(priority = 3)
	public void clickLoginButton() throws InterruptedException 
	{
		driver.findElement(By.id("loginButton")).click();
		Thread.sleep(1000);
	}
	
	@Test(priority=4)
	public void VerifyingHomePageURL()
	{
			String currentUrl = driver.getCurrentUrl();
			Assert.assertEquals("expected", currentUrl);
	}
	@Test(dependsOnMethods = {"VerifyingHomePageURL"})
	public void clickingLogoutButton()
	{
		driver.findElement(By.id("logoutLink")).click();
	}
	@Test(priority=5)
	public void enterFBURL()
	{
		driver.get("http://www.facebook.com");
	}
	@Test(priority=6)
	public void enterFBUsername()
	{
		driver.findElement(By.id("email")).sendKeys("avani");
	}
	@Test(priority=7)
	public void enterFBPassword()
	{
		driver.findElement(By.id("pass")).sendKeys("1234");
		Assert.assertEquals("2345", "5678");
	}
	@Test(dependsOnMethods = {"enterFBPassword"})
	public void clickingFBLoginButton()
	{
		driver.findElement(By.id("u_0_b")).click();
	}
	@Test(priority=9)
	public void closeDriver()
	{
		driver.close();
	}
	
	

}
