Feature: Customers

 Background: comon steps for following scenarios
Given open chrome Browser
When navigate to URL "https://admin-demo.nopcommerce.com/login"
And enter username "admin@yourstore.com" and password "admin"
And Click on Login button
Then user can view Dashbord

@sanity 
Scenario: Login with valid credentials
And click on custemers menu
And click on customer menu item
And click on ADDnew cutomerpage
Then user can view Add New customer page
When user can Enter customer info
And click on save button
Then user can view confirmation message "The new customer has been added successfully"
And close browser

@regression
Scenario: Search customer by EmailID
And click on custemers menu
And click on customer menu item
And Enter customer Email
When click on search button 
Then user should found Email in the Search table
And close browser

@regression
Scenario: Search customer by FileName
And click on custemers menu
And click on customer menu item
Then Enter customer FirstName
Then Enter customer LastName
When click on search button
Then user found Name in the Search table
And close browser
