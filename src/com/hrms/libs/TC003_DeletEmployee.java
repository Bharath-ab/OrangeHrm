package com.hrms.libs;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.hrms.util.General;
import com.hrms.util.Global;
import com.hrms.util.Log;

public class TC003_DeletEmployee {

	public static WebDriver driver;
	@Test()
	public void deleteEmployee() throws IOException {
		DOMConfigurator.configure("log4j.xml");
		General gn=new General();		
		try {		
			driver=gn.openApplication();
				gn.loign();
				//WebDriverWait wait = new WebDriverWait(driver,30);
				//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("rightMenu"));
				driver.switchTo().frame("rightMenu");
				Thread.sleep(2000);
				//List<WebElement> columns=driver.findElements(By.xpath(Global.tableColumn));
				List<WebElement> rows=driver.findElements(By.xpath(Global.tableRows));
				for(int i=1;i<=rows.size();i++) {
					for(int j=1;j<=rows.size();j++) {
					String delEmpRecord="//*[@id='standardView']/table/tbody/tr["+i+"]/td[1]/input";					
					String empRecord="//*[@id=\"standardView\"]/table/tbody/tr["+i+"]/td[2]";
					String delRecord=driver.findElement(By.xpath(empRecord)).getText();	
					driver.findElement(By.xpath(delEmpRecord)).click();
					driver.findElement(By.xpath(Global.btn_Delete)).click();
					System.out.println("Employee Id: "+delRecord+" delected successfully !!!!!");
					Log.info("*******Employee Deleted***********"+delRecord);
					Thread.sleep(1000);
					}
					break;
				}
				Thread.sleep(2000);
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
