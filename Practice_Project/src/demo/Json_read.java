package demo;

import java.io.FileReader;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Json_read {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kothiya.kuman\\Desktop\\Testing\\selenium_sw\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		//String actualurl="https://online.actitime.com/tcs/login.do";
		//System.out.println("Log in to url:"+actualurl);
		//driver.get(actualurl);
		//driver.manage().window().maximize();
		
		
		JSONParser parser=new JSONParser();
		try {
			
			Object obj=parser.parse(new FileReader("C:\\Users\\Kothiya.kuman\\eclipse-workspace\\Practice_Project\\src\\demo\\cmd.json"));
			JSONObject object=(JSONObject) obj;
			
			String actualurl1 = (String) object.get("actualurl");
			String un1 = (String) object.get("un");
			String pass1 = (String) object.get("pass");
			String expectedurl1 = (String) object.get("expectedUrl");
			
		

//		String un="patelavani42@gmail";
//		String pass="manager";
		
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
		
			driver.close();
		
			}
			catch(Exception ex)
			{
				System.out.println(ex);
			}

	}

}
		