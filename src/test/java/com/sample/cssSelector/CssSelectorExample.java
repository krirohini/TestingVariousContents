package com.sample.cssSelector;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CssSelectorExample {

	protected WebDriver driver = null;

	@BeforeMethod
	public void beforeMethod() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://weather.com/weather/monthly/l/95128:4:US");
	}

	@Test
	public void f() {
		driver.findElement(By.cssSelector("#id"));
	}

	@AfterMethod
	public void afterMethod() {
	}

}
