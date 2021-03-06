package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPages {

	@FindBy(id = "email")
	private WebElement uname;

	@FindBy(id = "password")
	private WebElement pass;

	@FindBy(xpath = "//button")
	private WebElement loginbtn;

	public LoginPages(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void loginToApplication() {
		uname.sendKeys("kiran@gmail.com");
		pass.sendKeys("123456");
		loginbtn.click();
	}

}
