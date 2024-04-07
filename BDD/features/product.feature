Feature: Buy the product

Scenario: Add to cart
Given User Launch Chrome Browser
  When User opens URL "https://www.urbanladder.com/" 
   Then Enter "Dining Table" in the search bar and press the search button
   Then click on th first result
   And click on add to cart button
   And verify if product is added to cart with matching url "https://www.urbanladder.com/cart"
   And close browser
   
   
   Scenario: Track Order
   Given User Launch Chrome Browser
  When User opens URL "https://www.urbanladder.com/" 
  Then click on track order button
  Then Enter "12345678" as Order Number and "9867534215" as phone Number
  Then verify text with "Order not found. If you have just placed the order, tracking information will be available after an hour." to see if details entered are correct
  And close browser
  
  