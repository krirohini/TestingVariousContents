package com.sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ImageColor {

	private WebDriver driver = null;

	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();
	//	driver.manage().window().maximize();
	//	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("http://www.guru99.com/jira-tutorial-a-complete-guide-for-beginners.html");
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

	@Test
	public void imageColorValue() {
		String color = driver.findElement(By.xpath(".//*[@id='rt-mainbody']/div/article/div/p[30]/a/img"))
				.getCssValue("color");
		System.out.println("Value of color  "+color);

		String[] hexValue = color.replace("rgba(", "").replace(")", "").split(",");

		int hexValue1 = Integer.parseInt(hexValue[0]);
		hexValue[1] = hexValue[1].trim();
		
		int hexValue2 = Integer.parseInt(hexValue[1]);
		hexValue[2] = hexValue[2].trim();
		
		int hexValue3 = Integer.parseInt(hexValue[2]);

		String actualColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);

		Assert.assertEquals("#70bdcd", actualColor);
	}

}
