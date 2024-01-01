package testCase;

import java.io.IOException;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.practice.automationtesting.in.Utility;
import pages.OpenCartHomePage;


public class VerifyOpenCartHomePageTitle {
	
	WebDriver driver;
	OpenCartHomePage homePage;
	
	@BeforeMethod
public void setup() throws IOException {
		
		driver=Utility.getDriver();//  Utility.getDriver(); this method is from Utility
		driver.get(Utility.getProperty("url"));//getProperty this is from Utility
		driver.manage().window().maximize();
		homePage =new OpenCartHomePage(driver);
		
			}
	
	@Test
	public void clickRegistrationLink() {
		
		homePage.clickOnRegistrationLink();
			
//		JavascriptExecutor js =(JavascriptExecutor)driver;
//		js.executeScript("arguments[0].click();", homePage.getRegistrationLink());

	}
	@Test
	public void clickOnLoginLink() {
		
		homePage.clickOnLoginLink();
	}

}
