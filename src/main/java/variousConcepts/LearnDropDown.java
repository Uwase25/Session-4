package variousConcepts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LearnDropDown {

	WebDriver driver;

	@Before
	public void init() { // initialization

		// setting up the property
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");

		// creating web driver instance
		driver = new ChromeDriver();

		// get to the site
		driver.get("https://techfios.com/billing/?ng=admin/");

		// maximizing the browser
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void loginTest() throws InterruptedException {

	
		
		// Identifying the username field pass username
		WebElement USERNAME_FIELD_ELEMENT = driver.findElement(By.xpath("//input[@id='username']"));

		// Identifying the password field pass password
		WebElement PASSWORD_FIELD_ELEMENT = driver.findElement(By.xpath("//input[@id='password']"));

		// Identifying the sign in button and click
		WebElement SIGNIN_BUTTON_ELEMENT = driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/button"));

		USERNAME_FIELD_ELEMENT.clear();
		USERNAME_FIELD_ELEMENT.sendKeys("demo@techfios.com");

		PASSWORD_FIELD_ELEMENT.clear();
		PASSWORD_FIELD_ELEMENT.sendKeys("abc123");

		SIGNIN_BUTTON_ELEMENT.click();

		WebElement DASHBOAD_BUTTON_ELEMENT = driver.findElement(By.linkText("Dashboard"));
		WebElement CUSTOMERS_BUTTON_ELEMENT = driver.findElement(By.xpath("//ul[@id='side-menu']/li[3]/a/span[1]"));
		WebElement ADD_CUSTOMERS_BUTTON_ELEMENT = driver
				.findElement(By.xpath("//ul[@id='side-menu']/li[3]/ul/li[1]/a"));

		// System.out.println(DASHBOAD_BUTTON_ELEMENT.getText()); // to print in console

		Assert.assertEquals("Dashboard page not found", "Dashboard", DASHBOAD_BUTTON_ELEMENT.getText()); // for
																											// validation

// always validate if possible

		CUSTOMERS_BUTTON_ELEMENT.click();
		ADD_CUSTOMERS_BUTTON_ELEMENT.click();

		WebElement FULLNAME_FIELD_ELEMENT = driver.findElement(By.xpath("//input[@id='account']"));
		Thread.sleep(3000);

		WebElement DROPDOWN_FIELD_ELEMENT = driver.findElement(By.xpath("//Select[@id='cid']"));

		FULLNAME_FIELD_ELEMENT.sendKeys("JU");
		
		Select sel = new Select(DROPDOWN_FIELD_ELEMENT);
		sel.selectByVisibleText("Techfios");
		
		// option to select all of them
		List<WebElement> options= sel.getOptions();
		
		// to print them in console we use ForEach loop
		for(WebElement i: options) {
			System.out.println(i.getText());  //all the list will come to console
		}
		
	}

	
	
	
	 @After
	public void tearDiwn() {
		driver.close();
		driver.quit();
	}

}
