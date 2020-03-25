package demo;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class link_log{
	
	public static WebDriver driver;
	Logger logger=Logger.getLogger("link_log");

	@Test(priority=0)
	public void enterURL()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kothiya.kuman\\Desktop\\Testing\\selenium_sw\\chromedriver_win32\\chromedriver.exe");
		logger.debug("Open the webbrowser");
		logger.debug("------------------------------------------------------------------------");
		
		driver=new ChromeDriver();
		
		logger.debug("Enter the url: http://www.optis.co.in/");
		driver.get("http://www.optis.co.in/");
		
	
		driver.manage().window().maximize();
		
	}
	@Test(priority=1)
	public void contactus()
	{
		logger.debug("Clicking on the ContactUs ");
		driver.findElement(By.xpath("//a[contains(text(),'Contact')]")).click();
		WebElement findElement = driver.findElement(By.xpath("//div[@class='contact-block']//p[contains(text(),'#56')]"));
		
		String text = findElement.getText();
		logger.debug("Address= "+text);
		logger.debug("------------------------------------------------------------------------");
		System.out.println(text);
	}
	@Test(priority=2)
	public void geeksURL() throws InterruptedException
	{
		logger.debug("Enter the URL: https://www.geeksforgeeks.org/");
		driver.get("https://www.geeksforgeeks.org");
		
		
		WebElement link1 = driver.findElement(By.xpath("//a[@href='https://www.facebook.com/geeksforgeeks.org/']"));
		String href1 = link1.getAttribute("href");
		logger.debug("FaceBook Link for GeeksForGeeks: "+href1);
		System.out.println(href1);
		
		WebElement link2 = driver.findElement(By.xpath("//a[@href='https://www.instagram.com/geeks_for_geeks/']"));
		String href2 = link2.getAttribute("href");
		logger.debug("Instagram Link for GeeksForGeeks: "+href2);
		System.out.println(href2);
		
		WebElement link3 = driver.findElement(By.xpath("//a[@href='https://in.linkedin.com/company/geeksforgeeks']"));
		String href3 = link3.getAttribute("href");
		logger.debug("LinkedIn Link for GeeksForGeeks: "+href3);
		System.out.println(href3);
		
		WebElement link4 = driver.findElement(By.xpath("//a[@href='https://twitter.com/geeksforgeeks']"));
		String href4 = link4.getAttribute("href");
		logger.debug("Twitter Link for GeeksForGeeks: "+href4);
		System.out.println(href4);
		
		WebElement link5 = driver.findElement(By.xpath("//a[@href='https://www.youtube.com/geeksforgeeksvideos']"));
		String href5 = link5.getAttribute("href");
		logger.debug("Youtube Link for GeeksForGeeks: "+href5);
		System.out.println(href5);
		
		WebElement link6 = driver.findElement(By.xpath("//a[@href='https://play.google.com/store/apps/details?id=free.programming.programming&hl=en']"));
		String href6 = link6.getAttribute("href");
		logger.debug("GoogleStore Link for GeeksForGeeks: "+href6);
		System.out.println(href6);
		logger.debug("------------------------------------------------------------------------");
		
	}
	@Test(priority=3)
	public void tutorialspointURL()
	{
		logger.debug("Enter the URL: https://www.tutorialspoint.com/index.htm");
		driver.get("https://www.tutorialspoint.com/index.htm");
		
		
		WebElement link1 = driver.findElement(By.xpath("//a[@href='https://www.facebook.com/tutorialspointindia']"));
		String href1 = link1.getAttribute("href");
		logger.debug("FaceBook Link for TutorialsPoint: "+href1);
		System.out.println(href1);
		
		WebElement link2 = driver.findElement(By.xpath("//a[@href='https://plus.google.com/u/0/+tutorialspoint']"));
		String href2 = link2.getAttribute("href");
		logger.debug("Google+ link for TutorialsPoint: "+href2);
		System.out.println(href2);
		
		WebElement link3 = driver.findElement(By.xpath("//a[@href='http://www.twitter.com/tutorialspoint']"));
		String href3 = link3.getAttribute("href");
		logger.debug("Twitter Link for TutorialsPoint: "+href3);
		System.out.println(href3);
		
		WebElement link4 = driver.findElement(By.xpath("//a[@href='http://www.linkedin.com/company/tutorialspoint']"));
		String href4 = link4.getAttribute("href");
		logger.debug("LinkedIn link for TutorialsPoint: "+href4);
		System.out.println(href4);
		
		WebElement link5 = driver.findElement(By.xpath("//a[@href='https://www.youtube.com/channel/UCVLbzhxVTiTLiVKeGV7WEBg']"));
		String href5 = link5.getAttribute("href");
		logger.debug("Youtube Link for GeeksForGeeks: "+href5);
		System.out.println(href5);
		
		logger.debug("------------------------------------------------------------------------");

	}
	@Test(priority=4)
	public void closethebrowser()
	{
		logger.debug("Close the browser");
		driver.close();
	}

}
