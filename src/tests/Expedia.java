package tests;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Expedia {
	WebDriver driver; 
	String browserType = "chrome"; 
	String city = "New York, NY";
	String checkIn = "10/02/2017"; 
	String checkOut = "10/03/2017";
	String numberOfGuest = "2";
	String starRating = "star4";
	String searchResult = "1"; 
	
	@Test
	public void hotelReservation() throws InterruptedException {
		// 1. Search 
		driver.findElement(By.id("tab-hotel-tab-hp")).click();
		driver.findElement(By.id("hotel-destination-hp-hotel")).clear();
		driver.findElement(By.id("hotel-destination-hp-hotel")).sendKeys(city);
		driver.findElement(By.id("hotel-checkin-hp-hotel")).clear();
		driver.findElement(By.id("hotel-checkin-hp-hotel")).sendKeys(checkIn);
		driver.findElement(By.id("hotel-checkout-hp-hotel")).clear();
		driver.findElement(By.id("hotel-checkout-hp-hotel")).sendKeys(checkOut);
		new Select(driver.findElement(By.xpath("//*[@id=\"gcw-hotel-form-hp-hotel\"]/div[4]/div[4]/label/select"))).selectByValue(numberOfGuest);
		driver.findElement(By.xpath("//*[@id=\"gcw-hotel-form-hp-hotel\"]/div[9]/label/button")).click();
		
		// Print the name of the city 
		String actualCity = driver.findElement(By.xpath("//*[@id='hotelResultTitle']/h1")).getText();
		System.out.println("CITY: " + actualCity);
		
		// 2. Modify the search results page, give criteria
		driver.findElement(By.cssSelector("input[name='star'][id='" + starRating +"']")).click();
		
		// 3. Analyze the results and make our selection 
		TimeUnit.SECONDS.sleep(5); //Test fails without time delay. 
		driver.findElement(By.xpath("//*[@id=\"resultsContainer\"]/section/article[" +searchResult + "]/div[2]/div/a")).click();
		
		// Switch the window to the pop
		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(1));
		
		// Print hotel name and star rating
		String hotelName = driver.findElement(By.id("hotel-name")).getText(); 
		//String hotelRating = driver.findElement(By.cssSelector("span[class='rating-nuumber']")).getText();
		System.out.println("HOTEL: " + hotelName);
		//System.out.println("RATING: " + hotelRating);
		
		
		// 4. Book reservation 
		driver.findElement(By.xpath("//*[@id='rooms-and-rates']/div/article/table/tbody[1]/tr[1]/td[5]/div/div[1]/button")).click();
		
		driver.findElement(By.id("pay-later-button")).click();
		
		String hotelPrice = driver.findElement(By.cssSelector("span[class='amount-value']")).getText();
		System.out.println("PRICE: " + hotelPrice);
		
		
		// 5. Fill out contact / billing 
		
		
		// 6. Get confirmation
		String pageTitle = driver.getTitle(); 
		Assert.assertTrue(pageTitle.contains("Payment"));
	}
	
	@BeforeMethod
	public void setUp() {
		driver = utilities.DriverFactory.open(browserType);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.expedia.com/");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
