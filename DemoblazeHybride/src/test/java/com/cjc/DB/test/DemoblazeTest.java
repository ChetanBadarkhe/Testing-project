package com.cjc.DB.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.cjc.DB.pages.Addtocart;
import com.cjc.DB.pages.Login;
import com.cjc.DB.pages.Orderplace;
import com.cjc.DB.pages.Register;
import com.cjc.DB.utility.Common;

public class DemoblazeTest 
{
	static Logger log=Logger.getLogger(DemoblazeTest.class.getName());
    WebDriver driver;
	@BeforeSuite()
	public void Openbrowser() throws IOException
	{
		FileInputStream fis= new FileInputStream("src/test/resources/DB.properties");
		Common.pro.load(fis);
		System.setProperty(Common.pro.getProperty("key"),Common.pro.getProperty("value"));
		 driver=new ChromeDriver();
	  
	}
	@Parameters({"url"})
    @BeforeTest
    public void openurl(String url)
    {
	driver.get(url);
    }
    @BeforeClass
    public void windowshandle()
    {
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test(priority=0)
    public void Registercheck() throws InterruptedException, IOException
    {
    	  Register rg=PageFactory.initElements(driver,Register.class); 
	        rg.registercheck();
    }
   
    @Test(priority=1)
    public void Logintest() throws IOException, InterruptedException
    {
 	 Login rg=PageFactory.initElements(driver,Login.class); 
 	        rg.logincheck();
} 
    @Test(priority=2)
public void addtocart() throws Exception
{
 Addtocart rg=PageFactory.initElements(driver, Addtocart.class); 
        rg.cartcheck();
}
@Test(priority=3,dataProvider ="orderData")
public void ordplace(String a,String b,String c,String d,String e,String f) throws Exception
{
 Orderplace rg=PageFactory.initElements(driver, Orderplace.class); 
        rg.ordercheck(a, b, c, d, e,f);
}
@DataProvider
public Object[][] orderData()
{
return new Object[][]
		{
	new Object[] {"chetan","India","pune","1234123445676789","07","2023"},
		};	
		} 
@AfterSuite
public void browserclosed()
{
	driver.close();
}
}