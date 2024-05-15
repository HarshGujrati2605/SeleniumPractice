package com.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameSwitching {

	public static void main(String[] args) {
	      WebDriverManager.chromedriver().setup();
		  WebDriver driver = new ChromeDriver();
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		  driver.get("https://www.w3schools.com/html/html_iframe.asp");
		  driver.manage().window().maximize();
		  String title = driver.getTitle();
		  WebElement frame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("iframe[title = 'W3Schools HTML Tutorial']")));
		  driver.switchTo().frame(frame);
		  driver.findElement(By.linkText("CSS Tutorial")).click();
		  driver.switchTo().defaultContent();
		  System.out.println("Clicking the link present outside the  framw");
		  driver.findElement(By.linkText("JAVASCRIPT")).click();
		  driver.close();	  
	}

}
