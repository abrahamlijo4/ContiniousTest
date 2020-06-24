package utill;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import testDriver.Shell;

public class TestInitilization extends Shell {

	public static void testInitialization() {

		System.out.println("========================================================================================");
		System.out.println("                         Commencing Test Execution                                      ");
		System.out.println("========================================================================================");

		// initializing screenshot folder.
		utillClass.initializeScreenshotFolder();

		// ------Calling Driver Class
		log.info("Initiating Drivers");
		Browserinitialization();
	}

	public static void Browserinitialization() {

		// -------Getting BrowserName and URL from Property File
		browserName = prop.getProperty("browser");
		url = prop.getProperty("url");

		// -------Checking the Browser to be used and opening it
		if (browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"E:\\Work\\Java\\Selenium Java\\Selenium Web Drivers\\chromedriver83.exe");
			driver = new ChromeDriver();
			Shell.log.info("Chrome Browser Initialized Successfully");
		} else if (browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "E:\\Work\\eclipse-workspace\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			Shell.log.info("Firefox Browser Intialized Successfully");
		}

		// -------Setting default Browser Settings
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(UtilityClass.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(UtilityClass.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}

}
