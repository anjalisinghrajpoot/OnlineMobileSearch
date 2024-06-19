package SearchPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

//Web driver Instantiation
public class DriverSetup {
	
	public static WebDriver driver;
    static String baseURL="https://www.amazon.in/";
	
// Webdriver for Chrome
   public static WebDriver getChromeWEbDriver() {
		 driver = new ChromeDriver();
		 driver.get(baseURL);
		return driver;
	}
	
// Webdriver for edge
   	public static WebDriver getEdgeWEbDriver() {
		 driver = new EdgeDriver();
		 driver.get(baseURL);

		return driver;
	}
	
	
}
