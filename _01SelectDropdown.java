//
//My local chnages after second user changes
package assignment;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import static org.testng.Assert.*;

public class _01SelectDropdown {
	WebDriver driver;
  @Test
  public void herokuappDropDown() throws InterruptedException {
	  driver.get("https://the-internet.herokuapp.com/");
	  driver.findElement(By.cssSelector("[href='/dropdown']")).click();
	  WebElement dropdownList = driver.findElement(By.id("dropdown"));
	  Select dl = new Select(dropdownList);
	  List<WebElement> allOptions= dl.getOptions();
	  int numOfOption = dl.getOptions().size();
	  System.out.println("Number of Options are: "+numOfOption + "and they are: ");
	  for(WebElement oneOption : allOptions) {
		  System.out.println(oneOption.getText());
	  }
	  dl.selectByValue("2");
	  Thread.sleep(2000);
	  dl.selectByVisibleText("Option 1");
	  Thread.sleep(2000);
	  dl.selectByIndex(2);
	  Thread.sleep(2000);
	  String currentSelected = dl.getFirstSelectedOption().getText();
	  System.out.println("Selected value = " + currentSelected);
	  
	  //Compare drop-down list
		 List<String> expectedList =  new ArrayList<String>();
		 expectedList.add("Please select an option");
		 expectedList.add("Option 1");
		 expectedList.add("Option 21");
		 
		 List<String> actualList = new ArrayList<String>();
		 for(WebElement oneOption:allOptions){
			 actualList.add(oneOption.getText());
		 }
		 assertEquals(actualList,expectedList, "Actual missmatched");
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
