package applitools.stepdefinitions;

import applitools.pageobjects.HomePage;
import applitools.pageobjects.LoginPage;
import applitools.utils.AssertUtils;
import applitools.utils.BaseUtils;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TraditionalTestStepDefinitions extends BaseUtils {

	public static HomePage homepage;
	public static LoginPage loginpage;

	@Before
	public static void beforeEach() throws Exception {
		launchBrowser();
	}

	@After
	public static void afterEach() throws Exception {
		quitBrowser();
	}

	@Given("^Launch the Demo APP$")
	public void launch_the_demo_app() throws Throwable {
		launchUrl(getAppProperties("url"));
	}

	@When("^Click on Login$")
	public void click_on_login() throws Throwable {
		loginpage = new LoginPage();
		loginpage.clickOnLogin();
	}

	@Then("^Verify No Credentials Warning message$")
	public void verify_no_credentials_warning_message() throws Throwable {
		if (loginpage.isNoCrednWarningMsgExist()) {
			AssertUtils.assertTrue(true, "Warning message successfully displayed");
		} else {
			AssertUtils.assertTrue(false, "Warning message displayed");
		}
	}

	@Then("^Verify Password Warning message$")
	public void verify_password_warning_message() throws Throwable {
		if (loginpage.isPasswordWarningMsgExist()) {
			AssertUtils.assertTrue(true, "Password Warning message successfully displayed");
		} else {
			AssertUtils.assertTrue(false, "Password Warning message displayed");
		}
	}

	@Then("^Verify Username Warning message$")
	public void verify_username_warning_message() throws Throwable {
		if (loginpage.isUserNameWarningMsgExist()) {
			AssertUtils.assertTrue(true, "Username Warning message successfully displayed");
		} else {
			AssertUtils.assertTrue(false, "Username Warning message displayed");
		}
	}

	@And("^Enter Username$")
	public void enter_username() throws Throwable {
		loginpage = new LoginPage();
		loginpage.enterUsername();
	}

	@And("^Enter Password$")
	public void enter_password() throws Throwable {
		loginpage = new LoginPage();
		loginpage.enterPassword();
	}

	@Then("^Verify homepage is displayed$")
	public void verify_homepage_is_displayed() throws Throwable {

		homepage = new HomePage();
		AssertUtils.assertTrue(homepage.isAmountExist(), "Username Warning message successfully displayed");

	}

	@Then("^Verify the Sorting order of amount$")
	public void verify_the_sorting_order_of_amount() throws Throwable {
		homepage.isAmountSortedCorrectly();
	}

	@Then("^Verify the Canvas chart$")
	public void verify_the_canvas_chart() throws Throwable {

	}

	@And("^Click on Amount$")
	public void click_on_amount() throws Throwable {
		homepage = new HomePage();
		homepage.clickOnAmount();
	}

	@And("^Click on Compare Expenses$")
	public void click_on_compare_expenses() throws Throwable {
		homepage = new HomePage();
		homepage.clickOnCompareExpense();
	}

}
