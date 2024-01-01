package testCase;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.practice.automationtesting.in.Utility;
import pages.AutoMationTestingHomePage;
import pages.MyAccountPage;

public class VerifyLogin {
	WebDriver driver;
	AutoMationTestingHomePage testingHomePage;
	MyAccountPage accountLoginPage;
	@BeforeMethod
public void setup() throws IOException {
		
		driver=Utility.getDriver();//  Utility.getDriver(); this method is from Utility
		driver.get(Utility.getProperty("url"));//getProperty this is from Utility
		driver.manage().window().maximize();
		testingHomePage = new AutoMationTestingHomePage(driver);
		accountLoginPage=new MyAccountPage(driver);
		
			}
	@Test(dataProvider="credentials")
	public void verifyLoginCredential(String scenario,String userName,String passWord) throws IOException {
		testingHomePage.clickOnMyAccount();
		//verify that user login successfully using correct credential
		accountLoginPage.getuName().sendKeys(userName);
		accountLoginPage.getPassWord().sendKeys(passWord);
		accountLoginPage.getBtnLogin().click();
		
		//once login verify the following four scenario
		
		if(scenario.equals("bothCorrect")) {
			WebElement loginStatus=driver.findElement(By.className("woocommerce-MyAccount-content"));
			assertTrue(loginStatus.isDisplayed(), "Hello"+userName);
	
		}
		else if(scenario.equals("bothWrong")){
			String actualerrorMsg=driver.findElement(By.cssSelector(".woocommerce-error li")).getText();
			assertEquals(actualerrorMsg, "A user could not be found with this email address.");
		}
		else if(scenario.equals("correctUserName")) {
			String actualerrorMsg=driver.findElement(By.cssSelector(".woocommerce-error li")).getText();
			assertEquals(actualerrorMsg, ": the password you entered for the username "+userName);
		}
		else {
			String actualerrorMsg=driver.findElement(By.cssSelector(".woocommerce-error li")).getText();
			assertEquals(actualerrorMsg, "A user could not be found with this email address.");
		}
		
	}
	@DataProvider(name="credentials")
	public String[][] loginCredentialDataProvider() {
		
		String[][] multipleUserLoginCredential= {{"bothCorrect","dadwePushpa24@gmail.com","Dadwe@1234"},
				                               {"bothWrong","aparnadadwe@gmail.com","12345678"},
				                               {"correctUserName","dadwePushpa24@gmail.com","abcd@1234"},
				                               {"correctPassword","dadweaparna@gmail.com","Dadwe@1234"}};
		
		return multipleUserLoginCredential;
	}

//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}

}
