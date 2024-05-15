package com.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scrolltoelement {

	public static void main(String[] args) throws InterruptedException {
		  WebDriver driver = new ChromeDriver();
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		  driver.get("https://en.wikipedia.org/wiki/Flipkart");
		  driver.manage().window().maximize();
		  WebElement awardandrecogheader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2 #Awards_and_recognition")));
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("arguments[0].scrollIntoView(true);", awardandrecogheader);
		  Thread.sleep(4000);
		  js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", awardandrecogheader);
		  Thread.sleep(2000);
		  driver.close();

	}

}
