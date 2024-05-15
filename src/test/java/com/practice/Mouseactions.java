package com.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mouseactions {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		  WebDriver driver = new ChromeDriver();
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		  driver.get("https://testrigor.com/certification/clicks/#");
		  driver.manage().window().maximize();
		  WebElement aitesting = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text() = 'AI Testing']/..")));
		  WebElement option =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text() = 'AI In Software Testing']")));
		  Actions action = new Actions(driver);
		  action.moveToElement(aitesting).click().build().perform();
		  
		  Action mouseclick =action.moveToElement(option).click().build();
		  if(option.isDisplayed()) {
			  mouseclick.perform();
		  }
		  

	}

}
