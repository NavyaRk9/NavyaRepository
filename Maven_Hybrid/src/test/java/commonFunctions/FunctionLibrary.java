package commonFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import config.AppUtil;

public class FunctionLibrary extends AppUtil{
	public static boolean verifyLogin(String username,String pwd)
	{
		driver.findElement(By.xpath(prop.getProperty("Objuser"))).sendKeys(username);
		driver.findElement(By.xpath(prop.getProperty("Objpwd"))).sendKeys(pwd);
		driver.findElement(By.xpath(prop.getProperty("ObjLogin"))).click();
		String expected="adminflow";
		String actual=driver.getCurrentUrl();
		if(actual.toLowerCase().contains(expected.toLowerCase()))
		{
			Reporter.log("Login success"+expected+"    "+actual,true);
			return true;
		}
		else
		{
			Reporter.log("Login fail"+expected+"   "+actual,true);
			return false;
		}
	}
	public static void clickBranches() throws Throwable
	{
		driver.findElement(By.xpath(prop.getProperty("ObjBranches"))).click();
		Thread.sleep(2000);
	}
	public static boolean verifyNewBranch(String branchname,String address1,String address2,String address3,String area,
			                                       String zipcode,String country,String state,String city) throws Throwable 
	{
		driver.findElement(By.xpath(prop.getProperty("ObjNewBranch"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("ObjBranch"))).sendKeys(branchname);
		driver.findElement(By.xpath(prop.getProperty("ObjAddress1"))).sendKeys(address1);
		driver.findElement(By.xpath(prop.getProperty("ObjAddress2"))).sendKeys(address2);
		driver.findElement(By.xpath(prop.getProperty("ObjAddress3"))).sendKeys(address3);
		driver.findElement(By.xpath(prop.getProperty("ObjArea"))).sendKeys(area);
		driver.findElement(By.xpath(prop.getProperty("ObjZipcode"))).sendKeys(zipcode);
		new Select(driver.findElement(By.xpath(prop.getProperty("ObjCountry")))).selectByVisibleText(country);
		new Select(driver.findElement(By.xpath(prop.getProperty("ObjState")))).selectByVisibleText(state);
		new Select(driver.findElement(By.xpath(prop.getProperty("ObjCity")))).selectByVisibleText(city);
		driver.findElement(By.xpath(prop.getProperty("ObjSubmit"))).click();
		Thread.sleep(2000);
		String expectedalert=driver.switchTo().alert().getText();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		String actualalert="New Branch with ";
		if(expectedalert.toLowerCase().contains(actualalert.toLowerCase()))
		{
			Reporter.log(expectedalert,true);
			return true;
		}
		else
		{
			Reporter.log("Branch creation is failed",true);
			return false;
		}

		
	}
	public static boolean verifyBranchUpdate(String branchname,String address,String area,String zipcode) throws Throwable
	{
		driver.findElement(By.xpath(prop.getProperty("ObjEdit"))).click();
		Thread.sleep(2000);
		WebElement element1=driver.findElement(By.xpath(prop.getProperty("ObjBranchName")));
		element1.clear();
		element1.sendKeys(branchname);
		WebElement element2=    driver.findElement(By.xpath(prop.getProperty("ObjAddress")));
		element2.clear();
		element2.sendKeys(address);
		WebElement element3= driver.findElement(By.xpath(prop.getProperty("ObjAreaName")));
		element3.clear();
		element3.sendKeys(area);
		WebElement element4= driver.findElement(By.xpath(prop.getProperty("ObjZip")));
		element4.clear();
		element4.sendKeys(zipcode);
		driver.findElement(By.xpath(prop.getProperty("ObjUpdate"))).click();
		Thread.sleep(2000);
		String expectedalert=driver.switchTo().alert().getText();
		Thread.sleep(2000);
		String actualalert="Branch updated";
		if(expectedalert.toLowerCase().contains(actualalert.toLowerCase()))
		{
			Reporter.log(expectedalert,true);
			return true;
		}
		else
		{
			Reporter.log("Branch updation is failed",true);
			return false;
		}
		
	}
	public static boolean verifyLogout() throws Throwable 
	{
		driver.findElement(By.xpath(prop.getProperty("ObjLogout"))).click();
		Thread.sleep(2000);
		if(driver.findElement(By.xpath(prop.getProperty("ObjLogin"))).isDisplayed())
		{
			Reporter.log("logout success",true);
			return true;
		}
		else
		{
			Reporter.log("Logout fail",true);
			return false;
		}
		
	}
	

}














