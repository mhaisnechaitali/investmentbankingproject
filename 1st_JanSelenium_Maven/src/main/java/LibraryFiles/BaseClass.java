package LibraryFiles;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass
{
	public WebDriver driver;
	
	public void initializeBrowser() throws IOException 
	{
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\sanjay\\eclipse-workspace\\1st_JanSelenium_Maven\\Browsers\\chromedriver.exe");
	    driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(UtilityClass.getPFData("URL"));
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);		
	}

}
