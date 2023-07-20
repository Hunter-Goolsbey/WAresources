//import static org.testng.AssertJUnit.assertEquals;
//import static org.testng.AssertJUnit.assertTrue;
//import org.testng.annotations.Test;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.By;
//import org.openqa.selenium.chrome.ChromeOptions;


//import static org.testng.Assert.assertTrue;


public class TestLittlePiggy {
	
//	@Test
//	public void tryMe() throws InterruptedException {
//		String UN = System.getenv("TEST_USER_BASIC");
//		String PW = System.getenv("TEST_PASS_BASIC");
//		System.setProperty("webdriver.chrome.driver", "/Users/The-Intern/Downloads/chromedriver");
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("-headless");
//		options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
//		
//		
//		WebDriver driver = new ChromeDriver(options);
//		//HtmlUnitDriver unitDriver = new HtmlUnitDriver(true);
//		driver.manage().window().maximize();
//		System.out.println("Started Selenium");
//		driver.get("http://34.193.84.77:8080/MavenWebProject/");
//		System.out.println("Entered webpage");
//		Thread.sleep(3000);
//		System.out.println((String)driver.getCurrentUrl());
//		driver.findElement(By.xpath("/html/body//form[@action='littlePiggy']/table//input[@name='username']")).sendKeys(UN);
//		driver.findElement(By.xpath("/html/body//form[@action='littlePiggy']/table//input[@name='password']")).sendKeys(PW);
//		driver.findElement(By.xpath("/html/body//form[@action='littlePiggy']/table//input[@value='login']")).click();
//		System.out.println("Passed Login");
//		Thread.sleep(3000);
//		assertEquals((String)driver.getCurrentUrl(), "http://34.193.84.77:8080/MavenWebProject/Home.html");
//		System.out.println((String)driver.getCurrentUrl());
//		driver.quit();
//		//driver.close();
//	}
	
	public void main (String[] args) throws InterruptedException {
		
		//tryMe();
	}

}
