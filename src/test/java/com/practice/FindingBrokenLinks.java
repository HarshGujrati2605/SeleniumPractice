package com.practice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindingBrokenLinks {

	public static void verifyLinks(String linkUrl) {
		try {
			URL url = new URL(linkUrl);
			HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
			httpURLConnect.setConnectTimeout(5000);
			httpURLConnect.connect();
			if (httpURLConnect.getResponseCode() >= 400) {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage() + "is a broken link");
			} else {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());
			}
		} catch (Exception e) {
		}
	}

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new"); // running in headless mode , as UI will not be visibl
		WebDriver driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.get("https://apple.com");
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		System.out.println(links.size() + " links present on this page.");
		links.forEach(link ->{
			verifyLinks(link.getAttribute("href"));
		});
	}

}
