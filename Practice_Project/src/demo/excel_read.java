package demo;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class excel_read {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		String path="C:\\Users\\Kothiya.kuman\\eclipse-workspace\\Practice_Project\\src\\demo\\Book1.xls";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kothiya.kuman\\Desktop\\Testing\\selenium_sw\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		String sheet="VerifyValidLoginPageE";
		
		String actualurl1=Excel.getCellValue(path, sheet,1, 5);
		String un1=Excel.getCellValue(path, sheet,1, 1);
		String pass1=Excel.getCellValue(path, sheet,1, 2);
		String expectedurl1=Excel.getCellValue(path, sheet,1, 6);
		
		System.out.println("Log in to url:"+actualurl1);
		driver.get(actualurl1);
		driver.manage().window().maximize();
		
		System.out.println("entering the username: "+un1);
		driver.findElement(By.id("username")).sendKeys(un1);
		Thread.sleep(1000);
	
		System.out.println("entering  the password: "+pass1);
		driver.findElement(By.name("pwd")).sendKeys(pass1);
		Thread.sleep(1000);
	
		System.out.println("clicking on the login button");
		driver.findElement(By.id("loginButton")).click();
	
		Thread.sleep(10000);
		String currentUrl = driver.getCurrentUrl();
	
		//String expectedUrl="https://online.actitime.com/tcs/user/submit_tt.do";
	
		try 
		{
			
			System.out.println("Verifying the homepage url: "+expectedurl1);
			Assert.assertEquals(currentUrl, expectedurl1);
			System.out.println("Passed..");
		}
		catch(AssertionError ex)
		{
			System.out.println("Fail");
		}

		
		
		
		

	}

}
