package com.practice;

import java.awt.Point;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CoordinatesOfElements {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		  WebDriver driver = new ChromeDriver();
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		  driver.get("https://testrigor.com/certification/clicks/#");
		  driver.manage().window().maximize();
		  WebElement aitesting = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text() = 'AI Testing']/..")));
	      org.openqa.selenium.Point classname = aitesting.getLocation();
	      int x  = classname.getX();
	      int y = classname.getY();
	      System.out.println(x + " " + y);
	      new Actions(driver).moveToElement(aitesting).moveByOffset(x, y).click();
	}

}
