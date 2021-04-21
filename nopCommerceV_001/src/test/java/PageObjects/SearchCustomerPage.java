package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.WaitHelper;

public class SearchCustomerPage {
	public WebDriver ldriver;
	WaitHelper waitHelper;
	
	public SearchCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
		waitHelper = new WaitHelper(ldriver);
	}
	
		@FindBy(id="SearchEmail")
		@CacheLookup
		WebElement txtEmail;
		
		@FindBy(id="SearchFirstName")
		@CacheLookup
		WebElement txtFrstName;
		
		@FindBy(id="SearchLastName")
		@CacheLookup
		WebElement txtLstName;
		
		@FindBy(id="search-customers")
		@CacheLookup
		WebElement srchBtn;
		
		@FindBy(xpath="//table[@role='grid']")
		@CacheLookup
		WebElement tblSrchResults;
		
		@FindBy(xpath="//table[@id='customers-grid']")
		@CacheLookup
		WebElement table;
		
		@FindBy(xpath="//table[@id='customers-grid']//tbody/tr")
		@CacheLookup
		List<WebElement> tableRows; 
		
		@FindBy(xpath="//table[@id='customers-grid']//tbody/tr/td")
		@CacheLookup
		List<WebElement> tableColumns; 
		
		public void setEmail(String email) throws InterruptedException
		{
			waitHelper.WaitForElement(txtEmail,30);
			txtEmail.clear();
			txtEmail.sendKeys(email);
			Thread.sleep(4000);
		}
		public void setFrstName(String fname) throws InterruptedException
		{
			waitHelper.WaitForElement(txtFrstName,30);
			txtFrstName.clear();
			txtFrstName.sendKeys(fname);
			Thread.sleep(4000);
		}
		public void setLstName(String lname) throws InterruptedException
		{
			waitHelper.WaitForElement(txtLstName,30);
			txtLstName.clear();
			txtLstName.sendKeys(lname);
			Thread.sleep(4000);
		}
		
		public void clickSearch() throws InterruptedException
		{
			srchBtn.click();
			waitHelper.WaitForElement(srchBtn, 30);
			Thread.sleep(40000);
		}
		
		public int getNoOfRows()
		{
			return(tableRows.size());
		}
		public int getNoOfCols()
		{
			return(tableColumns.size());
		}
		
		public boolean searchCustomerByEmail(String email)
		{
			boolean flag=false;
			for(int i=1;i<=getNoOfRows();i++)
			{
				String emailid=table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[2]")).getText();
				System.out.println(emailid);
				if(emailid.equals("victoria_victoria@nopCommerce.com"))
				{
					flag=true;
				}
				
			}
			return flag;
		}
		
		public boolean searchCustomerByName(String Name)
		{
			boolean flag=false;
			for(int i=1;i<=getNoOfRows();i++)
			{
				String name=table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[3]")).getText();
				System.out.println(name);
				if(name.equals("Victoria Terces"))
				{
					flag=true;
				}
				
			}
			return flag;
		}


}
