package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	// This method return a WebDriver object
	public static WebDriver open(String browserType) {
		if (browserType.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "/Users/smyung/Documents/software/geckodriver");
			return new FirefoxDriver();
		//} else if (browserType.equalsIgnoreCase("IE")) {
		//	System.setProperty("webdriver.ie.driver", "/Users/smyung/Documents/software/IEDriverServer");
		//	return new InternetExploreDriver();			
		} else {
			System.setProperty("webdriver.chrome.driver", "/Users/smyung/Documents/software/chromedriver");;
			return new ChromeDriver();
		}

	} 

}
