package com.hrms.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class General extends Global{
	//Re-usable Functions
	public WebDriver openApplication() {
		Log.info("*******started execution***********");
		System.setProperty("webdriver.chrome.driver",".//chromedriver.exe");
		driver= new ChromeDriver();	
		driver.navigate().to(url);
		driver.manage().window().maximize();
		System.out.println("Application Launched");
		return driver;
	}

	public void closeApplication() {
		System.out.println("Application Closed");
		driver.close();
		driver.quit();
		Log.info("Application close successfully");
		Log.info("*******End execution***********");
	}
	
	public void loign() {
		driver.findElement(By.name(txt_loginname)).sendKeys(un);
		driver.findElement(By.name(txt_password)).sendKeys(pw);
		driver.findElement(By.name(btn_login)).click();
		Assert.assertTrue(driver.findElement(By.xpath(welcomeText)).getText().matches(verifyWelcome));
		System.out.println("LogIn Successful !!!");
	}
	public void logout() {
		driver.findElement(By.xpath(btn_logout)).click();
		System.out.println("Logout Successful !!!");
	}
}
