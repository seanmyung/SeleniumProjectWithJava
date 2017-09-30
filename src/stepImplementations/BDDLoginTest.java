package stepImplementations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class BDDLoginTest {
	
	WebDriver driver;
	
	@Given("^user is on the login page$")
	public void user_is_on_the_login_page() {
		System.out.println("User is on the login page");
		// open driver 
		driver = utilities.DriverFactory.open("Chrome");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
	}
	
	@When("^user enters correct username and correct password$")
	public void user_enters_correct_username_and_correct_password() {
		System.out.println("User enters username and password");
		driver.findElement(By.id("MainContent_txtUserName")).sendKeys("tim@testemail.com");
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys("trpass");
		driver.findElement(By.id("MainContent_btnLogin")).click();
	}
	
	@When("^user enters email (.*)$")
	public void user_enters_username(String username) {
		System.out.println("TESTING: " + username);
		driver.findElement(By.id("MainContent_txtUserName")).sendKeys(username);
	}
	
	@And("user enters password (.*)$")
	public void user_enters_password(String password) {
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys("password");
		click_login();
	}
	
	//@And("user clicks login button")
	public void click_login() {
		driver.findElement(By.id("MainContent_btnLogin")).click();
	}
	
	@Then("^user gets confirmation$")
	public void user_gets_confirmation() {
		System.out.println("User gets confirmation");
		Assert.assertTrue(driver.findElement(By.id("conf_message")).getText().contains("success"));
		
	}
	
	@After
	public void tearDwon() {
		driver.quit();
	}
}
