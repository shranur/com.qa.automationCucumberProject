Feature: Registration Functionality

Scenario: Registering an User with Mandatory fields 
Given User is on Register Account page
When User enters the details into below fields
|firstName|Anurag|
|lastName|Test|
|email|anurag.ec27@gmail.com|
|telephone|123456789|
|password|Password|
And User select Privacy Policy
And User click on Continue button
Then User account should get created successfully

Scenario: Registering an User with All fields 
Given User is on Register Account page
When User enters the details into below fields
|firstName|Anurag|
|lastName|Test|
|email|anurag.ec27@gmail.com|
|telephone|123456789|
|password|Password|
And User select Yes for Newsletter
And User select Privacy Policy
And User click on Continue button
Then User account should get created successfully

Scenario: User creates duplicate account
Given User is on Register Account page
When User enters the details into below fields
|firstName|Anurag|
|lastName|Test|
|email|anurag.ec27@gmail.com|
|telephone|123456789|
|password|Password|
And User select Privacy Policy
And User click on Continue button
Then User should see the error message for duplicate account 

Scenario: User creates the account without filing any details
Given User is on Register Account page
And User click on Continue button
Then User should see the warning message for filling fields 