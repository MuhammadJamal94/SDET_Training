package automationFrameworkTests.seleniumJava;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.FileUploadedPage;
import pageObjects.GoogleHB;
import pageObjects.GoogleSearchResults;
import pageObjects.TravelsRegisterationPage;
import pageObjects.herokuappDLPage;
import pageObjects.herokuappEx2;
import pageObjects.herokuappMainPage;
import pageObjects.herokuappUploadPage;
import resources.DDT;
import resources.InitializationB;

public class Reg_Pass6_Test extends InitializationB {

	// Test Goal:Check error MSG will appear in case Confirm password field is empty
	// characters

	@BeforeTest
	public void init() throws IOException {
		// Initialize the driver and go to URL
		driver = initializeBrowser();

		// Get the URL from properties file
		driver.get(prop.getProperty("RegisterationURL"));
		driver.manage().window().maximize();
	}

	@Test
	public void Reg_Pass1() throws IOException {

		// Variables
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String error_Message;
		// Make object from the data class
		DDT excel = new DDT();
		ArrayList x = excel.getData("Password6");

		// Make object of the home page
		TravelsRegisterationPage RegPage = new TravelsRegisterationPage(driver);

		// Enter the first name data
		RegPage.getFirstName().sendKeys(x.get(1).toString());

		// Enter the last name data
		RegPage.getLastName().sendKeys(x.get(2).toString());

		// Enter the mobile number data
		RegPage.getPhone().sendKeys(x.get(3).toString());

		// Enter the Email address data
		RegPage.getEmail().sendKeys(x.get(4).toString());

		// Enter the Password data
		RegPage.getPassword().sendKeys(x.get(5).toString());

		// This will scroll the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();", RegPage.getSignUpButtonCSS());
		// Click on start BTN
		RegPage.getSignUpButtonCSS().click();

		// Check the error MSG
		error_Message = RegPage.getConfirmpassword().getAttribute("validationMessage");
		System.out.println("THIS IS THE MSG " + error_Message);

		// Check MSG
		Assert.assertEquals(error_Message, "Please fill out this field.");
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
