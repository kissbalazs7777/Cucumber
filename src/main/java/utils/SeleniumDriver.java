package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumDriver {
	
	private static WebDriver driverSimple;
	private static EventFiringWebDriver driver;
	private static SeleniumDriver seleniumDriver;
	
	public SeleniumDriver() {
		WebDriverManager.chromedriver().setup();
		driverSimple = new ChromeDriver();
		
		driver = new EventFiringWebDriver(driverSimple);
		driver.register(new WebDriverWaitListener(driverSimple));
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public static void setup() {
		seleniumDriver = new SeleniumDriver();
	}
	
	public static void tearDown() {
		if(seleniumDriver != null) {
			driver.quit();
		}
		
		seleniumDriver = null;
		
	}
	
	public static WebDriver getDriver() {
		return driver;
	}

}
