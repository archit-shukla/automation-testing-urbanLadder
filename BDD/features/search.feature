Feature: Search

Scenario: Search using the search bar
  Given User Launch Chrome Browser
  When User opens URL "https://www.urbanladder.com/" 
  Then Enter "Dining Table" in the search bar and press the search button
  Then verify the title with "'Dining Table'"
  And close browser
  
  Scenario: Search using the options available
  Given User Launch Chrome Browser
  When User opens URL "https://www.urbanladder.com/" 
  When User clicks on study and click on the first result
  Then verify title of the product with "Twain Study Table - Urban Ladder"
  And close browser
  
  