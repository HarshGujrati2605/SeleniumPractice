package com.practice;

import java.time.Duration;
import java.util.List;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BootStrapDropdownsHandle {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized"); // start with full screen
		options.addArguments("--incognito"); // open in incognito mode
		WebDriver driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.get("https://demoqa.com/automation-practice-form");
		WebElement dropdownarrow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[text() = 'Select State']/ancestor::div[contains(@class, 'control')]//div[contains(@class , 'indicator')]")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", dropdownarrow);
		Thread.sleep(2000);
		dropdownarrow.click();
		List<WebElement> dropdownoptions = driver
				.findElements(By.xpath("//div[contains(@class , 'menu')]//div[contains(@id, 'option')]"));
//		dropdownoptions.forEach(element -> {
//			if (element.getText().contains("Rajasthan")) {
//				element.click();
//				
//			}
//			
//		});

		for (WebElement ele : dropdownoptions) {
			if (ele.getText().contains("NCR")) {
				ele.click();
				break;
			}

		}

	}
}
