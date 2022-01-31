package com.Test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.Base.BaseClass;
import com.Utility.PropertiesUtils;
import com.pages.LoginPages;

public class LoginTest extends BaseClass {

	public LoginPages lp = null;

	@BeforeSuite
	public void setup() {
		log.info("inside beforesuite");
		initialization();
		reportInit();
		lp = new LoginPages(driver);
	}

	@AfterSuite
	public void tearDown() {
		report.flush();
	}

	@Test(priority = 1)
	public void loginTest() {
		log.info("executing login test");
		lp.loginToApplication();
		log.info("login test passed");
	}

	@Test(priority = 2)
	public void failTest() {
		log.info("executing fail test");
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Log in");
		log.info("fail test failed");
	}
}
