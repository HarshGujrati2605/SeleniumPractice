package com.practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeOptionsSetup {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized"); // start with full screen
		options.addArguments("--incognito"); // open in incognito mode
	//	options.setBinary("122"); // Select binary for 122
	//	options.setBrowserVersion("122"); // Select browser version of 122
	//	options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.get("https://demo.automationtesting.in/Windows.html");
		driver.quit();

		
	}

}
