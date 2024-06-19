package SearchPackage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class Onlinesearch {
	
	
	
	// method for validation and Testing
	public void Test(WebDriver driver) throws IOException, InterruptedException {
		
		
		//implicit wait to handle syncronization
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		// maximizing the browser window
		driver.manage().window().maximize();
		
		//Locating webElement
		WebElement searchbox_element=driver.findElement(By.id("twotabsearchtextbox"));
		
		//calling getCellData to retrieve data from cell
		String Input = ExcelUtils.getCellData(System.getProperty("user.dir")+"\\Testdata\\IOResult.xlsx","input",0,0);
		
		searchbox_element.sendKeys(Input);
		
		//calling screenShot method to capture Screenshot
		ScreenShot(driver, "./Screenshots/1.Sending inputs.png");
		
		//clicking the search button
		 driver.findElement(By.id("nav-search-submit-button")).click();
		
		
		 //Locating element and extracting text
		String val= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']/span[1]")).getText();
		
		//Validation of retrieved string from browser
		 if(val.contains("1-") && val.contains("over") && val.contains("results for")) {
                System.out.println("Validated Successfully");
	        	ExcelUtils.setCellData(System.getProperty("user.dir")+"\\Testdata\\IOResult.xlsx", "output", 0, 0, "Validated Successfully");
	        }
	        else {
	        	 System.out.println("Validation Unsuccessfully");
	        	ExcelUtils.setCellData(System.getProperty("user.dir")+"\\Testdata\\IOResult.xlsx", "output", 0, 0, "Validation Unsuccessfull");

	        }
		
		 //clicking on sort by list option
		 driver.findElement(By.xpath("//span[@id='a-autoid-0-announce']")).click();
		 
		//calling screenShot method to capture Screenshot
		 ScreenShot(driver, "./Screenshots/2.Sending inputs.png");
	        
		 //locating the list elements or options
	        List<WebElement> wl = driver.findElements(By.xpath("//ul[@role='listbox']//li"));
	       // System.out.println("Count of options"+wl.size());
	        
	        //counting the number of options
	        int c = wl.size()-1;
	     
	        String s = "Count of displayed options is "+String.valueOf(c);
	        System.out.println(s);
	        
	        //writing data in excel
        	ExcelUtils.setCellData(System.getProperty("user.dir")+"\\Testdata\\IOResult.xlsx", "output", 0, 1, s);

	        //clicking newest arrival otion
	        driver.findElement(By.id("s-result-sort-select_4")).click();
	        
	      //calling screenShot method to capture Screenshot
	        ScreenShot(driver, "./Screenshots/3.Sending inputs.png");
	        
	        String selected = driver.findElement(By.className("a-dropdown-prompt")).getText();
	        //validatiing the text
	        if(selected.matches("Newest Arrivals")) {
	        	System.out.println("Verified that  “Newest Arrivals” option got selected");
	        	ExcelUtils.setCellData(System.getProperty("user.dir")+"\\Testdata\\IOResult.xlsx", "output", 0, 2, "Verified “Newest Arrivals” option got selected ");
	        }
	        else {
	        	System.out.println("not verified");
	        	ExcelUtils.setCellData(System.getProperty("user.dir")+"\\Testdata\\IOResult.xlsx", "output", 0, 2, " “Newest Arrivals” option not got selected ");

	        }
        	ExcelUtils.setCellData(System.getProperty("user.dir")+"\\Testdata\\IOResult.xlsx", "output", 0, 3, "All Test cases Executed  ");
         //closing driver
		driver.quit();
	}
	
	//Method for ScreenShot
		public static void ScreenShot(WebDriver driver, String img ) throws IOException {
			File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File target = new File(img);
			FileHandler.copy(source,target);
		}
	
	
	
}	
	
	
	
	




