package demo;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class acti_multi_login {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		Logger logger=Logger.getLogger("actitime_Login ");
		logger.debug("Opening the Browser");
		logger.debug("-------------------------------------------------------------------------------");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kothiya.kuman\\Desktop\\Testing\\selenium_sw\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		
		
		String sheet="actitme_loginE";
		String path="C:\\Users\\Kothiya.kuman\\eclipse-workspace\\Practice_Project\\src\\demo\\Book1.xls";
		int rowCount = Excel.getRowCount(path, sheet);
		
		for(int i=1;i<=rowCount;i++)
		{
			String currenturl = Excel.getCellValue(path, sheet, i, 3);
			System.out.println(i);
			System.out.println(currenturl);
			logger.debug("Entering the URL: "+currenturl);
			driver.get(currenturl);
			
			String un = Excel.getCellValue(path, sheet, i, 1);
			System.out.println("2");
			logger.debug("Entering the Username: "+un);
			driver.findElement(By.id("username")).sendKeys(un);
			Thread.sleep(1000);
			
			String pass = Excel.getCellValue(path, sheet, i, 2);
			System.out.println("3");
			logger.debug("Entering the Password: "+pass);
			driver.findElement(By.name("pwd")).sendKeys(pass);
			Thread.sleep(1000);
			
			System.out.println("4");
			logger.debug("Clicking the login button");
			driver.findElement(By.id("loginButton")).click();
			Thread.sleep(7000);
			
			String currentUrl2 = driver.getCurrentUrl();
			System.out.println(currentUrl2);
		
			
//			try
//			{	
//				SoftAssert soft=new SoftAssert();
//				String homeurl = Excel.getCellValue(path, sheet, i, 4);
//				System.out.println("5");
//				logger.debug("Verifying the homepage URL: "+homeurl);
//				soft.assertEquals(currentUrl2,homeurl);
//				try
//				{
//					driver.findElement(By.id("logoutLink")).click();
//					logger.debug("Closing the account");
//					System.out.println("6");
//					logger.debug("Pass");
//					logger.debug("---------------------------------------------------------------------");
//				}
//				catch(Exception e)
//				{
//				
//					System.out.println("Fail");
//					logger.debug("---------------------------------------------------------------------");
//				}
//			}
//			finally 
//			{
//				Thread.sleep(2000);
//			}
			
			String homeurl = Excel.getCellValue(path, sheet, i, 4);
			if(currentUrl2.equals(homeurl))
			{
				logger.debug("Verifying the homepage URL: "+homeurl);
				driver.findElement(By.id("logoutLink")).click();
				logger.debug("Closing the account");
				System.out.println("6");
				logger.debug("Pass");
				logger.debug("---------------------------------------------------------------------");
			}
			else
			{
				logger.debug("Fail");
				logger.debug("---------------------------------------------------------------------");
			}
//				
		}

		logger.debug("close the browser");
		driver.close();
		
		
	}

}
