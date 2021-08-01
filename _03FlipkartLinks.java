package assignment;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class _03FlipkartLinks {
	 WebDriver driver;
  @Test
  public void flipkart() {
	  driver.get("https://www.flipkart.com/");
	  List<WebElement> flipkartLinks= driver.findElements(By.tagName("a"));
	  System.out.println("All links are : ");
/*	  for(WebElement oneLink: flipkartLinks){
		  System.out.println(oneLink.getText() + " " + oneLink.getAttribute("href"));
	  }*/
	  
	  for(int i=1; i<flipkartLinks.size();i++) {
		  System.out.println(flipkartLinks.get(i).getText() +" " + flipkartLinks.get(i).getAttribute("href"));
	  }
	  System.out.println("NumberofLinks are: " + flipkartLinks.size());
  }
  @BeforeClass
  public void beforeClass() {
	 System.setProperty("webdriver.chrome.driver", "C:\\JavaSelenium\\Workspace\\webdrivertraining\\test\\resources\\chromedriver.exe");
	  driver = new ChromeDriver();
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
