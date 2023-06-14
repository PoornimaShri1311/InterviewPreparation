
Feature: To test google Search functionality
  
  @GoogleSearch
  Scenario Outline: Test Google search functionality
    Given browser is open
    And User is on google search page
    When User enters a text in search box
    And hits enter
    Then User is navigated to search results

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
     
