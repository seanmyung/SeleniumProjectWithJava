package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {

	public static void main(String[] args) {
		// 1. Create WebDriver
		System.setProperty("webdriver.gecko.driver", "/Users/smyung/Documents/software/geckodriver");
		WebDriver driver = new FirefoxDriver();
		
		// 2. Open Browser and navigate to Account Management Page >> Click on Create Account
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		driver.findElement(By.linkText("Create Account")).click();
		
		// 3. Fill out the form 
		
			// How to locate elements
			driver.findElement(By.name("ctl00$MainContent$txtFirstName")).sendKeys("Mary Smith");
			driver.findElement(By.id("MainContent_txtEmail")).sendKeys("ms@testeamil.com");
			driver.findElement(By.xpath("//*[@id='MainContent_txtHomePhone']")).sendKeys("9788317832");//rel XPath
			
			driver.findElement(By.cssSelector("input[id='MainContent_txtPassword']")).sendKeys("mspass");
			driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword")).sendKeys("mspass");

			// How to interact with other HTML elements 
			driver.findElement(By.id("MainContent_Female")).click();
			driver.findElement(By.cssSelector("input[name='ctl00$MainContent$Gender'][value='Female']"));
			
			new Select(driver.findElement(By.id("MainContent_menuCountry"))).selectByVisibleText("United States");
			
			driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail")).click();
			driver.findElement(By.id("MainContent_btnSubmit")).click();
		
		// 4. Get confirmation 
		String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
		System.out.println("CONFIRMATION: " + conf);
			
		// 5. Close the browser
		driver.close();
	}	
}
