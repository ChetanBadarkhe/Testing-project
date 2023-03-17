package com.cjc.DB.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class Common 
{
	public static WebDriver driver;
	public static FileInputStream fis;
	public static XSSFWorkbook aw;
	public static XSSFSheet sheet;
	public static XSSFSheet sheet1;
	public static XSSFSheet sheet2;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static String Username;
	public static String password;

	public static Properties pro=new Properties();
	public static FileInputStream fineCall() throws FileNotFoundException 
	{
	fis=new FileInputStream("src/test/resources/Demoblaze.xlsx")	;
	return fis;
	}
	static List<String> li=new ArrayList<String>();

	 public static void Data() throws IOException
	 {
		 fis=new FileInputStream("src/test/resources/Demoblaze.xlsx");
		  aw=new XSSFWorkbook(fis);
	   sheet=aw.getSheet("Sheet1"); 
		int rowcount=sheet.getLastRowNum();
		for(int i=1;i<rowcount+1;i++)
		{
			for(int j=0;j<2;j++)
			{
				String v=sheet.getRow(i).getCell(j).getStringCellValue();
				li.add(v);
			}
			Username=li.get(0);
			password=li.get(1);
			
		}
	
		 }
}
