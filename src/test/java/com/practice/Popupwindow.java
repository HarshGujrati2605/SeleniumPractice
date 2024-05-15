package com.practice;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Popupwindow {

	public static void main(String[] args) throws Exception {

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
		driver.findElement(By.linkText("Open New Seperate Windows")).click();
		Thread.sleep(4000);
		driver.findElement(By.cssSelector("#Seperate .btn")).click();
		Set<String> handles = driver.getWindowHandles();
//		  System.out.println(handles.toString());
		Iterator iter = handles.iterator();
		while (iter.hasNext()) {
			String window = (String) iter.next();
			System.out.println(window);
			if (!window.equalsIgnoreCase(currentwindowhandle)) {
				driver.switchTo().window(window).manage().window().maximize(); // switch to window than maximise it.
	      break;
			}
		}
		WebElement heading = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text() = 'Getting Started']")));
		System.out.println(heading.getText());
		String actualText = heading.getText();
		if(actualText.equals("Getting Started")) {
			System.out.println("Heading is similar");
		}
		else {
			throw new Exception("Heading is not similar hence test case failed!!");
		}
		driver.quit();
	}

}
