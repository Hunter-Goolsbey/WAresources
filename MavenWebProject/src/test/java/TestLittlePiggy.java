import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

//This Class borrows from the following classes: [SeleniumConfig.java]

public class TestLittlePiggy {

	@Test
	public void Test_Piggy_Login() throws InterruptedException {
		Test_Login logMeIn = new Test_Login();
		WebDriver driver = logMeIn.Login();
		assertEquals((String)driver.getCurrentUrl(), "http://34.193.84.77:8080/MavenWebProject/Home.html");
		driver.quit();
	}
	
}
