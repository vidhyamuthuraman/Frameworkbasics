package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Propertyfilereader {
 
	public static String pfilereader(String name)
	{
		FileInputStream fis=null;
		Properties prop=null;
		try
		{
			fis=new FileInputStream(new File("C:\\Users\\ctvla\\eclipse-workspace\\FrameworkSample\\src\\main\\java\\resources\\Configuration.properties"));
			prop=new Properties();
			prop.load(fis);
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		//System.out.println(prop.getProperty(name));
		return prop.getProperty(name);
	}
}
