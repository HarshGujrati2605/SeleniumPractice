package com.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {

	public static void main(String[] args) {
		 WebDriverManager.chromedriver().setup();
		  WebDriver driver = new ChromeDriver();
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		  driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		  driver.manage().window().maximize();
		  String title = driver.getTitle();
		  WebElement dragableele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text() = 'Drag me to my target']/..")));
		  WebElement targetelement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text() = 'Drop here']/..")));
		  Actions action = new Actions(driver);
		  //action.clickAndHold(dragableele).dragAndDrop(dragableele, targetelement).build().perform();
		  action.clickAndHold(dragableele).moveToElement(targetelement).release(dragableele).build().perform();
          //action.dragAndDrop(dragableele, targetelement).build().perform();
		  driver.close();
	}   

}
