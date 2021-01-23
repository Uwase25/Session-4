package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnMouseHover {

	WebDriver driver;

	@Test
	public void launchBrowser() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://www.dell.com/en-us");
		// driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement PRODUCT_BUTTON_ELEMENT= driver.findElement(By.xpath("//button[@id='l1']"));
		WebElement NETWORK_BUTTON_ELEMENT= driver.findElement(By.xpath("//*[@id=\"l1_5\"]/span"));
		WebElement HOME_NETWORK_BUTTON_ELEMENT= driver.findElement(By.xpath("//*[@id=\"dell-masthead\"]/div[3]/nav/ul/li[1]/ul/li[8]/ul/li[1]/a/img"));

		// Mouse Hover: action is required to perform Mouse Hover
		Actions action= new Actions(driver);
		
		action.moveToElement(PRODUCT_BUTTON_ELEMENT).build().perform();
		action.moveToElement(NETWORK_BUTTON_ELEMENT).build().perform();
		HOME_NETWORK_BUTTON_ELEMENT.click();
		
		
}
}