import org.junit.Assert.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;


//import static org.testng.Assert.assertTrue;

import org.junit.Test;

public class TestLittlePiggy {
	
	@Test
	public void tryMe() throws InterruptedException {
		String UN = System.getenv("TEST_USER_BASIC");
		String PW = System.getenv("TEST_PASS_BASIC");
		System.setProperty("webdriver.chrome.driver", "/Users/The-Intern/Downloads/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
		
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("http://34.193.84.77:8080/MavenWebProject/");
		driver.findElement(By.xpath("/html/body//form[@action='littlePiggy']/table//input[@name='username']")).sendKeys(UN);
		driver.findElement(By.xpath("/html/body//form[@action='littlePiggy']/table//input[@name='password']")).sendKeys(PW);
		driver.findElement(By.xpath("/html/body//form[@action='littlePiggy']/table//input[@value='login']")).click();
		Thread.sleep(3000);
		assertEquals((String)driver.getCurrentUrl(), "http://34.193.84.77:8080/MavenWebProject/Home.html");
		driver.close();
	}
	
	public void main (String[] args) throws InterruptedException {
		
				
		tryMe();
	}

}
