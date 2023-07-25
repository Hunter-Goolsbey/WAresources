import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;

import org.testng.annotations.AfterTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;

public class Test_Login {
	SeleniumConfig SelenSetup = new SeleniumConfig();
	static WebDriver driver = SeleniumConfig.driverSetup();
	static String UN = System.getenv("TEST_USER_BASIC");
	static String PW = System.getenv("TEST_PASS_BASIC");
	
	public static WebDriver Login() {
		driver.get("http://34.193.84.77:8080/MavenWebProject/");
		
		System.out.println("Entered webpage");
		
		//System.out.println((String)driver.getCurrentUrl());
		driver.findElement(By.cssSelector("[type='text']")).sendKeys(UN);
		driver.findElement(By.cssSelector("[type='password']")).sendKeys(PW);
		driver.findElement(By.cssSelector("[type='submit']")).click();
		return driver;
  }
	
	public static WebDriver Login(WebDriver drivr) {
		drivr.get("http://34.193.84.77:8080/MavenWebProject/");
		
		System.out.println("Entered webpage");
		
		//System.out.println((String)driver.getCurrentUrl());
		drivr.findElement(By.cssSelector("[type='text']")).sendKeys(UN);
		drivr.findElement(By.cssSelector("[type='password']")).sendKeys(PW);
		drivr.findElement(By.cssSelector("[type='submit']")).click();
		return drivr;
  }
}
