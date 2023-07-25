import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;

import org.testng.annotations.AfterTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;

public class NavigationSuite {
	SeleniumConfig SelenSetup = new SeleniumConfig();
	Test_Login logon = new Test_Login();
	WebDriver driver = SeleniumConfig.driverSetup();
	WebDriver logmein = Test_Login.Login(driver);
  @Test
  public void Test_Logo() {
	  driver = logmein;
	  driver.get("http://34.193.84.77:8080/MavenWebProject/Home.html");
	  driver.findElement(By.xpath("/html//nav/div/a[@href='Home.html']")).click();
	  assertEquals(driver.getCurrentUrl(), "http://34.193.84.77:8080/MavenWebProject/Home.html");
  }
  @Test
  public void Test_Home() {
	  WebDriver driver = SelenSetup.driverSetup();
  }
  
  @Test
  public void Test_ProfileButton() {
	  WebDriver driver = SelenSetup.driverSetup();
  }
}
