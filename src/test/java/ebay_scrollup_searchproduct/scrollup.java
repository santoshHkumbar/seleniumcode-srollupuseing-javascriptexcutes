package ebay_scrollup_searchproduct;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class scrollup {
	WebDriver driver;
	
	
	 @BeforeTest
	 public void bt() {
		 //open the website 
		 WebDriverManager.chromedriver().setup();
		 //open with Chrome browser
		 driver = new ChromeDriver();
		 //Visiting the application
		 driver.get("https://www.ebay.com/");
		 //window to be maximize
		 driver.manage().window().maximize();	

}
	 
	 @Test(alwaysRun = true)
	 public void signup() throws InterruptedException {
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 //search the product in placeholder
		 driver.findElement(By.cssSelector("[class='gh-tb ui-autocomplete-input']")).sendKeys("shoes");
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 //search button click the product in side the placeholder
		 driver.findElement(By.cssSelector("[type='submit']")).click();
		 //scroll down
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		//calling the method 
		 js.executeScript("window.scrollBy(0,2000)");
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 js.executeScript("window.scrollBy(0,2000)");
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 js.executeScript("window.scrollBy(0,3000)");
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 js.executeScript("window.scrollBy(0,5000)");
		 //scroll up
		 js.executeScript("window.scrollBy(0,-5000)");
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 js.executeScript("window.scrollBy(0,-3000)");
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 js.executeScript("window.scrollBy(0,-2000)");
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 js.executeScript("window.scrollBy(0,-2000)");
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//search box clr
		    WebElement clr = driver.findElement(By.cssSelector("[class='gh-tb ui-autocomplete-input']"));
		     clr.sendKeys(Keys.CONTROL+"a");
		     clr.sendKeys(Keys.BACK_SPACE);
		     
		     driver.navigate().back();
		     
	 }
	 @AfterTest
	 public void close() {
		 driver.close();
	 }
}
