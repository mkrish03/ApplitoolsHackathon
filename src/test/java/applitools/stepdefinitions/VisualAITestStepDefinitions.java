package applitools.stepdefinitions;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Eyes;

import applitools.pageobjects.HomePage;
import applitools.pageobjects.LoginPage;
import applitools.utils.BaseUtils;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class VisualAITestStepDefinitions extends BaseUtils {

	private static EyesRunner runner;
	private static Eyes eyes;
	private static BatchInfo batch;
	public static HomePage homepage;
	public static LoginPage loginpage;

	@Before
	public static void beforeEach() throws Exception {

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
//		launchBrowser();
	}

	@After
	public static void afterEach() throws Exception {
		// Close the browser.
//		quitBrowser();

		// If the test was aborted before eyes.close was called, ends the test as
		// aborted.
		eyes.abortIfNotClosed();
	}
	
	
	@Given("^Launch the Demo APP version2$")
    public void launch_the_demo_app_version2() throws Throwable {
		driver = eyes.open(driver, "Demo App", "Smoke Test");
        launchUrl(getAppProperties("url"));
    }

    @Then("^Verify login page$")
    public void verify_login_page() throws Throwable {
    	eyes.checkWindow("Login Window");
    }

    @Then("^Verify the no credentials warning message$")
    public void verify_the_no_credentials_warning_message() throws Throwable {
    	eyes.checkWindow("No Credentials Warning Message");
    }

    @Then("^Verify the Password warning message$")
    public void verify_the_password_warning_message() throws Throwable {
    	eyes.checkWindow("No Password Warning Message");
    }

    @Then("^Verify the Username warning message$")
    public void verify_the_username_warning_message() throws Throwable {
    	eyes.checkWindow("No Username Warning Message");
    }

    @Then("^Verify the Home page$")
    public void verify_the_home_page() throws Throwable {
    	eyes.checkWindow("Home Page");
    }

    @Then("^Verify the Amount sorting$")
    public void verify_the_amount_sorting() throws Throwable {
    	eyes.checkWindow("Amount Ascending");
    }
    
    @Then("^Verify the Canvas chart page$")
    public void verify_the_canvas_chart_page() throws Throwable {
    	eyes.checkWindow("Canvas chart");
    }

    @And("^Click on the  login button$")
    public void click_on_the_login_button() throws Throwable {
        loginpage=new LoginPage();
        loginpage.clickOnLogin();
    }
    
    @And("^Clear Username field$")
    public void clear_username_field() throws Throwable {
        loginpage.clearUsername();
    }

}
