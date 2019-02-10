
Feature: filtering functionality of craigslist 2

  Scenario Outline: filtering test 2

    Given user goes to the main page "url"
    Then user clicks on the link "motorcycles"
    Then user types in the make and model text box "harley"
    Then my user types in the miles text box "<miles>"
    Then user types in the ZIP text box "77498"
    Then  my user types in the year text box "<year>"
    Then user types in the min engine displacement text box "<engineSize>"

    Examples:
      | year | engineSize |
      | 2010 | 1800       |
      | 2015 | 2200       |



