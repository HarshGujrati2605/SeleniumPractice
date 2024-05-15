package com.practice;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeSelenium {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		  WebDriverManager.chromedriver().setup();
		  WebDriver driver = new ChromeDriver();
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		  driver.get("https://demo.automationtesting.in/Windows.html");
		  driver.manage().window().maximize();
		  String title = driver.getTitle();
		  System.out.println(title);
		  String currentwindowhandle = driver.getWindowHandle();
		  System.out.println(currentwindowhandle);	
		  Thread.sleep(4000);
		  driver.findElement(By.cssSelector(".active.tab-pane .btn.btn-info")).click();
		  Set<String> handles = driver.getWindowHandles();
//		  System.out.println(handles.toString());
		  Iterator iter = handles.iterator();
		  while (iter.hasNext()) {
		    String window = (String) iter.next();
		      System.out.println(window);
		      if(!window.equalsIgnoreCase(currentwindowhandle)) {
		    	  driver.switchTo().window(window);
		    	  break;
		      }
		  }
		  
		  WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text() = 'Getting Started']")));
		  System.out.println(heading.getText());
		  driver.quit();
		  
		// handles.forEach((handle ) -> System.out.println(handle));
		  
	
	}

}
