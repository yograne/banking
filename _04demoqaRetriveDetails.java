//Comment
package assignment;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class _04demoqaRetriveDetails {
	WebDriver driver;
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver","C:\\JavaSelenium\\Workspace\\webdrivertraining\\test\\resources\\chromedriver.exe");
		driver= new ChromeDriver ();
	}

	@Test
	public void retriveDetails() throws InterruptedException {
		driver.get("https://demoqa.com/automation-practice-form");
		driver.findElement(By.id("firstName")).sendKeys("Yogesh");
		driver.findElement(By.id("lastName")).sendKeys("Rane");
		Thread.sleep(2000);
		String fN = driver.findElement(By.id("firstName")).getAttribute("value");
		String lN = driver.findElement(By.id("lastName")).getAttribute("value");
		System.out.println(fN + " " + lN);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
