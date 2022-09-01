package com.trello.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.trello.qa.listeners.WebEventListener;
import com.trello.qa.utils.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	public TestBase() {

		try {
			prop = new Properties();
			FileInputStream fp = new FileInputStream(
					"C:\\Users\\LENOVO\\git\\repository\\TrelloTestAutomation\\src\\main\\java\\com\\trello\\qa\\config\\config.properties");

			prop.load(fp);

			// return prop;

		} 
		
		catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	} 	 	
	

	public static void initialization() {
		String browserName = prop.getProperty("browser");
		//System.out.println("Browser Name is " + browserName);
		
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Browser Name is " + browserName);
		}
		else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			//System.out.println("Browser Name is " + browserName); 

		}
		
		
		driver.manage().window().maximize();
		EventHandlerInit();

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.Page_Load_TimeOut));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		
		driver.get(prop.getProperty("url"));

		//return driver;
	}@SuppressWarnings("deprecation")
	public static void EventHandlerInit()
	{
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
	}
	
		

	
	

}
