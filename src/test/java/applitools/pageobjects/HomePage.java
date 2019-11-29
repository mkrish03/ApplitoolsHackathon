package applitools.pageobjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import applitools.utils.BaseUtils;

public class HomePage extends BaseUtils {

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "amount")
	public static WebElement amount;

	@FindBy(id = "showExpensesChart")
	public static WebElement compareExpenseChart;

	@FindBy(xpath = "//table//td[@class='text-right bolder nowrap']//span")
	public static List<WebElement> amountValue;

	public void clickOnAmount() throws Exception {
		click(amount, "Amount");
	}

	public void clickOnCompareExpense() throws Exception {
		click(compareExpenseChart, "Compare Expenses");
	}

	public boolean isAmountExist() throws Exception {
		if (elementIsDisplayed(amount, "Amount")) {
			return true;
		}
		return false;
	}

	public boolean isAmountSortedCorrectly() throws Exception {
		ArrayList<String> value = new ArrayList<String>();

		for (WebElement e : amountValue) {
			value.add(getText(e, "Amount Value").replace("USD", "").trim());
		}
		List tmp = new ArrayList(value);
		System.out.println(tmp);
		System.out.println(tmp.size());
		Collections.sort(value,Collections.reverseOrder());
		System.out.println(value);
		System.out.println(value.size());
		if (value.equals(tmp)) {
			return true;
		}
		return false;
	}

}
