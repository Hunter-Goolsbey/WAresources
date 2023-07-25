import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class SeleniumConfig {
  public static WebDriver driverSetup() {
	  System.setProperty("webdriver.chrome.driver", "/Users/The-Intern/Downloads/chromedriver");
	  ChromeOptions options = new ChromeOptions();
	  
	  //options.addArguments("-headless");
	  options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
	  
	  WebDriver driver = new ChromeDriver(options);
	  
	  driver.manage().window().maximize();
	  
	  return driver;
		
  }
}
