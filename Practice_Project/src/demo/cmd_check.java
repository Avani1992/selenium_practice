/*steps:1. right click + export + location of storeing + finish. convert into jar.
 * 2. create run.bat file(in notepad) write java -jar filename.jar.
 * 3. double click the file it's open in cmd and run.
 * 
 * */
package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class cmd_check {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kothiya.kuman\\Desktop\\Testing\\selenium_sw\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://www.google.com"); 
		driver.close();

	}

}
