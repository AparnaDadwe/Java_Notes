package testCase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.practice.automationtesting.in.Utility;

import pages.AutoMationTestingHomePage;
import pages.LostPassWordPage;
import pages.MyAccountPage;

public class VerifyLostPassWord {
	
	WebDriver driver;
	AutoMationTestingHomePage testingHomePage;
	MyAccountPage accountLoginPage;
	LostPassWordPage lostPassword;
	@BeforeMethod
public void setup() throws IOException {
		
		driver=Utility.getDriver();//  Utility.getDriver(); this method is from Utility
		driver.get(Utility.getProperty("url"));//getProperty this is from Utility
		driver.manage().window().maximize();
		testingHomePage = new AutoMationTestingHomePage(driver);
		accountLoginPage=new MyAccountPage(driver);
		lostPassword=new LostPassWordPage(driver);
		
			}
	
	@Test
	public void verifyLostPassWord() {
		testingHomePage.clickOnMyAccount();
		accountLoginPage.clickOnLostPassWord();
		lostPassword.getUserLoginEmailText().sendKeys("dadwePushpa24@gmail.com");
		
	}
	
	public void verifyBlankEmail() {
		
	}

}
