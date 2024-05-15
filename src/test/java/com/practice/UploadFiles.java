package com.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFiles {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized"); // start with full screen
		options.addArguments("--incognito"); // open in incognito mode
		WebDriver driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
		WebElement fileupload = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#photo")));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", fileupload);
		Thread.sleep(2000);
		fileupload.sendKeys(System.getProperty("user.dir") +"\\src\\main\\resources\\core java notes.pdf");
		Thread.sleep(2000);
		driver.quit();
      

	}

}
