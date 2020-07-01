package automationFrameworkTests.seleniumJava;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
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
import pageObjects.TravelsLoginPage;
import pageObjects.TravelsRegisterationPage;
import pageObjects.TravelsUserAccount;
import pageObjects.herokuappDLPage;
import pageObjects.herokuappEx2;
import pageObjects.herokuappMainPage;
import pageObjects.herokuappUploadPage;
import resources.DDT;
import resources.HTTPInterceptor2;
import resources.InitializationB;

public class Reg_Pass2_Test extends InitializationB {

	// Test Goal:Check error MSG will appear in case password > 8 chars
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
	public void Reg_Pass1() throws IOException, Exception {

		// Variables
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String error_Message;
		// Make object from the data class
		DDT excel = new DDT();
		ArrayList x = excel.getData("Password2");

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

		// Confirm the Password data
		RegPage.getConfirmpassword().sendKeys(x.get(6).toString());

		// This will scroll the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();", RegPage.getSignUpButtonCSS());
		// Click on start BTN
		RegPage.getSignUpButtonCSS().click();

		// Check MSG
		// Assert.assertEquals(error_Message, "The Password field must be at least 6
		// characters in length.");

		// get HTTP response
		HttpResponse Res = HTTPInterceptor2.GetRespose(driver.getCurrentUrl());
		System.out.println(Res);

		/// LogIn///
		Thread.sleep(2000);
		// Make object of the login page
		TravelsLoginPage LP = new TravelsLoginPage(driver);
		// driver.get(prop.getProperty("LogInURL"));

		// Enter Email
		LP.getUserName().sendKeys(x.get(4).toString());

		// Enter Password
		LP.getPassword().sendKeys(x.get(5).toString());

		// Press Login BTN
		LP.getLogInBTN().click();

		Thread.sleep(2000);
		// new WebDriverWait(driver, 5);

		driver.navigate().to(prop.getProperty("TravelBase"));

		// Make object of profile page
		TravelsUserAccount userAcc = new TravelsUserAccount(driver);
		// Explicit Wait to let the item load
		WebDriverWait w = new WebDriverWait(driver, 15);
		w.until(ExpectedConditions.visibilityOf(userAcc.getUserNameX()));
		String value = userAcc.getUserNameX().getText();

		// Check on the returned value
		Assert.assertEquals(value.toLowerCase(), x.get(1).toString().toLowerCase());
		Assert.fail("User registered successfully while he/she should not");

	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
