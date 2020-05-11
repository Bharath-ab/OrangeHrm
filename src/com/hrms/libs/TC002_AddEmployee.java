package com.hrms.libs;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.hrms.util.General;
import com.hrms.util.Global;
import com.hrms.util.Log;

public class TC002_AddEmployee {
	public static WebDriver driver;
	@Test()
	public void addEmployee() throws IOException {
		DOMConfigurator.configure("log4j.xml");
		General gn=new General();		
		try {		
			driver=gn.openApplication();
				gn.loign();
				Thread.sleep(3000);
				/* Hovering from PIM
				Actions ac=new Actions(driver);
				WebElement pimMenu=driver.findElement(By.xpath(Global.pimButton));
				ac.moveToElement(pimMenu).build().perform();
				Thread.sleep(2000);
				WebElement addUser=driver.findElement(By.xpath(Global.addButtion));
				ac.moveToElement(addUser).build().perform();
				addUser.click();*/
				//WebDriverWait wait = new WebDriverWait(driver,30);
				//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("rightMenu"));
				driver.switchTo().frame("rightMenu");
				Thread.sleep(2000);
				for(int i=1;i<=5;i++) {
				driver.findElement(By.xpath(Global.btn_Add)).click();
				//driver.findElement(By.id(Global.empId)).clear();
				//driver.findElement(By.id(Global.empId)).sendKeys("00"+i);
				String employee_Id=driver.findElement(By.id(Global.empId)).getAttribute("value");
				driver.findElement(By.name(Global.empLastName)).sendKeys("Varma");
				driver.findElement(By.name(Global.empFirstName)).sendKeys("A");
				driver.findElement(By.name(Global.empMiddleName)).sendKeys("Bharath");
				driver.findElement(By.name(Global.empNickName)).sendKeys("BV");
				driver.findElement(By.xpath(Global.btn_Save)).click();
				driver.findElement(By.xpath(Global.btn_Back)).click();
				System.out.println("Employee with ID "+employee_Id+" Added Successfully");
				Log.info("*******Employee Added***********"+employee_Id);
				Thread.sleep(2000);
				}
				driver.switchTo().defaultContent();
				Thread.sleep(3000);
				gn.logout();
			}
		catch(Exception e ){
			File f1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(f1,new File("D:\\Bharath\\Test.png"));
				e.printStackTrace();
			}
		finally{
			gn.closeApplication();
		}

	}

}
