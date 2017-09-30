package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class NewAccount {

	public static void main(String[] args) {
		String name = "Mary Smith";
		String email = "ms@testeamil.com";
		String password = "mspass";
		String country = "United States"; 
		String phoneNumber = "9788317832";
		String browserType = "chrome"; 
		String gender = "Female";
		boolean weeklyEmail = true;
		boolean monthlyEmail = false;
		boolean occassionalEmail = false; 

		// Define WebDriver
		WebDriver driver;
		driver = utilities.DriverFactory.open(browserType); 
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		driver.findElement(By.xpath("html/body/form/div[3]/div[2]/div/div[2]/a")).click();
		
		// Define web elements
		WebElement nameElement = driver.findElement(By.name("ctl00$MainContent$txtFirstName"));
		WebElement emailElement = driver.findElement(By.id("MainContent_txtEmail"));
		WebElement phoneElement =driver.findElement(By.xpath("//*[@id='MainContent_txtHomePhone']"));
		WebElement passwordElement = driver.findElement(By.cssSelector("input[id='MainContent_txtPassword']"));
		WebElement verifyPasswordElement = driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword"));
		WebElement countryElement = driver.findElement(By.id("MainContent_menuCountry"));
		WebElement maleRadio = driver.findElement(By.name("ctl00$MainContent$Gender"));
		WebElement femaleRadio = driver.findElement(By.id("MainContent_Female"));
		WebElement weeklyCheckbox = driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail"));
		WebElement submitButton = driver.findElement(By.id("MainContent_btnSubmit"));
		
		// 3. Fill out the form 
		nameElement.sendKeys(name);
		emailElement.sendKeys(email);
		phoneElement.sendKeys(phoneNumber);//rel XPath
		passwordElement.sendKeys(password);
		verifyPasswordElement.sendKeys(password);
		new Select(countryElement).selectByVisibleText(country);
		
		// Gender Radio Button
		if (gender.equalsIgnoreCase("Male")) {
			 maleRadio.click();
		} else {
			femaleRadio.click();
		}
		
		// Check Box Algorithm
		if (weeklyEmail == true){
			if(!weeklyCheckbox.isSelected()) {
				weeklyCheckbox.click();
			}
		} else {
			if (weeklyCheckbox.isSelected()){
				weeklyCheckbox.click();
			}
		}
	
		submitButton.click();
		
		// Get confirmation & Close Browser
		String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
		String expected = "Customer information added successfully"; 
		if(conf.contains(expected)) {
			System.out.println("CONFIRMATION: " + conf);
		} else {
			System.out.println("TEST FAILED");
		}
		
		driver.close();
	}	
}
