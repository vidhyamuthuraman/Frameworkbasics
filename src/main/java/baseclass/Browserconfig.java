package baseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utilities.Propertyfilereader;

public class Browserconfig {

	static WebDriver driver;
	public static WebDriver getdriver()
	{
      if(Propertyfilereader.pfilereader("browser_name").equalsIgnoreCase("chrome"))
    	  
      {
		driver=new ChromeDriver();
	  }
      else if(Propertyfilereader.pfilereader("browser_name").equalsIgnoreCase("FireFox"))
    	  {
    	  driver=new FirefoxDriver();
    	  }
    	  else
    		  
    	  { System.out.println("Invalid Browser name provided");}
    		  
    	  
		  
      
		driver.get(Propertyfilereader.pfilereader("url"));
		return driver;
	}
}
