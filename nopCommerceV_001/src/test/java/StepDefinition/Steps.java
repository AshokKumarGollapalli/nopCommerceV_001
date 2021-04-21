package StepDefinition;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By; 
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import PageObjects.AddCustomerPage;
import PageObjects.LoginPage;
import PageObjects.SearchCustomerPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Steps extends BaseClass{

	@Before
	public void setup() throws IOException 
	{
		logger = Logger.getLogger("nopCommerce");
		PropertyConfigurator.configure("log4j.properties");
		
		
		configProp = new Properties();
		
		FileInputStream configPropfile =new FileInputStream("config.properties");
		
		configProp.load(configPropfile);
		
		
		String br = configProp.getProperty("browser");
		
		if(br.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver = new ChromeDriver();
		}else if(br.equals("Firefox"))
			
		{
			WebDriverManager.firefoxdriver().setup();
			//System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxpath());
			driver = new FirefoxDriver();
		}else if(br.equals("IE"))
			
		{
			WebDriverManager.iedriver().setup();
			//System.setProperty("webdriver.ie.driver", readconfig.getIEpath());
			driver = new InternetExplorerDriver();
		}
		
		
		
		logger.info("*********LaunchingURL***********");
		
	}
	@Given("open chrome Browser")
	public void open_chrome_browser() {
		lp = new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@When("navigate to URL {string}")
	public void navigate_to_URL(String url) {
		logger.info("*********Opening URL***********");
		driver.get(url);
	}

	@When("enter username {string} and password {string}")
	public void enter_username_and_password(String uname, String pwrd) throws InterruptedException {
		
		logger.info("*********Providing Login Details***********");
		lp.setUserName(uname);
		lp.setPasswrd(pwrd);
		
	}



	@When("Click on Login button")
	public void click_on_login_button() throws InterruptedException {
		logger.info("*********Started login***********");
		lp.clikLogin();
		
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String title) throws InterruptedException {

		if(driver.getPageSource().contains("Login was unsuccessful"))
		{
			
			driver.quit();
			logger.info("********* Login passed ***********");
			Assert.assertTrue(true);
		}else
		{
			logger.info("*********Login failed***********");
			Assert.assertEquals(title,driver.getTitle());
		}
		
	}

	@When("click on logout link")
	public void click_on_logout_link() throws InterruptedException {
		logger.info("*********Logged out***********");
		lp.ClikLogout();
		
	}

	@Then("user can view Dashbord")
	public void user_can_view_dashbord() throws InterruptedException {
		
		logger.info("*********displaying Dash board***********");
		addCust=new AddCustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration",addCust.getPageTitle());
		
	}

	@Then("click on custemers menu")
	public void click_on_custemers_menu() throws InterruptedException {
		logger.info("*********click on customer menu***********");
		addCust.clickOnCustomerMenu();
		
	}

	@Then("click on customer menu item")
	public void click_on_customer_menu_item() throws InterruptedException {
		logger.info("*********click on customer menu item***********");
		addCust.clickOnCustmrMenuItem();   
		
	}

	@Then("click on ADDnew cutomerpage")
	public void click_on_ad_dnew_cutomerpage() throws InterruptedException {
		logger.info("*********entered in to AddNew customer page***********");
		addCust.clickOnAddNew();
		
	}

	@Then("user can view Add New customer page")
	public void user_can_view_add_new_customer_page() throws InterruptedException {
		logger.info("*********Verifying Add new page***********");
		Assert.assertEquals("Customers / nopCommerce administration", addCust.getPageTitle());
	
	}

	@When("user can Enter customer info")
	public void user_can_enter_customer_info() throws InterruptedException {
		logger.info("*********Filling all details in customer information***********");
		String email=randomString()+"@gmail.com";
		addCust.setEmailString(email);
		addCust.setPassword("test123");
		

		addCust.setGender("Male");
	
		addCust.setFirstName("Pavan");
		addCust.setlastName("Kumar");
		addCust.setdob("07/05/1985");
		addCust.setCompanyName("busyQA");
		addCust.setAdminCommnt("This is for Testing");

		addCust.setCustmrRole("Guests");
		
		addCust.setManagerOfVendor("2");
		
	}

	@When("click on save button")
	public void click_on_save_button() throws InterruptedException {
		logger.info("*********saving all customer details***********");
		
		addCust.clickSave();
	}

	@Then("user can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg) {
		logger.info("*********Viewing confirmation message***********");
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully."));
	}
	@Then("close browser")
	public void close_browser() {
		logger.info("*********closing Browser***********");
		driver.quit();

	}

	//search customer by using email

	@Given("Enter customer Email")
	public void enter_customer_email() throws InterruptedException {
		logger.info("*********Entering cutomer email***********");
		srchCust=new SearchCustomerPage(driver);
		srchCust.setEmail("victoria_victoria@nopCommerce.com");

	}

	@When("click on search button")
	public void click_on_search_button() throws InterruptedException {
		logger.info("*********clickin on search button***********");
		srchCust.clickSearch();
		
	}

	@Then("user should found Email in the Search table")
	public void user_should_found_email_in_the_search_table() {
		logger.info("*********verifying customer email found or not***********");
		boolean status = srchCust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
		Assert.assertEquals(true,status);
	}
	//search customer by using firstname and last name


	@Then("Enter customer FirstName")
	public void enter_customer_first_name() throws InterruptedException {
		logger.info("*********Entering first name ***********");
		srchCust=new SearchCustomerPage(driver);

		srchCust.setFrstName("Victoria");
	}

	@Then("Enter customer LastName")
	public void enter_customer_last_name() throws InterruptedException {
		logger.info("*********Entering Last Name***********");
		srchCust.setLstName("Terces");
	}


	@Then("user found Name in the Search table")
	public void user_found_name_in_the_search_table() {
		logger.info("*********verifying customer Name***********");
		boolean status = srchCust.searchCustomerByName("Victoria Terces");
		Assert.assertEquals(true,status);

	}

}
