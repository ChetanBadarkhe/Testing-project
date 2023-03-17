package com.cjc.DB.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Addtocart 
{
	static Logger log=Logger.getLogger(Addtocart.class.getName());
	WebDriver driver;
public Addtocart(WebDriver driver)
	{
		this.driver=driver;
}
  @FindBy(linkText="Laptops")
  WebElement laptop;
  @FindBy(xpath="//*[@id=\"tbodyid\"]/div[2]/div/div/h4/a")
  WebElement item;
  @FindBy(xpath="//*[@id=\"tbodyid\"]/div[2]/div/a")
  WebElement add;
 

public void cartcheck() throws InterruptedException 
{
	Thread.sleep(2000);
	laptop.click();
	Thread.sleep(2000);
	item.click();
	Thread.sleep(2000);
	add.click();
	Thread.sleep(2000);
	driver.switchTo().alert().accept();
	log.error("ERROR");
	log.warn("Warning");
	log.info("purchase item added successfully");
}
}
