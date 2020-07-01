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

public class Registration_1Test2 extends InitializationB {

	// Test Goal:Login with Valid credentials

	@BeforeTest
	public void init() throws IOException {
		// Initialize the driver and go to URL
		driver = initializeBrowser();

		// Get the URL from properties file
		driver.get(prop.getProperty("RegisterationURL"));
		driver.manage().window().maximize();

	}

	@Test
	public void Reg_FirstName1() throws Exception {
		// Variables
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Make object from the data class
		// DDT excel = new DDT();
		// ArrayList x = excel.getData("FirstName1");

		// Make object of the home page
		TravelsRegisterationPage RegPage = new TravelsRegisterationPage(driver);

		// Enter the first name data
		RegPage.getFirstName().sendKeys("Jack");

		// Enter the last name data
		RegPage.getLastName().sendKeys("Johns");

		// Enter the mobile number data
		RegPage.getPhone().sendKeys("123");

		// Enter the Email address data
		RegPage.getEmail().sendKeys("j@j14.com");

		// Enter the Password data
		RegPage.getPassword().sendKeys("123123");

		// Confirm the Password data
		RegPage.getConfirmpassword().sendKeys("123123");

		// This will scroll the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();", RegPage.getSignUpButtonCSS());
		// Click on start BTN
		RegPage.getSignUpButtonCSS().click();

		// Explicit Wait to let the item load
		// WebDriverWait w = new WebDriverWait(driver, 15);
		// w.until(ExpectedConditions.visibilityOf(ex2Page.getHelloWorldMSG()));
		Thread.sleep(2000);
		//new WebDriverWait(driver, 5);

		System.out.println(driver.getCurrentUrl());
		// get HTTP response
		 HttpResponse Res =HTTPInterceptor2.GetRespose(driver.getCurrentUrl());
		 System.out.println(Res);


		/// LogIn///
		Thread.sleep(2000);
		// Make object of the login page
		TravelsLoginPage LP = new TravelsLoginPage(driver);
		// driver.get(prop.getProperty("LogInURL"));
		driver.navigate().to("https://phptravels.net/login");

		// Enter Email
		LP.getUserName().sendKeys("j@j14.com");

		// Enter Password
		LP.getPassword().sendKeys("123123");

		// Press Login BTN
		LP.getLogInBTN().click();

		Thread.sleep(2000);
		//new WebDriverWait(driver, 5);

		driver.navigate().to("https://phptravels.net/");

		// Make object of profile page
		TravelsUserAccount userAcc = new TravelsUserAccount(driver);
		// Explicit Wait to let the item load
		WebDriverWait w = new WebDriverWait(driver, 15);
		w.until(ExpectedConditions.visibilityOf(userAcc.getUserNameX()));
		String value = userAcc.getUserNameX().getText();

		// Check on the returned value
		Assert.assertEquals(value.toLowerCase(), "Jack".toLowerCase());

	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
