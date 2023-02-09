package testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.ITestResult;
import org.testng.annotations.Test;
//import org.testng.AssertJUnit;
import java.io.File;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.util.Assert;

public class DemoTest {
	
	ExtentSparkReporter spark=new ExtentSparkReporter(new File("testreport//spark.html"));
	ExtentReports extent;
	ExtentTest test;
	
	@BeforeTest
	public void setup()
	{
		extent=new ExtentReports();
		extent.attachReporter(spark);
		spark.config().setDocumentTitle("Automation");
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("Demo Report");
		//spark.config().setTimeStampFormat("EEEE"HH:MM:SS);
		
	}
  @Test
  public void Testcase1()
  {
	  test=extent.createTest("Testcase1","this is test case passed");
	  AssertJUnit.assertTrue(true);
  }
  @Test
  public void Testcase2()
  {
	  test=extent.createTest("Testcase2","this is test case passed");
	  AssertJUnit.assertTrue(false);
  }
  @Test
  public void Testcase3()
  {
	  test=extent.createTest("Testcase3","this is test case passed");
	  AssertJUnit.assertTrue(true);
  }
  @Test
  public void Testcase4()
  {
	  test=extent.createTest("Testcase4","this is test case passed");
	  AssertJUnit.assertTrue(true);
  }

@AfterMethod
public void getResult(ITestResult result)
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

	
}

@AfterTest
public void teardown()
{
	extent.flush();
}
}
