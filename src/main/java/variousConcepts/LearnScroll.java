package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnScroll {

	WebDriver driver;

	@Before
	public void launchBrowser() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://techfios.com/billing/?ng=login/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void LoginTest() {

	
			WebElement USERNAME_FIELD_ELEMENT = driver.findElement(By.xpath("//input[@id='username']"));
			WebElement PASSWORD_FIELD_ELEMENT = driver.findElement(By.xpath("//input[@id='password']"));
			WebElement SIGNIN_BUTTON_ELEMENT = driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/button"));


			USERNAME_FIELD_ELEMENT.clear();
			USERNAME_FIELD_ELEMENT.sendKeys("demo@techfios.com");

			PASSWORD_FIELD_ELEMENT.clear();
			PASSWORD_FIELD_ELEMENT.sendKeys("abc123");
			SIGNIN_BUTTON_ELEMENT.click();
			
			// scroll
			JavascriptExecutor js= (JavascriptExecutor) driver;
			js.executeScript("scroll(0,700)");// how far scroll down
			
	}
}
