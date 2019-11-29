package applitools.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import applitools.utils.BaseUtils;

public class LoginPage extends BaseUtils {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	public static WebElement username;

	@FindBy(id = "password")
	public static WebElement password;

	@FindBy(id = "log-in")
	public static WebElement login;

	@FindBy(xpath= "//div[@class='alert alert-warning']")
	public static WebElement errorMsg;

	public void enterUsername() throws Exception {
		enterText(username, getAppProperties("username"), "Username");
	}

	public void enterPassword() throws Exception {
		enterText(password, getAppProperties("password"), "Password");
	}

	public void clickOnLogin() throws Exception {
		click(login, "Login");
	}
	
	public void clearUsername() throws Exception{
		username.clear();
	}
	
	public void clearPassword() throws Exception{
		password.clear();
	}

	public boolean isNoCrednWarningMsgExist() throws Exception {
		if (getText(errorMsg, "Warning message").equals("Both Username and Password must be present")) {
			return true;
		}
		return false;
	}

	public boolean isUserNameWarningMsgExist() throws Exception {
		if (getText(errorMsg, "Warning message").equals("Username must be present")) {
			return true;
		}
		return false;
	}

	public boolean isPasswordWarningMsgExist() throws Exception {
		if (getText(errorMsg, "Warning message").equals("Password must be present")) {
			return true;
		}
		return false;
	}

}
