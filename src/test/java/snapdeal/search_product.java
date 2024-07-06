package snapdeal;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class search_product {
	WebDriver driver;
	
	
	 @BeforeTest
	 public void bt() {
		 //open the website 
		 WebDriverManager.chromedriver().setup();
		 //open with Chrome browser
		 driver = new ChromeDriver();
		 //Visiting the application
		 driver.get("https://www.snapdeal.com/");
		 //window to be maximize
		 driver.manage().window().maximize();	

}
	 @Test(alwaysRun = true)
	 public void signup() throws InterruptedException {
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.findElement(By.xpath("(//input[@name='keyword' and @type='text'])[1]")).sendKeys("shoes");
		Thread.sleep(2000);
		//it is normal methods
		       //  driver.findElement(By.cssSelector("[class='searchformButton col-xs-4 rippleGrey']")).click();
		//it is javascript executor
		 JavascriptExecutor js = (JavascriptExecutor) driver;
	WebElement j=	 driver.findElement(By.cssSelector("[class='searchformButton col-xs-4 rippleGrey']"));
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].click();",j);
//		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 }
	 @AfterTest
	 public void colse() {
		 driver.close();
	 }
}
