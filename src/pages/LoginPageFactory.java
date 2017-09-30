package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
	
	// Define web elements at class level
	WebDriver driver; 
	
	@FindBy(id="MainContent_txtUserName")
	WebElement usernameBox;
	
	@FindBy(id="MainContent_txtPassword")
	WebElement passwordBox;
	
	@FindBy(id="MainContent_btnLogin")
	WebElement loginButton;
	
	//Actions
	public void setUserName(String username) {
		usernameBox.sendKeys(username);
	}
	
	public void setPassword(String password) {
		passwordBox.sendKeys(password);
	}
	
	public void clickSubmit() {
		loginButton.click();
	}
	
	//Actions 
	public void login(String username, String password) {
		setUserName(username);
		setPassword(password); 
		clickSubmit();
	}
	
	// Constructor initializes the state of the driver 
	public LoginPageFactory(WebDriver driver) {
		this.driver = driver; 
		
		//Initialize web elements
		//This method will quick start all of these elements to now be available at the class level  
		PageFactory.initElements(driver, this);
	}

}
