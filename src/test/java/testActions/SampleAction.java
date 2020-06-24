package testActions;

import org.openqa.selenium.By;

import testDriver.Shell;

public class SampleAction extends Shell{
	public static void sampleMethod() {
		driver.findElement(By.id("loginbutton")).click();
		log.info("clicked on login button  ");
	}
}
