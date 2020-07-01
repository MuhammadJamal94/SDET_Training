package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TravelsRegisterationPage {
	
	//Declare WebDriver
	public WebDriver driver;
	
	//First Name field
	By firstName=By.name("firstname");
	
	//Last Name field
	By lastName=By.name("lastname");
	
	//Phone field
	By phone=By.name("phone");
	
	//email field
	By email=By.name("email");
	
	//password field
	By password=By.name("password");
	
	//confirm password field
	By confirmpassword=By.name("confirmpassword");
	
	//SignUp Button x-path
	By SignUpButtonXPATH=By.xpath("//*[@id='headersignupform']/div[8]/button");
	
	//SignUp Button CSS
	By SignUpButtonCSS=By.cssSelector(".signupbtn");
	
	//The Email alert
	By EmailAlert=By.cssSelector(".alert");
	
	//Initialize Driver
	public TravelsRegisterationPage(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement getFirstName() 
	{
		return driver.findElement(firstName);
	}

	public WebElement getLastName() {
		return driver.findElement(lastName);
	}

	public WebElement getPhone() {
		return driver.findElement(phone);
	}

	public WebElement getEmail() {
		return driver.findElement(email);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement getConfirmpassword() {
		return driver.findElement(confirmpassword);
	}

	public WebElement getSignUpButtonXPATH() {
		return driver.findElement(SignUpButtonXPATH);
	}
	
	public WebElement getSignUpButtonCSS() {
		return driver.findElement(SignUpButtonCSS);
	}
	
	public WebElement EmailAlert() {
		return driver.findElement(EmailAlert);
	}
	

}
