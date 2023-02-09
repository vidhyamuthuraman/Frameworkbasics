package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.Propertyfilereader;

public class Homepage 
{
WebDriver driver;

public Homepage(WebDriver driver)

{
	this.driver=driver;
}
By user_name=By.name(Propertyfilereader.pfilereader("username_name"));
//By user_name=By.name("user");
By pasword=By.name(Propertyfilereader.pfilereader("pass_word"));
 

public WebElement username()
{
	WebElement username=driver.findElement(user_name);
	return username;
	
}
public WebElement password()
{
	
	WebElement password=driver.findElement(pasword);

	return password;
	
}

}
