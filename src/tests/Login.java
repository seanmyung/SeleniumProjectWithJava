package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.DashboardPage;
import pages.LoginPage;

public class Login {
	
	@Test
	public void loginTestPOM() {

		// 1. Initialize driver 
		WebDriver driver = utilities.DriverFactory.open("firefox");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		
		// 2. Enter login infromation (Login Page)
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUserName("tim@testemail.com");
		loginPage.setPassword("trpass");
		loginPage.clickSubmit();
		
		// 3. Get Confirmation (Dashboard Page) 
		DashboardPage dashboardPage = new DashboardPage(driver); 
		String conf = dashboardPage.confirmationMessage(); 
		String title = dashboardPage.title(); 
		
		// Assertions
		Assert.assertTrue(conf.contains("success"));
		Assert.assertTrue(title.contains("Account"));
		
		// 4. Close the driver 
		driver.quit();
	}

}
