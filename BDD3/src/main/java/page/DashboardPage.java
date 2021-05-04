package page;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;



public class DashboardPage {
	
	WebDriver driver;
	BasePage basepage;
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		basepage = PageFactory.initElements(driver, BasePage.class);
	}

	// Element Liberary
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[2]/div/h2")
	WebElement DASHBOARD_VALIDATION_ELEMENT;
	
	//Interactive Method
	public void validateDashboard() {
		basepage.waitForElement(driver, 5, DASHBOARD_VALIDATION_ELEMENT);
		String dashBoardText = DASHBOARD_VALIDATION_ELEMENT.getText();
		Assert.assertEquals(dashBoardText, "Dashboard", "Wrong page!!");
		
	}
	
	
	
	

}
