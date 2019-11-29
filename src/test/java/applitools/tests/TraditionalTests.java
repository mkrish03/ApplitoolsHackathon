package applitools.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import applitools.pageobjects.LoginPage;
import applitools.utils.BaseUtils;

/**
 * Unit test for simple App.
 */
public class TraditionalTests extends BaseUtils {

	public static LoginPage loginpage;

	@BeforeMethod
	public void beforeTest() throws Exception {
		launchUrl(getAppProperties("url"));
	}

	@Test(priority = 1)
	public void noCredentials() throws Exception {
		loginpage = new LoginPage();
		loginpage.clickOnLogin();
		Thread.sleep(5000);
		if (loginpage.isNoCrednWarningMsgExist()) {
			Assert.assertTrue(true, "Warning message successfully displayed");
		} else {
			Assert.assertTrue(false, "Warning message displayed");
		}

		System.out.println("Test1 completed");
	}

	@Test(priority = 2)
	public void noUsername() throws Exception {
		loginpage = new LoginPage();
		loginpage.enterPassword();
		loginpage.clickOnLogin();

		if (loginpage.isUserNameWarningMsgExist()) {
			Assert.assertTrue(true, "Username Warning message successfully displayed");
		} else {
			Assert.assertTrue(false, "Username Warning message displayed");
		}
		System.out.println("Test2 completed");
	}

	@Test(priority = 3)
	public void noPassword() throws Exception {
		loginpage = new LoginPage();
		loginpage.enterUsername();
		loginpage.clickOnLogin();
		if (loginpage.isPasswordWarningMsgExist()) {
			Assert.assertTrue(true, "Password Warning message successfully displayed");
		} else {
			Assert.assertTrue(false, "Password Warning message displayed");
		}
		System.out.println("Test3 completed");
	}

	@Test(priority = 4)
	public void login() throws Exception {
		loginpage = new LoginPage();
		loginpage.enterUsername();
		loginpage.enterPassword();
		loginpage.clickOnLogin();
		System.out.println("Test4 completed");
	}

	@AfterMethod
	public void afterTest() throws Exception {
		quitBrowser();
	}
}
