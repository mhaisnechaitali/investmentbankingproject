package LibraryFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass
{
	
	//this method is use to get test data from excel sheet
	//need to pass 2 parameters: 1-rowIndex  2-colIndex
	//Author name: @Sanjay
	public static String getTD(int rowIndex,int colIndex) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\sanjay\\eclipse-workspace\\1st_JanSelenium_Maven\\TestData\\1stJan.xlsx");
	    String value = WorkbookFactory.create(file).getSheet("DDF").getRow(rowIndex).getCell(colIndex).getStringCellValue();
	    
	    return value;
	}
	
	//this method is use to capture screenshot of webpage
	//need to pass 2 parameters : 1-webdriver object 2- TestCaseID
	//Author name: @Sanjay
	public static void captureScreenshot(WebDriver driver,int TCID) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\sanjay\\eclipse-workspace\\1st_JanSelenium_Maven\\Screenshots\\TestCaseID"+TCID+".jpg");
		FileHandler.copy(src, dest);
	}
	
	
	
	public static String getPFData(String key) throws IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\sanjay\\eclipse-workspace\\1st_JanSelenium_Maven\\propertyFile.properties");
		
		Properties p=new Properties();
		p.load(file);
		
		String value = p.getProperty(key);
		
		return value;
	}

}
