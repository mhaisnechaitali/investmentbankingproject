package Module1_Login_Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LibraryFiles.BaseClass;
import LibraryFiles.UtilityClass;
import Module1_Login.KiteHomePage;
import Module1_Login.KiteLogin1Page;
import Module1_Login.KiteLogin2Page;

public class KiteLoginTest extends BaseClass
{
	KiteLogin1Page login1;
	KiteLogin2Page login2;
	KiteHomePage home;
	
	int TCID;
	
	
	@BeforeClass
	public void openBrowser() throws EncryptedDocumentException, IOException
	{				
		initializeBrowser();	
	    login1=new KiteLogin1Page(driver);		
	    login2=new KiteLogin2Page(driver);		
	    home=new KiteHomePage(driver);
	}
	
	
	@BeforeMethod
	public void loginToApp() throws EncryptedDocumentException, IOException 
	{
		login1.inpKiteLogin1PageUsername(UtilityClass.getPFData("UN"));
		login1.inpKiteLogin1PagePassword(UtilityClass.getPFData("PWD"));
		login1.clickKiteLogin1PageLoginBtn();
		login2.inpKiteLogin2PagePin(UtilityClass.getPFData("PIN"));
		login2.clickKiteLogin2PageCntBtn();
	}
	
	
	@Test
	public void verifyUserID() throws EncryptedDocumentException, IOException 
	{	
		TCID = 101;
		
		String actUserID=home.getKiteHomePageUserID();
		String expUserID=UtilityClass.getTD(0, 3);
		
		Assert.assertEquals(actUserID, expUserID,"Failed: both results are diff-");
	}
	
	
	@AfterMethod
	public void logoutFromApp(ITestResult s1) throws IOException 
	{
		if(s1.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass.captureScreenshot(driver, TCID);			
		}
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}
	

}
