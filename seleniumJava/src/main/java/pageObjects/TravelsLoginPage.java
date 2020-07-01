package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TravelsLoginPage {
	
	//Declare WebDriver
	public WebDriver driver;
	
	//Last Name field
	By userName=By.name("username");
	
	//Phone field
	By password=By.name("password");
	
	//Login BTN
	By LogInBTN=By.cssSelector("button.btn:nth-child(4)");
	
	//Initialize Driver
	public TravelsLoginPage(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement getUserName() 
	{
		return driver.findElement(userName);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}
	
	public WebElement getLogInBTN() {
		return driver.findElement(LogInBTN);
	}

}
