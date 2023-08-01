import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;

import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;


public class TestHome {
	//SeleniumConfig SelenSetup = new SeleniumConfig();
	WebDriver driver = SeleniumConfig.driverSetup();
	String home = "http://34.193.84.77:8080/MavenWebProject/Home.html";
	
	//Functionality has been removed from Home page
//  @Test
//  public void test_Home_isCollapsed() throws InterruptedException {
//	  WebDriver driver = SelenSetup.driverSetup();
//	  driver.get("http://34.193.84.77:8080/MavenWebProject/Home.html");
//	  driver.findElement(By.xpath("/html//div[@id='accordion']//a[@href='#collapseOne']")).click();
//	  Thread.sleep(2000);
//	  driver.findElement(By.xpath("/html//div[@id='accordion']//a[@href='#collapseOne']")).click();
//	  assertEquals(driver.findElement(By.xpath("/html//div[@id='accordion']//a[@href='#collapseOne']")).getAttribute("class"), "btn collapsed");
//	  driver.quit();
//  }
  
  @Test
  public void Test_NavMenu_isHidden() throws InterruptedException {
	  driver.get(home);
	  Thread.sleep(3000); //Needed
	  //driver.findElement(By.cssSelector("[data-bs-toggle='offcanvas']")).click();
	  //Thread.sleep(2000);
	  assertEquals("offcanvas offcanvas-end", driver.findElement(By.id("modal")).getAttribute("class"));
	  //driver.findElement(By.cssSelector("[data-bs-toggle='offcanvas']")).click();
  }
  
  @Test
  public void myGarage_Redirects_Home() throws InterruptedException {
	  //RM: WebDriver driver = SelenSetup.driverSetup();
	  driver.get(home);
	  Thread.sleep(1000);
	  driver.findElement(By.linkText("MyGarage")).click();
	  Thread.sleep(1000);
	  assertEquals(driver.getCurrentUrl(), home);
	  //driver.quit();
  }
  @Test
  public void searchGarage_Does_Reduce() throws InterruptedException {
	  int i = 0;
	  List<WebElement> searchResults;
	  int count = 0;
	  
	  //RM: WebDriver driver = SelenSetup.driverSetup();
	  driver.get(home);
	  Thread.sleep(1000);
	  
	  driver.findElement(By.cssSelector("[onkeyup]")).sendKeys("l");
	  Thread.sleep(2000);
	  
	  //Tests search result display count against back-end count
	  searchResults = driver.findElements(By.className("searchMe"));
	  
	  for (i = 0; i < searchResults.size(); ++i) {
		  if (searchResults.get(i).isDisplayed()) {
			  ++count;
		  }
	  }
	  assertEquals(2, count); //2 swap out with direct SQL COUNT query once tables are created
	  //RM: driver.quit();
  }
  
  @Test
  public void addVehicle_verifyInput() throws InterruptedException{
	  //WebDriver driver = SelenSetup.driverSetup();
	  driver.get(home);
	  Thread.sleep(1000);
	  driver.findElement(By.cssSelector("[data-bs-toggle='modal']")).click();
	  driver.findElement(By.cssSelector("[placeholder='VIN']")).sendKeys("5UXWX7C5*BA");
	  driver.findElement(By.cssSelector("input[name='remember']")).click();
	  Thread.sleep(3000);
	  //System.out.println(driver.findElement(By.cssSelector("#vehicleMake-info")).getText());
	  assertEquals("BMW",driver.findElement(By.cssSelector("#vehicleMake-info")).getText());
  }
  @AfterTest
  public void cleanup(){
  driver.quit();
  }
}