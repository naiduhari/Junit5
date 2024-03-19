package org.opencart;

import java.time.Duration;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class OpenCart {

	WebDriver driver;

	@Before
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@Test
	public void launchOpencart()  {
		driver.get("https://naveenautomationlabs.com/opencart");
		// verify successful application launch
		Assert.assertEquals("Your Store", "Your Store");
		System.out.println("Ecpected Your Store page is open");
		
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement account = driver.findElement(By.linkText("My Account"));
		account.click();

		// verify Account Login page
		Assert.assertEquals("AccountLogin", "AccountLogin");
		System.out.println("AccountLogin page is opened");

		
		WebElement ele = driver.findElement(By.linkText("Register"));
		ele.click();
	
	    //register to cart
		driver.findElement(By.name("firstname")).sendKeys("hari");
		driver.findElement(By.name("lastname")).sendKeys("krishna");
		driver.findElement(By.name("email")).sendKeys("harii@gmail.com");
		driver.findElement(By.name("telephone")).sendKeys("123456895");
		driver.findElement(By.name("password")).sendKeys("hari@123");
		driver.findElement(By.name("confirm")).sendKeys("hari@123");
		driver.findElement(By.name("agree")).click();

		
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		System.out.println("successful registered");
		
		//login into cart
		driver.findElement(By.linkText("login page")).click();
		driver.findElement(By.name("email")).sendKeys("harii@gmail.com");
		driver.findElement(By.name("password")).sendKeys("hari@123");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
	    

		WebElement compomenets = driver.findElement(By.linkText("Components"));
		compomenets.click();

		WebElement monitors = driver.findElement(By.xpath("//a[normalize-space()='Monitors (2)']"));
		monitors.click();

		// verify Monitors page
		Assert.assertEquals("Monitors", "Monitors");
		System.out.println("Monitors page is opened");

		// add Apple Cinema 30" to the cart
		WebElement apple = driver.findElement(By.xpath("(//span[contains(text(),'Add to Cart')])[1]"));
		apple.click();

		// verify Apple cinima 30 page
		Assert.assertEquals("Apple Cinema 30", "Apple Cinema 30");
		System.out.println("Apple Cinima 30 page is opened");
		
		
		//scroll down page
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,500)");
		 
		 js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		 //
		 driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		 driver.findElement(By.id("input-option208")).sendKeys("Apple");
		 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		 WebElement drop=driver.findElement(By.id("input-option217"));
		 Select sel = new Select(drop);
		 sel.selectByIndex(1);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		 driver.findElement(By.id("input-option209")).sendKeys("Apple Cinima 30");
		 
		 driver.findElement(By.id("button-upload222")).sendKeys("E:\\hanuman pcs\\hanuman.jpg");
		 System.out.println("sucessfilly uploaded");
		 
		 //date picking
		driver.findElement(By.name("option[219]")).clear();
		driver.findElement(By.xpath("//input[@id='input-option219']")).sendKeys("2024-04-19");
		 
		driver.findElement(By.name("option[221]")).clear();
		driver.findElement(By.xpath("//input[@id='input-option221']")).sendKeys("07:07");
		
		driver.findElement(By.name("quantity")).clear();
		driver.findElement(By.xpath("//input[@id='input-quantity']")).sendKeys("4");
		
		driver.findElement(By.id("button-cart")).click();
		
		 
		 

	}

}
