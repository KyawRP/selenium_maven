package com.sddevops.selenium_maven.eclipse_new;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTest {
	public String baseUrl = "https://www.rp.edu.sg/";
	String driverPath = "D:\\Courses\\Republic Poly\\Temp\\chromedriver.exe";
	//String driverPath = "D:\\Courses\\Republic Poly\\Temp\\edgedriver_win64\\msedgedriver.exe";
	//declare Selenium WebDriver
	public WebDriver webDriver;
		
	 @Test
	 public void checkTitle() {
		  //Load Republic Poly Website as A New Page
		  webDriver.navigate().to(baseUrl);
		  
		  //Assert the Title to Check that We are Indeed in the Correct WebSite
		  Assert.assertEquals(webDriver.getTitle(),"Home");
		  System.out.println("tile: "+ webDriver.getTitle());
		  
		  //Retrieve explore now button using it's class name and click on it
		  webDriver.findElement(By.className("green-btn")).click();
		  
		  //Assert the Title to Check that We are Indeed in the Correct WebSite
		  Assert.assertTrue(webDriver.getTitle().contains("RP20"));
		  System.out.println("new tile: "+ webDriver.getTitle());
	  }
	
	 @Test
	 public void findById() {
		//Load Republic Poly Website as A New Page
		webDriver.navigate().to(baseUrl);
		//WebElement we  = webDriver.findElement(By.id("RP20th Anniversary - Celebrating with Gratitute"));
		WebElement we  = webDriver.findElement(By.id("content"));
		
		Assert.assertEquals(we.getAttribute("role"),"toolbar");
		System.out.println("Id We: "+ we.getAttribute("role"));
	}
	
	@Test 
	public void findByName() {
	      //Load republic poly website as a new page
	      webDriver.navigate().to(baseUrl);   
	      WebElement webElement = webDriver.findElement(By.name("keywords"));

	      Assert.assertTrue(webElement.getAttribute("content").contains("Republic Polytechnic"));
	      System.out.println("role: "+webElement.getAttribute("content"));
	  }
	 
	 @Test
	 public void testHomeSearch() {
		//Load Republic Poly Website as A New Page
		webDriver.navigate().to(baseUrl);
		WebElement icon  = webDriver.findElement(By.className("collapsed"));
		icon.click();
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement we  = webDriver.findElement(By.className("homesearch"));
		we.sendKeys("devops");
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		we.sendKeys(Keys.ENTER);
	}
	 
	@Test 
	public void findByCssSelector() {
		
		//Load Republic Poly Website as A New Page
		webDriver.navigate().to(baseUrl);
		WebElement we = webDriver.findElement(By.cssSelector("img[title=\"RP20 Anniversary\"]"));
		
		Assert.assertTrue(we.getAttribute("title").contains("RP20 Anniversary"));
		System.out.println("title: "+ we.getAttribute("title"));
	}
	 
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		webDriver = new ChromeDriver();
	}

	@AfterTest
	public void afterTest() {
		webDriver.quit();
	}
}
