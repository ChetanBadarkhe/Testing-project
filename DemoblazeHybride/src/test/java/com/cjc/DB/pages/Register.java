package com.cjc.DB.pages;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cjc.DB.utility.Common;

public class Register 
{
	static Logger log=Logger.getLogger(Register.class.getName());
	WebDriver driver;
	@FindBy(xpath = "//*[@id=\"signin2\"]")
	WebElement signup;
	@FindBy(xpath = "//*[@id=\"sign-username\"]")
	WebElement uname;
	@FindBy(xpath = "//*[@id=\"sign-password\"]")
	WebElement pass;
	@FindBy(xpath = "//*[@id=\"signInModal\"]/div/div/div[3]/button[2]")
	WebElement register;
	@FindBy(xpath = "//*[@id=\"signInModal\"]/div/div/div[3]/button[1]")
	WebElement close;
	public Register(WebDriver driver)
    {
	this.driver=driver;
			}
    public void registercheck() throws InterruptedException, IOException
	{
			signup.click();
			Thread.sleep(2000);
			Common.Data();
			String unm=Common.pro.getProperty("un");
			String psw=Common.pro.getProperty("ps");
		    uname.sendKeys(unm);
			pass.sendKeys(psw);
			register.click();
	driver.navigate().to("https://www.demoblaze.com/index.html");
	

		log.info("Registration successfull");
}
}