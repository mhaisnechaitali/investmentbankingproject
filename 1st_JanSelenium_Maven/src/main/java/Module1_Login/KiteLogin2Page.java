package Module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//pom class2
public class KiteLogin2Page
{
	
 @FindBy(xpath="//input[@id='pin']") private WebElement pin;
 @FindBy(xpath="//button[text()='Continue ']") private	WebElement cntBtn;

 
 public KiteLogin2Page(WebDriver driver)
 {
	 PageFactory.initElements(driver, this);
 }
 
 
 public void inpKiteLogin2PagePin(String pinInfo) 
 {
	 pin.sendKeys(pinInfo);
 }
 
 public void clickKiteLogin2PageCntBtn()
 {
	cntBtn.click();
 }
 
 
 
}
//@FindBy(xpath="xpath expression")private WebElement pin;
//@FinfBy(xpath="xpath expression")private WebElement pin;
//@FindBy(xpath="xpath expresion")private WebElement cntBtn;

//public kiteloginpage(Webdriver driver)
//{
//PageFactory.initElements(driver,this);	
//}
//public void inpkiteloginpagePin(String pinInfo)
//{
	//pin.sendkeys(pinInfo);
//}
//public void clickkiteLoginPageCntBtn()
//{
//cntBtn.click();
//}
//}