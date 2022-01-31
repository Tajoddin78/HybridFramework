package com.Base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Utility.PropertiesUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {

	public static WebDriver driver = null;
	public static ExtentReports report = null;
	public static ExtentSparkReporter spark = null;
	public static ExtentTest test = null;

	public static Logger log = Logger.getLogger("BaseClass");

	public void initialization() {
		System.out.println("browser initialization started");
		log.info("browser initialization started");
		log.info("reading property file for the key browser");
		String browser = PropertiesUtils.readprorperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			log.info("initializing chrome browser");
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get(PropertiesUtils.readprorperty("url"));
		}
	}

	public void reportInit() {
		log.info("initializing extent report");
		report = new ExtentReports();
		spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/target/ExtentReport.html");
		report.attachReporter(spark);
	}

	public String captureScreenshot(String name) {
		log.info("capturing screenshot for failed testcase");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + name + "_" + getDate() + ".jpg";
		File dest = new File(path);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

	public String getDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		String date = sdf.format(new Date());

		return date;
	}

}
