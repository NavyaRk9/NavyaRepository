package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class AppUtil {
	public static WebDriver driver;
	public static Properties prop;
	@BeforeSuite
	public void setUp() throws Throwable
	{
		prop=new Properties();
		prop.load(new FileInputStream("/Users/ramakrishna/Desktop/Navya/SeleniumMaven/Maven_Hybrid/PropertyFiles/Environment.properties"));
		if(prop.getProperty("Browser").equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "/Users/ramakrishna/Downloads/chromedriver");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(prop.getProperty("Url"));
		}
		else if(prop.getProperty("Browser").equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
			driver.get(prop.getProperty("Url"));
		}
		else
		{
			System.out.println("Browser value is not matching");
		}
		
	}
	@AfterSuite
	public void tearDown()
	{
		driver.close();
	}

}
