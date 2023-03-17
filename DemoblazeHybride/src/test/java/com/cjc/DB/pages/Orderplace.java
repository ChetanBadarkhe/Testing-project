package com.cjc.DB.pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

public class Orderplace 
{
	static Logger log=Logger.getLogger(Orderplace.class.getName());
	WebDriver driver;
public Orderplace(WebDriver driver)
	{
		this.driver=driver;
}
@FindBy(xpath="//*[@id=\"cartur\"]")
WebElement cart;
@FindBy(xpath="//*[@id=\"page-wrapper\"]/div/div[2]/button")
WebElement orderplace;
@FindBy(xpath="//*[@id=\"name\"]")
WebElement name;
@FindBy(xpath="//*[@id=\"country\"]")
WebElement country;
@FindBy(xpath="//*[@id=\"city\"]")
WebElement city;
@FindBy(xpath="//*[@id=\"card\"]")
WebElement cd;
@FindBy(xpath="//*[@id=\"month\"]")
WebElement mnt;
@FindBy(xpath="//*[@id=\"year\"]")
WebElement year;
@FindBy(xpath="//*[@id=\"orderModal\"]/div/div/div[3]/button[2]")
WebElement purchorder;
@FindBy(xpath="/html/body/div[10]/h2")
WebElement hdr;
@FindBy(xpath="//div[@class='sweet-alert  showSweetAlert visible']/child :: p")
WebElement id;
@FindBy(xpath="/html/body/div[10]/div[7]/div/button")
WebElement orderid;
@FindBy(xpath="//*[@id=\"logout2\"]")
WebElement lout;

public void ordercheck(String a,String b,String c,String d,String e,String f) throws InterruptedException, IOException
{
	Thread.sleep(1000);
	cart.click();
	Thread.sleep(1000);
	orderplace.click();
	Thread.sleep(1000);
	name.sendKeys(a);
	Thread.sleep(1000);
	country.sendKeys(b);
	Thread.sleep(1000);
	city.sendKeys(c);
	Thread.sleep(1000);
	cd.sendKeys(d);
	Thread.sleep(1000);
	mnt.sendKeys(e);
	Thread.sleep(1000);
	year.sendKeys(f);
	purchorder.click();
	Thread.sleep(2000);
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("scrollBy(0,100)");
    File fl=((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFileToDirectory(fl, new File("src/test/resources/Screenshot"));
	Thread.sleep(2000);
	log.info("Screenshot taken successfull");
	Thread.sleep(2000);
	   WebElement ab= hdr;
       String  aaa=ab.getText();
             log.info(aaa);
             Thread.sleep(5000);
    WebElement abc= id;
     String  aa=abc.getText();
         log.info(aa);

	orderid.click();
	lout.click();
}
}
