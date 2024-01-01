package testCase;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.practice.automationtesting.in.Utility;
import pages.AutoMationTestingHomePage;

public class VerifyAutomationTestingHomePageTitle {
	
	WebDriver driver;
	AutoMationTestingHomePage testingHomePage;
	@BeforeMethod
	public void setUp() throws IOException {

		driver=Utility.getDriver();//  Utility.getDriver(); this method is from Utility
		driver.get(Utility.getProperty("url"));//getProperty this is from Utility
		driver.manage().window().maximize();
		testingHomePage =new AutoMationTestingHomePage(driver);
	}
	@Test
	public void verifyClickOnMyAccount() {
		testingHomePage.clickOnMyAccount();
	}
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}

}
