package steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page.BasePage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class SetpDefs {
	
	WebDriver driver;
	LoginPage loginpage ;
	DashboardPage dashboard;
	//BasePage basepage;
	@Before
	public void befor_run() {
	driver =  BrowserFactory.init();
	loginpage = PageFactory.initElements(driver,LoginPage.class);
	dashboard = PageFactory.initElements(driver, DashboardPage.class);
	//basepage = PageFactory.initElements(driver, BasePage.class);
	}
	
	@Given("^User is on the techfios Login Page$")
	public void user_is_on_the_techfios_Login_Page() throws Throwable {
	    
	}
	

	@When("^User enters username as \"([^\"]*)\"$")
	public void user_enters_username_as(String username) throws Throwable {
		loginpage.enterUserName(username);
		
	}

	@When("^User enters password as \"([^\"]*)\"$")
	public void user_enters_password_as(String password) throws Throwable {
		loginpage.enterPassword(password);
	}
	@When("^User enters the \"([^\"]*)\"and\"([^\"]*)\"$")
	public void user_enters_the_and(String username, String passwoard) throws Throwable {
		
		loginpage.enter_credentials(username, passwoard);
	   	}
	
	@When("^User clicks on Signin Button$")
	public void user_clicks_on_Signin_Button() throws Throwable {
		loginpage.clickSigninButton();   
	}

	@Then("^User should be land on Dashbaord Page$")
	public void user_should_be_land_on_Dashbaord_Page() throws Throwable {
		
		  //loginpage.getPageTitle(); 
		String expectedTitle = "Dashboard- iBilling";
		  String actualTitle = loginpage.getPageTitle();
		  Assert.assertEquals(expectedTitle, actualTitle);
		 System.out.println("THis is the page Title :"+actualTitle);
		//loginpage.validete_dashboard();
		 loginpage.takeScreenshotAtEndOfTest(driver);
	}
	
	
}
