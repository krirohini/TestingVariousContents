package com.sample.dropdown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDownList {

	protected WebDriver driver = null;

	
	@BeforeMethod
	public void setup() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		// driver.manage().window().setSize(new Dimension(600, 400));
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://weather.com/weather/monthly/l/95128:4:US");
	}

	
	@Test
	public void getDropDownTest() {
		Select selectDropDown = new Select(driver.findElement(By.xpath(".//*[@id='month-picker']")));
		
		//selectDropDown.selectByValue("May 2017");
		//selectDropDown.selectByIndex(7);
		
		// Get all the option in a list
		List<WebElement> list = selectDropDown.getOptions();
		for(int i=0; i<list.size(); i++){
			String option = list.get(i).getText();
			System.out.print(option+"\t");
		}
		System.out.println();
	}

	
	@AfterMethod
	public void teardown() {
		driver.close();
	}

}
