import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;


public class TestHome {
	SeleniumConfig SelenSetup = new SeleniumConfig();
			
  @Test
  public void test_Home_isCollapsed() throws InterruptedException {
	  WebDriver driver = SelenSetup.driverSetup();
	  driver.get("http://34.193.84.77:8080/MavenWebProject/Home.html");
	  driver.findElement(By.xpath("/html//div[@id='accordion']//a[@href='#collapseOne']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("/html//div[@id='accordion']//a[@href='#collapseOne']")).click();
	  assertEquals(driver.findElement(By.xpath("/html//div[@id='accordion']//a[@href='#collapseOne']")).getAttribute("class"), "btn collapsed");
	  driver.quit();
  }
  
  @Test
  public void Test_NavMenu_isHidden() {
	  WebDriver driver = SelenSetup.driverSetup();
	  driver.get("http://34.193.84.77:8080/MavenWebProject/Home.html");
	  assertFalse(driver.findElement(By.cssSelector(".offcanvas-title")).isDisplayed());
	  driver.findElement(By.cssSelector("[data-bs-toggle='offcanvas']")).click();
	  driver.quit();
  }
  
  @Test
  public void Home_Redirects_Home() {
	  WebDriver driver = SelenSetup.driverSetup();
	  driver.get("http://34.193.84.77:8080/MavenWebProject/Home.html");
	  driver.findElement(By.xpath("//div[@id='collapsibleNavbar']/ul[@class='navbar-nav']//a[@href='Home.html']")).click();
	  assertEquals(driver.getCurrentUrl(), "http://34.193.84.77:8080/MavenWebProject/Home.html");
	  driver.quit();
  }
}