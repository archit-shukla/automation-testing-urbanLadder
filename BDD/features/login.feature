Feature: login and sign up

Scenario: Successful Login with valid credentials
  Given User Launch Chrome Browser
  When User opens URL "https://www.urbanladder.com/" 
  And User enters Email as "archit.601@gmail.com" and password as "archit shukla"
  And click on Login
  Then Page Title should be "Furniture Online: @Upto 40% Off on Wooden Furniture Online in India at Best Price - Urban Ladder"
  When User click on logout link
  And close browser
  
  Scenario Outline: Login Unsuccessful
Given User Launch Chrome Browser
When User opens URL "https://www.urbanladder.com/" 
And User enters Email as "<email>" and password as "<password>"
And click on Login
Then Page Title should be "Furniture Online: @Upto 40% Off on Wooden Furniture Online in India at Best Price - Urban Ladder" 
And close browser

Examples: 
|email| |password|
|abc@gmail.com| |12345678|
|ghi@hotmail.com| |456789123|
|klm@yahoo.com| |abcdefghij|

Scenario Outline: Sign up
Given User Launch Chrome Browser
When User opens URL "https://www.urbanladder.com/" 
Then press the login button and click on signup
And user enters "<emailid>" and "<password>"
And click on Submit 
Then current URL should be "https://www.urbanladder.com/signup"
And close browser

Examples:
|emailid| |password|
|abc@gmail.com| |12345678|
|ghi@hotmail.com| |456789123|
|klm@yahoo.com| |abcdefghij|

