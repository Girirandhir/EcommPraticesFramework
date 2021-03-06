package com.Ecomm.stepdefination;

import org.junit.Assert;

import com.Ecomm.factory.DriverFactory;
import com.Ecomm.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	private LoginPage loginPage= new LoginPage(DriverFactory.getDriver());
	private String title;
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
	    DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title=loginPage.getLoginPageTitle();
		System.out.println("Page Title = "+title);
	    
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {
	   Assert.assertTrue(title.contains(expectedTitleName));
	}

	@Then("forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	    
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
	   loginPage.enterUserName(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String pwd) {
		loginPage.enterPassword(pwd);
	  
	}

	@When("user click on login button")
	public void user_click_on_login_button() {
		loginPage.clickOnLogin();
	   
	}

}
