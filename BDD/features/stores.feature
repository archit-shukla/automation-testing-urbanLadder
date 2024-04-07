Feature: Store Locations

Scenario: verify Store locations
Given User Launch Chrome Browser
  When User opens URL "https://www.urbanladder.com/"
  Then click on store button
  When click on view details of the store location
  Then verify the location with "Pune"
  And close browser