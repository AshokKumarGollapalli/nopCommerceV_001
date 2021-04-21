Feature: Login

@sanity
Scenario: Login with valid credentials
Given open chrome Browser
When navigate to URL "https://admin-demo.nopcommerce.com/login"
And enter username "admin@yourstore.com" and password "admin"
And Click on Login button
Then page title should be "Dashboard / nopCommerce administration"
When click on logout link
Then page title should be "Your store. Login"
And close browser

@Regression
Scenario Outline: Login with valid credentials
Given open chrome Browser
When navigate to URL "https://admin-demo.nopcommerce.com/login"
And enter username "<username>" and password "<password>"
And Click on Login button
Then page title should be "Dashboard / nopCommerce administration"
When click on logout link
Then page title should be "Your store. Login"
And close browser

Examples: 
|		username		| 		password		|
|	admin@yourstore.com	|		admin			|
|	admin@yoursto		|		admin			|


