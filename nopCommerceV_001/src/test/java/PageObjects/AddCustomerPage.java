package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class AddCustomerPage {
	
	public WebDriver ldriver;
	
	
	public AddCustomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}
		By linkCustomers_menu = By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a/p");
		By linkCustomer_menuitem = By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a/p");
		By AddCustomerBtn = By.xpath("//a[normalize-space()='Add new']");
		
		By txtCustomerRoles = By.xpath("//div[@class='k-widget k-multiselect k-multiselect-clearable']");
		
		By txtEmail= By.xpath("//input[@id='Email']");
		By txtPassword =By.xpath("//input[@id='Password']");
		
		By listAdministrator =By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[1]");
		By listGuests =By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[3]");
		By listRegistered =By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[4]");
		By listVendors =By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[5]");
		By drpmgrOfVendor= By.xpath("//*[@id=\"VendorId\"]");
		By rdioMale=By.id("Gender_Male");
		By rdioFeMale=By.id("Gender_Female");
		
		By txtFirstName =By.xpath("//input[@id='FirstName']");
		By txtLastName =By.xpath("//input[@id='LastName']");
		By dob=By.id("DateOfBirth");
		By txtCmpnyName=By.id("Company");
		By txtAdminCommnt=By.id("AdminComment");
		By btnSave = By.xpath("/html/body/div[3]/div[1]/form/div[1]/div/button[1]");
		
		
	
	public void clickOnCustomerMenu() throws InterruptedException
	{
		ldriver.findElement(linkCustomers_menu).click();
		
	}
	
	public void clickOnCustmrMenuItem() throws InterruptedException
	{
		
		ldriver.findElement(linkCustomer_menuitem).click();
		
	}
	
	public void clickOnAddNew() throws InterruptedException
	{
		ldriver.findElement(AddCustomerBtn).click();
		Thread.sleep(3000);
	}
	
	public void setEmailString(String email) throws InterruptedException
	{
		Thread.sleep(3000);
		ldriver.findElement(txtEmail).sendKeys(email);		
	}
	
	public void setPassword(String pwrd)
	{
		ldriver.findElement(txtPassword).sendKeys(pwrd);
	}
	
	public void setCustmrRole(String role) throws InterruptedException
	{
		Thread.sleep(4000);
//		if(!role.equals("Vendors"))
//		{
//			Thread.sleep(3000);
//			ldriver.findElement(By.xpath("//*[@id=\"VendorId\"]"));
//			}
		
		//ldriver.findElement(txtCustomerRoles).click();
		
		WebElement listitem;
		listitem = ldriver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]/span"));
		JavascriptExecutor js = (JavascriptExecutor)ldriver;
		js.executeScript("arguments[0].click();", listitem);
		
		
		
		if(role.equals("Administrators"))
		{
			listitem = ldriver.findElement(listAdministrator);
		}
		else if(role.equals("Guests"))
		{
			
			listitem = ldriver.findElement(listGuests);
		}
		else if(role.equals("Registered"))
		{
			listitem = ldriver.findElement(listRegistered);
		}
		else if(role.equals("Vendors"))
		{
			listitem = ldriver.findElement(listVendors);
		}
		else
		{
			listitem = ldriver.findElement(listGuests);
		}
		
		//listitem.click();
		
		
		JavascriptExecutor js1 = (JavascriptExecutor)ldriver;
		js1.executeScript("arguments[0].click();", listitem);
	}
	
	public String getPageTitle()
	{
		return ldriver.getTitle();
	}
	
	public void setManagerOfVendor(String value)
	{
		Select drp = new Select(ldriver.findElement(drpmgrOfVendor));
		drp.selectByValue(value);
	}
	
	public void setGender(String gender)
	{
		if(gender.equals("Male"))
		{
			ldriver.findElement(rdioMale).click();
		}else if(gender.equals("Female"))
		{
			ldriver.findElement(rdioMale).click();
		}else
		{
			ldriver.findElement(rdioFeMale).click();
		}
	}
	
	
	
	public void clickSave()
	{
		ldriver.findElement(btnSave).click();
	}
	
	public void setCompanyName(String cmpName)
	{
		ldriver.findElement(txtCmpnyName).sendKeys(cmpName);
	}
	
	public void setAdminCommnt(String admnName)
	{
		ldriver.findElement(txtAdminCommnt).sendKeys(admnName);
	}
	
	public void setFirstName(String frstName)
	{
		ldriver.findElement(txtFirstName).sendKeys(frstName);
	}
	
	public void setlastName(String lstName)
	{
		ldriver.findElement(txtLastName).sendKeys(lstName);
	}
	
	public void setdob(String dtob)
	{
		ldriver.findElement(dob).sendKeys(dtob);
	}
	
	
}
