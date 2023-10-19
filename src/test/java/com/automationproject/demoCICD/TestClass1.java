package com.automationproject.demoCICD;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClass1 {
	public static WebDriver driver;
	
	@BeforeMethod
	public void launchDriver() throws MalformedURLException
	{
		DesiredCapabilities dr=new DesiredCapabilities();
		dr.setBrowserName("chrome");
		dr.setPlatform(Platform.WIN10);
		
		
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver","C:\\CICD\\ChromeDriver\\chromedriver.exe");
		driver=new RemoteWebDriver(new URL("http://192.168.0.44:4444/wd/hub"),dr);
		//driver=new ChromeDriver(ops);
		driver.get("https://login.salesforce.com/?locale=eu");
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//driver.manage().window().fullscreen();
		
	}
	@Test
	public void Test1()
	{
		driver.navigate().to("https://login.salesforce.com/?locale=eu");
		System.out.println("Test Case Title 1 is - " +driver.getTitle());
	}
	@Test
	public void Test2()
	{
		driver.navigate().to("https://login.salesforce.com/?locale=eu");
		System.out.println("Test Case Title 2 is - " +driver.getTitle());
	}
	@Test
	public void Test3()
	{
		driver.navigate().to("https://login.salesforce.com/?locale=eu");
		System.out.println("Test Case Title 3 is - " +driver.getTitle());
	}
	@AfterMethod
	public void quit()
	{
		driver.quit();
	}

}
