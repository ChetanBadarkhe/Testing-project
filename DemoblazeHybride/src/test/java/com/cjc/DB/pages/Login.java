package com.cjc.DB.pages;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cjc.DB.utility.Common;
public class Login 
{
	static Logger log=Logger.getLogger(Login.class.getName());

	WebDriver driver;
	public Login(WebDriver driver)
	{
	this.driver=driver;
	}
	@FindBy(xpath="//*[@id=\"login2\"]")
	WebElement lo;
	@FindBy(xpath="//*[@id=\"loginusername\"]")
	WebElement email1;
	@FindBy(xpath="//*[@id=\"loginpassword\"]")
	WebElement pass1;
	@FindBy(xpath="//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")
	WebElement login;
	
	  public void logincheck() throws InterruptedException, IOException
	  {
		 
	    driver.get("https://www.demoblaze.com/index.html");
	    lo.click();
	    Thread.sleep(2000);
	  	Common.Data();
	  	String us=Common.Username;
	  	String ps=Common.password;
	  	email1.sendKeys(us);
	  	pass1.sendKeys(ps);
	  	login.click();
	  	log.info(us);
		log.info(ps);
		log.info("login successfull");
	  
}
}