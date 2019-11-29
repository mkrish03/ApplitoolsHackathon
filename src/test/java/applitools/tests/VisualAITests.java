package applitools.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.TestResultsSummary;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Eyes;

import applitools.pageobjects.HomePage;
import applitools.pageobjects.LoginPage;
import applitools.utils.BaseUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

public class VisualAITests extends BaseUtils {

	private static EyesRunner runner;
	private static Eyes eyes;
	private static BatchInfo batch;
	public static LoginPage loginpage;
	public static HomePage homepage;

	@BeforeClass
	public static void setBatch() throws IOException, Exception {
		// Must be before ALL tests (at Class-level)
		batch = new BatchInfo("Demo batch");

		// Initialize the Runner for your test.
		runner = new ClassicRunner();

		// Initialize the eyes SDK
		eyes = new Eyes(runner);

		// Set your personal Applitols API Key from your environment variables.
		eyes.setApiKey("BXpZCmY104QoX1084Ua97ld1ctUXKFQxkB2y98oHH102QW0a0Is110");

		// set batch name
		eyes.setBatch(batch);

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void visutalTest() throws Exception {

		loginpage = new LoginPage();
		homepage = new HomePage();
		// Set AUT's name, test name and viewport size (width X height)
		// We have set it to 800 x 600 to accommodate various screens. Feel free to
		// change it.

		// RectangleSize viewportSizeLandscape = new RectangleSize(/*width*/ 2047,
		// /*height*/ 1000 );
		driver = eyes.open(driver, "Demo App", "Smoke Test");

		// eyes.open(driver, "Demo App", "Smoke Test", new RectangleSize(2047, 900));
		// eyes.open(driver, "Demo App", "Smoke Test", viewportSizeLandscape);

		// Navigate the browser to the "ACME" demo app.
		driver.get(getAppProperties("url"));

		// To see visual bugs after the first run, use the commented line below instead.
		// driver.get("https://demo.applitools.com/index_v2.html");

		// Visual checkpoint #1 - Check the login page.
		eyes.checkWindow("Login Window");

		// This will create a test with two test steps.
		loginpage.clickOnLogin();
		// driver.findElement(By.id("log-in")).click();

		eyes.checkWindow("No Credentials Warning Message");

		loginpage.enterPassword();
		loginpage.clickOnLogin();

		eyes.checkWindow("No Username Warning Message");

		driver.findElement(By.id("password")).clear();
		loginpage.enterUsername();
		loginpage.clickOnLogin();

		eyes.checkWindow("No Password Warning Message");

		loginpage.enterUsername();
		loginpage.enterPassword();
		loginpage.clickOnLogin();

		eyes.checkWindow("Home Page");

		homepage.clickOnAmount();

		eyes.checkWindow("Amount Ascending");

		homepage.clickOnCompareExpense();

		eyes.checkWindow("Canvas chart");
		
		driver.get("https://demo.applitools.com/hackathonV2.html?showAd=true");
		
		loginpage.enterUsername();
		loginpage.enterPassword();
		loginpage.clickOnLogin();
		
		eyes.checkWindow("Gif Image in Home Page");

		//
		// // Visual checkpoint #2 - Check the app page.
		// eyes.checkWindow("App Window");

		TestResultsSummary allTestResults = runner.getAllTestResults();
		System.out.println(allTestResults);

		// End the test.
		eyes.closeAsync();
	}

	@AfterClass
	public static void afterMethod() throws Exception {

		// Close the browser.
		quitBrowser();

		// If the test was aborted before eyes.close was called, ends the test as
		// aborted.
		eyes.abortIfNotClosed();

	}

}
