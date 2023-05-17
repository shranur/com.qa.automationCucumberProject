Feature: Serach Functionality 

Scenario: User search for a valid product
Given User launch the URL and and open home page
When User search for a valid product in search filed
And User click on search button
Then User should get valid product displayed on search results

Scenario: User search for a Invalid product
Given User launch the URL and and open home page
When User search for a Invalid product in search filed
And User click on search button
Then User should get an error message about No Product Matching