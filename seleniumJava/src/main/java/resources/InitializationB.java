package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class InitializationB {
	
	//Global Webdirver
	public WebDriver driver;
	//Global Properties
	public Properties prop;
	//This function is responsible for setting the driver type properly
	public WebDriver initializeBrowser() throws IOException
	{
		prop=new Properties();
		//Get the properties file
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\PropertiesData");
		prop.load(fis);
		//Getting property by key
		String browserType=prop.getProperty("Browser");
		System.out.println("THIS IS THE TYPEEEEE "+browserType);
		
		if(browserType.equals("chrome"))
		{
			//execute chrome driver
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver_win32\\chromedriver.exe");
			//Assign WebDriver to chrome
			driver =  new ChromeDriver();
		}
		else if(browserType.equals("firefox"))
		{
			//execute firefox driver
			
			//Assign WebDriver to firefox
			driver =  new FirefoxDriver();
		}
		else if(browserType.equals("IE"))
		{
			//execute IE driver
			
			//Assign WebDriver to IE
			driver =  new InternetExplorerDriver();
		}
		
		//IF we have requirement defines a time tolerance to wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
		
		
	}
	
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		//Variables
		String destinationFile=System.getProperty("user.dir")+"\\ScreenShots\\"+testCaseName+".png";
		TakesScreenshot ts=(TakesScreenshot)driver;
		//Virtual File
		File source=ts.getScreenshotAs(OutputType.FILE);
		//Save File on your PC
		FileUtils.copyFile(source, new File (destinationFile));
		
		return destinationFile;
		
		
	}

}
