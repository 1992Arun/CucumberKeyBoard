package org.stepDefinition;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.utility.BaseClass;
import org.utility.LoginPage;
import org.utility.SearchPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseClass {

	public static LoginPage l;

	public static SearchPage s;

	@Given("Open the Application URL in any supported browser")
	public void open_the_Application_URL_in_any_supported_browser() {

		l = new LoginPage();

		s = new SearchPage();
	}

	@When("Enter search product {string} in search box and press Enter")
	public void enter_search_product_in_search_box_and_press_Enter(String string) {

		robot("TAB", 8);

		sendKeys(l.getSearchBox(), string);

		robot("TAB", 1);

		sleep(4);

		robot("ENTER", 1);

	}

	@When("verify Navigated to Search Page")
	public void verify_Navigated_to_Search_Page() {

		boolean displayed;

		try {

			displayed = s.getConfirmsearchPage().isDisplayed();

		} catch (Exception e) {

			displayed = false;
		}

		Assert.assertTrue(displayed);
	}

	@When("Enter Search {string}product in Search Criteria and press Enter")
	public void enter_Search_product_in_Search_Criteria_and_press_Enter(String string) {

		robot("HOME", 1);

		robot("TAB", 21);

		robot("BACKSPACE", 1);

		sendKeys(s.searchCriteria, string);

		robot("TAB", 3);

		robot("ENTER", 1);
	}

	@When("Verify multiple products {int} displayed")
	public void verify_multiple_products_displayed(Integer int1) {

		List<WebElement> searchResults = s.searchResults;

		int size = searchResults.size();

		boolean val = false;

		System.out.println("number of results" + size);

		System.out.println("expected number of results" + int1);

		if (int1 == size) {

			val = true;

		} else {

			val = false;

		}
											
		

		Assert.assertTrue(val);
	}

	@When("Select Search one of subcategories and enter")
	public void select_Search_one_of_subcategories_and_enter() {

		robot("HOME", 1);

		robot("TAB", 22);

		robot("DOWNARROW", 1);

		robot("TAB", 3);

		robot("ENTER", 1);

		sleep(3);

	}

	@When("Unselect Search in product description and select subCatogory then press Enter")
	public void unselect_Search_in_product_description_and_select_subCatogory_then_press_Enter() {

		robot("HOME", 1);

		robot("TAB", 23);

		robot("SPACE", 1);

		robot("TAB", 2);

		robot("ENTER", 1);

	}

}
