package page;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;



public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// Element Liberary
	@FindBy(how = How.ID, using = "username") WebElement USER_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id='password']") WebElement PASSWORD_ELEMENT;
	@FindBy(how = How.XPATH, using = "//button[contains(text(), 'Sign in')]") WebElement SIGNIN_BUTTON_ELEMENT;
	@FindBy(how=How.XPATH,using="//h2[contains(text(),' Dashboard ')]")WebElement DASHBOARD;
	
	//Interactive methods
	public void enterUserName(String username) {
		USER_NAME_ELEMENT.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		PASSWORD_ELEMENT.sendKeys(password);
	}
	public void enter_credentials(String username, String passwoard) {
		USER_NAME_ELEMENT.sendKeys(username);
		PASSWORD_ELEMENT.sendKeys(passwoard);
	}
	public void clickSigninButton() {
		SIGNIN_BUTTON_ELEMENT.click();
	}
	
	public void validete_dashboard() {
		
		String DashBoard = DASHBOARD.getText();
	Assert.assertEquals(DashBoard, "Dashboard");
	
	
	}
	
	public String getPageTitle() {
		  return driver.getTitle();
		 }
	public  void takeScreenshotAtEndOfTest(WebDriver driver) throws IOException {
		  TakesScreenshot ts = ((TakesScreenshot) driver);
		  File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		  String currentDir = System.getProperty("user.dir");
		  FileUtils.copyFile(sourceFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

}
