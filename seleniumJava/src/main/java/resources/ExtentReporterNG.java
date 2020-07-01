package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	static ExtentReports extent;
	
	public static ExtentReports getReportObject()
	{
		String path=System.getProperty("user.dir")+"\\Reports\\index.html";
		ExtentSparkReporter spark =new ExtentSparkReporter(path); 
		spark.config().setReportName("Jimmy's Report");
		spark.config().setDocumentTitle("PixelLogic TestReport");
		

		extent = new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("Tester", "Jimmy");
		
		return extent;
	}

}
