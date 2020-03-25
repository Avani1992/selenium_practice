package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class cmd_test_10 extends Base_testng{
	
	@Test(priority = 0)
	public void testcase1()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kothiya.kuman\\Desktop\\Testing\\selenium_sw\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://online.actitime.com/tcs/login.do");
	
		driver.manage().window().maximize();
	}
	@Test(priority=1)
	public void testcase2()
	{
		driver.findElement(By.id("username")).sendKeys("patelavani42@gmail.com");
	}
	@Test(priority = 2)
	public void testcase3()
	{
		driver.findElement(By.name("pwd")).sendKeys("manager1");
	}
	@Test(priority = 3)
	public void testcase4() throws InterruptedException 
	{
		driver.findElement(By.id("loginButton")).click();
		Thread.sleep(1000);
	}
	
	@Test(priority=4)
	public void testcase5()
	{
			String currentUrl = driver.getCurrentUrl();
			Assert.assertEquals("expected", currentUrl);
	}
	@Test(dependsOnMethods = {"testcase5"})
	public void testcase6()
	{
		driver.findElement(By.id("logoutLink")).click();
	}
	@Test(priority=5)
	public void testcase7()
	{
		driver.get("http://www.facebook.com");
	}
	@Test(priority=6)
	public void testcase8()
	{
		driver.findElement(By.id("email")).sendKeys("avani");
	}
	@Test(priority=7)
	public void testcase9()
	{
		driver.findElement(By.id("pass")).sendKeys("1234");
		Assert.assertEquals("2345", "5678");
	}
	@Test(dependsOnMethods = {"testcase9"})
	public void testcase10()
	{
		driver.findElement(By.id("u_0_b")).click();
	}
	@Test(priority=9)
	public void testcase11()
	{
		driver.close();
	}
	
	


}
