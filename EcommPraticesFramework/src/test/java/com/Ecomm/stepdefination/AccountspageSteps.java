package com.Ecomm.stepdefination;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.Ecomm.factory.DriverFactory;
import com.Ecomm.pages.AccountsPage;
import com.Ecomm.pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountspageSteps {

	private AccountsPage accountpage;
	private LoginPage loginPage= new LoginPage(DriverFactory.getDriver());

	@Given("user has already logged into application")
	public void user_has_already_logged_into_application(DataTable credTable) {
	   List<Map<String,String>> credlist=credTable.asMaps();
	   String userName= credlist.get(0).get("username");
	   String password=credlist.get(0).get("password");
	   
	   DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	   
	   accountpage=loginPage.doLogin(userName,password);
	}
@Given("user is on Account page")
public void user_is_on_account_page() {
   String title= accountpage.getAccountsPageTitle();
   System.out.println("Title of the page is : "+ title);
   
}


@Then("user gets accounts section")
public void user_gets_accounts_section(DataTable sectionsTable) {
	List<String> expectedSectionList = sectionsTable.asList();
	System.out.println(expectedSectionList);
	List<String> actualSectionList=accountpage.getAccountSectionList();
	System.out.println(actualSectionList);
	
	Assert.assertTrue(expectedSectionList.containsAll(actualSectionList));
}

@Then("account section count should be {int}")
public void account_section_count_should_be(Integer expectedsectioncount) {
	Assert.assertTrue(accountpage.getAccountSectionCount()==expectedsectioncount);
	
}

}
