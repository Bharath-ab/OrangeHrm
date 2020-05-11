package com.hrms.libs;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.hrms.util.General;
import com.hrms.util.Log;

public class TC001_Login_Logout {
	static WebDriver driver;
	@Test()
	public void login_logout() throws IOException {
		DOMConfigurator.configure("log4j.xml");
		General gn=new General();		
		try {		
				driver=gn.openApplication();
				Log.info("Test");
				gn.loign();
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
