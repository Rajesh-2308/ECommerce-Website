package com.Sauce.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseClass {

	public static WebDriver driver;

	@BeforeMethod
	public void startDriver() throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream("C:\\Users\\91637\\eclipse-workspace\\ECommerce_Website\\src\\test\\resources\\Config.properties"));
		String browser = properties.getProperty("browser");
		switch (browser) {
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			driver = new ChromeDriver(options);
			break;
		case "firefox":
			FirefoxOptions options2 = new FirefoxOptions();
			options2.addArguments("-private");
			driver = new FirefoxDriver(options2);
			break;
		case "edge":
			EdgeOptions options3 = new EdgeOptions();
			options3.addArguments("-inprivate");
			driver = new EdgeDriver(options3);
			break;
		default:
			System.out.println("Invalid browser name");
			break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(properties.getProperty("URL"));
	}

	@AfterMethod
	public void stopDriver() {
		driver.quit();
	}
	
	public void pageRefresh() {
		driver.navigate().refresh();
	}
	
	public void explicitWaitforAlert() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public WebElement explicitWaitforElement(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		return wait.until(ExpectedConditions.visibilityOf(ele));
	}

}
