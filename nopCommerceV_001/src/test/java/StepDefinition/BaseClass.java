package StepDefinition;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log.Logger;
import org.openqa.selenium.WebDriver;

import PageObjects.AddCustomerPage;
import PageObjects.LoginPage;
import PageObjects.SearchCustomerPage;

public class BaseClass {
	public WebDriver driver;
	public LoginPage lp;
	public AddCustomerPage addCust;
	public SearchCustomerPage srchCust;
	public  static org.apache.log4j.Logger logger;
	public static Properties configProp;
	
	public static String randomString()
	{
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return(generatedString1);
	}
}
