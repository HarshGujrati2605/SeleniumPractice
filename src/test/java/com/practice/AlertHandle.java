package com.practice;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertHandle {

	public static void main(String[] args) {
		  WebDriver driver = new ChromeDriver();
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		  driver.get("https://demo.automationtesting.in/Alerts.html");
		  driver.manage().window().maximize();
		  WebElement clickbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn.btn-danger")));
		  clickbtn.click();
		  Alert alertinpage =driver.switchTo().alert();
		  System.out.println(alertinpage.getText());
		  alertinpage.accept();
		  driver.close();
		  
		  
	}

}
