package com.hrms.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;

public class AddAttachment {
	public AddAttachment(WebDriver driver,String filePath) throws AWTException, InterruptedException{
				//Store the location of the file in clipboard 
				//Clipboard
				StringSelection strSel = new StringSelection(filePath);
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSel, null);
				
				//Create an object for robot class
				Robot robot = new Robot();
				//Control key in the keyboard
				//Ctrl+V 
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				
				Thread.sleep(3000);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
	}

}
