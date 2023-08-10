import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


public class TestHome {
	String location = System.getenv("SQLLOCATION");
	String pw = System.getenv("SQLJAVA");
	String result;
	String usr = "guest";
	String psw = "";
	
	//*Sets up driver instance and saves public variables*
	
	//SeleniumConfig SelenSetup = new SeleniumConfig();
	WebDriver driver = SeleniumConfig.driverSetup();
	String home = "http://34.193.84.77:8080/MavenWebProject/Home.jsp";

  private void login(String userN) {
	  driver.get("http://34.193.84.77:8080/MavenWebProject/");
	  driver.findElement(By.cssSelector("[type='text']")).sendKeys(userN);
	  driver.findElement(By.cssSelector("[type='password']")).sendKeys(userN);
	  driver.findElement(By.cssSelector("[type='password']")).sendKeys(Keys.RETURN);
  }
  private void login(String userN, String pass) {
	  driver.get("http://34.193.84.77:8080/MavenWebProject/");
	  driver.findElement(By.cssSelector("[type='text']")).sendKeys(userN);
	  driver.findElement(By.cssSelector("[type='password']")).sendKeys(pass);
	  driver.findElement(By.cssSelector("[type='password']")).sendKeys(Keys.RETURN);
  }
  
  private String SQLquery(String Stmt) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://" + "18.235.221.130" + ":3306/helloworld", "ducky", "roundabout");
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(Stmt);
		while (rs.next()) {
			result = rs.getString(3);
		}
		return result;
  }
  
  @Test
  public void NavMenu_isHidden() throws InterruptedException {
	  //*Tests to ensure modal navigation panel is closed on-load*
	  driver.get(home);
	  Thread.sleep(3000); //Needed
	  assertEquals("offcanvas offcanvas-end", driver.findElement(By.id("modal")).getAttribute("class"));
  }
  
  @Test
  public void myGarage_Redirects_Home() throws InterruptedException {
	  driver.get(home);
	  Thread.sleep(1000);
	  driver.findElement(By.linkText("MyGarage")).click();
	  Thread.sleep(1000);
	  assertEquals(driver.getCurrentUrl(), home);
  }
  
  @Test
  public void searchGarage_Does_Reduce() throws InterruptedException {
	  int i = 0;
	  List<WebElement> searchResults;
	  int count = 0;
	  
	  login("guest");
	  Thread.sleep(1000);
	  
	  driver.findElement(By.cssSelector("[onkeyup]")).sendKeys("ho");
	  Thread.sleep(2000);
	  
	  //Tests search result display count against back-end count
	  searchResults = driver.findElements(By.className("searchMe"));
	  
	  for (i = 0; i < searchResults.size(); ++i) {
		  if (searchResults.get(i).isDisplayed()) {
			  ++count;
		  }
	  }
	  assertEquals(1, count); //2 swap out with direct SQL COUNT query once tables are created
  }
  
  @Test
  public void addVehicle_verifyInput() throws InterruptedException{
	  driver.get(home);
	  Thread.sleep(1000);
	  driver.findElement(By.cssSelector("[data-bs-toggle='modal']")).click();
	  driver.findElement(By.cssSelector("[placeholder='VIN']")).sendKeys("5UXWX7C5*BA");
	  driver.findElement(By.cssSelector("input[name='remember']")).click();
	  Thread.sleep(3000);
	  assertEquals("BMW",driver.findElement(By.cssSelector("input#vehicleMake-info")).getAttribute("value"));
  }
  
  @Test
  public void login() throws InterruptedException, ClassNotFoundException, SQLException{
	  String userid;
	  login(usr);
	  Thread.sleep(1000);
	  driver.findElement(By.cssSelector("[data-bs-toggle='modal']")).click();
	  Thread.sleep(1000);
	  userid = driver.findElement(By.cssSelector("[class] [action] div:nth-child(8)")).getText().toString();
	  assertEquals(SQLquery("select * from UserCredentials where Username='" + usr + "'and Password='" + usr + "';"), userid);
  }
  
  @AfterTest
  public void cleanup(){
	  driver.quit();
  }
}