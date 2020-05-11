package com.hrms.util;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class Global {
	//Variables
	public static WebDriver driver;
	public static String url="http://127.0.0.1/orangehrm-2.6/login.php";
	public static String un;
	public static String pw;
	public Global(){
		try {
			File src=new File(".//Login.xlsx");	
			//System.out.println(src.getAbsolutePath());
			   // load file
			   FileInputStream fis=new FileInputStream(src);			 
			   // Load workbook
			   XSSFWorkbook wb=new XSSFWorkbook(fis);			   
			   // Load sheet- Here we are loading first sheetonly
			      XSSFSheet sh1= wb.getSheetAt(0);
			      un=sh1.getRow(1).getCell(0).getStringCellValue();
			      pw=sh1.getRow(1).getCell(1).getStringCellValue();
			      //System.out.println(un);			      
			      //System.out.println(pw);
			      wb.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


	//Object Elements
	public String txt_loginname="txtUserName";
	public String txt_password="txtPassword";
	public String btn_login="Submit";
	public static String verifyWelcome="Welcome Admin";
	public String btn_logout="//*/a[contains(text(),'Logout')]";
	public static String welcomeText="//*/li[contains(text(),'Welcome Admin')]";
	public static String pimButton="//*/span[contains(text(),'PIM')]";
	public static String addButtionPIM="//*/span[contains(text(),'Add Employee')]";
	public static String btn_Add="//*/input[@type='button'][@value='Add']";
	public static String btn_Save="//*/input[@type='button'][@value='Save']";
	public static String btn_Delete="//*/input[@type='button'][@value='Delete']";
	public static String btn_Back="//*/input[@type='button'][@value='Back']";
	public static String empId="txtEmployeeId";
	public static String empLastName="txtEmpLastName";
	public static String empFirstName="txtEmpFirstName";
	public static String empMiddleName="txtEmpMiddleName";
	public static String empNickName="txtEmpNickName";
	public static String tableColumn="//*/form[@id=\"standardView\"]/table/thead/tr/td";
	public static String tableRows="//*[@id=\"standardView\"]/table/tbody/tr";
	

}
