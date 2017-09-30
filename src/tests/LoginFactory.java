package tests;

import org.openqa.selenium.WebDriver;

import pages.LoginPageFactory;

public class LoginFactory {
	
	String username = "tim@testemail.com"; 
	String password = "trpass"; 
	
	public void loginTestPageFactory() {
		// 1. Initialize driver 
		WebDriver driver = utilities.DriverFactory.open("firefox");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		
		// 2. Enter login 
		LoginPageFactory loginPage = new LoginPageFactory(driver);
		loginPage.login(username, password);
	}
}
