package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TravelsUserAccount {
	
	//Declare WebDriver
	public WebDriver driver;
	
	//First Name field
	By UserName=By.name("//*[@id=\'dropdownCurrency\']");
	By UserNameXPath=By.xpath("//*[@id=\'//header-waypoint-sticky\']/div[1]/div/div/div[2]/div/ul/li[3]/div");
	
	//Initialize Driver
	public TravelsUserAccount(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement getUserName() 
	{
		return driver.findElement(UserName);
	}
	
	public WebElement getUserNameX() 
	{
		return driver.findElement(UserNameXPath);
	}

}
