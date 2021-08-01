package assignment;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class _02GeneralWebDriverAssignment {
	WebDriver driver;
  @Test
  public void webdDriverCommands() throws InterruptedException {
	  driver.get("https://www.wikipedia.org/");
	  Thread.sleep(2000);
	  driver.findElement(By.id("js-link-box-en")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//a[@title='Free content']")).click();
	  Thread.sleep(2000);
	  driver.navigate().back();
	  Thread.sleep(2000);
	  driver.navigate().refresh();
	  Thread.sleep(2000);
	  driver.navigate().forward();
	  Thread.sleep(2000);
	  driver.navigate().to("http://cookbook.seleniumacademy.com/Config.html");
	  Thread.sleep(2000);
	  WebElement dropdown= driver.findElement(By.name("make"));
	  Select makeDropDown = new Select(dropdown);
	  List<WebElement> allOptions = makeDropDown.getOptions();
	  int numOptions = allOptions.size();
	  System.out.println("All Make Options are :" + numOptions);
	  String pageTitle = driver.getTitle();
	  System.out.println("Page Title is : " + pageTitle);
	  List<WebElement> allLinks = driver.findElements(By.tagName("a"));
	  for(WebElement link:allLinks){
		  System.out.println(link.getText() +" " + link.getAttribute("href"));
	  }
	 Thread.sleep(2000);
	System.out.println(driver.manage().window().getSize());
	Dimension d = new Dimension(800, 400); 
	driver.manage().window().setSize(d);
	System.out.println(driver.manage().window().getSize());
	Thread.sleep(2000);
	driver.manage().window().maximize();
	Thread.sleep(2000);
	driver.manage().window().fullscreen();	
	Thread.sleep(2000);
	System.out.println(driver.manage().window().getSize());
	System.out.println(driver.getCurrentUrl());
	String pageSource =driver.getPageSource();
	System.out.println("Page Source = " + pageSource);
	System.out.println("Cookies :" + driver.manage().getCookies());
	System.out.println("Display = "+ driver.findElement(By.xpath("//input[@type ='submit']")).isDisplayed());
	Boolean enable = driver.findElement(By.xpath("//input[@type ='submit']")).isEnabled();
	System.out.println("Enabe = "+enable );
	System.out.println(driver.findElement(By.xpath("//input[@value ='Petrol']")).isSelected());
	driver.findElement(By.xpath("//input[@value ='Petrol']")).click();
	System.out.println(driver.findElement(By.xpath("//input[@value ='Petrol']")).isSelected());
	driver.navigate().to("https://www.google.com/");
	driver.findElement(By.xpath("//input[@name ='q']")).sendKeys("Selenium");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@name ='q']")).clear();
	driver.findElement(By.xpath("//input[@name ='q']")).sendKeys("Selenium jobs");
	driver.findElement(By.xpath("//input[@name ='q']")).submit();
	
	 
	  
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
