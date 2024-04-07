Feature: Help
Scenario: verify email Id of urban ladder

Given User Launch Chrome Browser
  When User opens URL "https://www.urbanladder.com/" 
  Then click on help button
  Then click on contact us
  Then verify the emailid with "hello@urbanladder.com"
  And close browser
  
  Scenario: Use the help search bar and verify result
  Given User Launch Chrome Browser
  When User opens URL "https://www.urbanladder.com/" 
  Then click on help button
  Then Enter "Payment" in the help seacrh bar
  Then verify the text with the search page "'Payment'"
  And close browser
  