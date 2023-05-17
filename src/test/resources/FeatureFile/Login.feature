Feature: Login Functionality

Scenario: Login with valid credentials
Given User is on login page
When User enters valid email address "anuragshrivastava007@gmail.com"
And User enter valid password "Password#23"
And User clicks on Login Button
Then User should login successfully

Scenario: Login with invalid credentials
Given User is on login page
When User enters invalid email address "xyz@abh.com"
And User enter invalid password "123456789"
And User clicks on Login Button
Then User should  not login successfully and see an error message 

Scenario: Forget password link is displayed
Given User is on login page
Then forget your password link should be displayed

Scenario: Login Page title
Given User is on login page
Then Login page title should be "Account Login"

