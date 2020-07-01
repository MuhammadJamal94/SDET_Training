package automationFrameworkTests.seleniumJava;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import resources.InitializationB;

public class ButtonIssue extends InitializationB {

	@BeforeTest
	public void init() throws IOException {
		// Initialize the driver and go to URL
		driver = initializeBrowser();

		// Get the URL from properties file
		driver.get(prop.getProperty("RegisterationURL"));
		driver.manage().window().maximize();
		//driver.get("https://www.facebook.com/");
	}

	@Test
	public void GoogleTestCase() throws IOException {

		// Variables
		Actions act =  new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Make object of the home page
		TravelsRegisterationPage RegPage = new TravelsRegisterationPage(driver);

		// Enter the first name data
		//RegPage.getFirstName().sendKeys("John");

		// Enter the last name data
		//RegPage.getLastName().sendKeys("Wick");

		// Enter the mobile number data
		RegPage.getPhone().sendKeys("01111111111");


		// Click on start BTN
		//act.moveToElement(RegPage.getSignUpButton()).click().perform();
		//RegPage.getSignUpButton().click();
		//driver.findElement(By.xpath("//*[@value='Submit']"));
		//////////////////////////////////WebElement element = driver.findElement(By.cssSelector(".signupbtn"));
		//WebElement element = driver.findElement(By.cssSelector(".btn-primary"));
		/////////////////////////////////act.moveToElement(element).click().perform();
		//act.moveToElement(RegPage.getSignUpButton()).click().perform();
		
		//Find element        		
		WebElement element = driver.findElement(By.cssSelector(".signupbtn"));

        //This will scroll the page till the element is found		
        js.executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        //String message = driver.findElement(By.name("usrname")).getAttribute("validationMessage");
        String message = RegPage.getFirstName().getAttribute("validationMessage");
        System.out.println("THIS IS THE MSG "+message);
		

		// Explicit Wait to let the item load
		//WebDriverWait w = new WebDriverWait(driver, 15);
		//w.until(ExpectedConditions.visibilityOf(ex2Page.getHelloWorldMSG()));

		// Check MSG
		//String value = ex2Page.getHelloWorldMSG().getText();

		//System.out.println("This is the value " + value);

		// Check on the returned value
		//Assert.assertEquals(value, "Hello World!");
	}

	@AfterTest
	public void tearDown() {
		//driver.close();
	}

}
