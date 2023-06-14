#Author: Poornima Shri


@SmokeFeature
Feature: Feature to test login functionality

@SmokeTest12  
  Scenario Outline: Check login is successful
    Given user is on login page
    When user enters <username> and <password>
    And clicks on login button
    Then user is navigated to the home page
    
    Examples:
    |username|password|
    |user1|pass1|
    
