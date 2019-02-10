@uc
Feature: filtering functionality of craigslist

  Scenario: filtering test

    Given user goes to the main page "url"
    Then user clicks on the link "motorcycles"
    Then user types in the make and model text box "harley"
    Then user types in the miles text box "150"
    Then user types in the ZIP text box "77498"
    Then user types in the year text box "2005"
    Then user types in the min engine displacement text box "1000"
    When the filtered options of "motorcycles" appear on the page
    Then year of the selected motorcycle must be greater or equal to "2005"
    Then min engine displacement of the selected motorcycle must be greater or equal to "1000"



