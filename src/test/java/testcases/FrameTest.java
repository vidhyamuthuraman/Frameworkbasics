package testcases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseclass.Browserconfig;
import pageobjectmodel.Homepage;
import utilities.ExcelHandling;
import utilities.Propertyfilereader;

public class FrameTest {
	ExtentSparkReporter spark1=new ExtentSparkReporter(new File("testreport//spark1.html"));
	ExtentReports extent;
	ExtentTest test;
  
	 WebDriver driver;
	 @BeforeTest
	 public void getresult()
	 {  extent=new ExtentReports();
		extent.attachReporter(spark1);
		spark1.config().setDocumentTitle("Automation");
		spark1.config().setTheme(Theme.DARK);
		spark1.config().setReportName("Demo Report");
		 
	 }
		@BeforeMethod
		public void setup()
		{
				
			driver=Browserconfig.getdriver();
		}
		@Test(dataProvider="testdata")
		
		public void testcase1(String user,String pass) throws InterruptedException
		
		{   
			Thread.sleep(1000);
			Homepage h=new Homepage(driver);
			h.username().sendKeys(user);
			h.password().sendKeys(pass);
			driver.findElement(By.name(Propertyfilereader.pfilereader("login"))).click();
			test=extent.createTest("testcase1","Able to login");
		     AssertJUnit.assertTrue(true);
		}
		public void testcase2()
		{
			 test=extent.createTest("testcase2","Login failed");
		     AssertJUnit.assertTrue(false);
			
		}
		
		@DataProvider(name="testdata")
		public String[][]getdata()throws IOException
		{
			
			String a[][]=ExcelHandling.data();
			return a;
			
		}
		
		@AfterMethod
		 
		public void getResult(ITestResult result) throws InterruptedException
		{
			if(result.getStatus()==ITestResult.SUCCESS)
			{
				test.log(Status.PASS,result.getThrowable());
				}
			else if (result.getStatus()==ITestResult.FAILURE)
			{
				test.log(Status.FAIL,result.getThrowable());	
			}
			else
			{
				test.log(Status.SKIP,result.getThrowable());
			}

			driver.close();
			Thread.sleep(2000);
		}
		@AfterTest
		public void teardown()
		{
			extent.flush();
		}
		
		
	}


