Feature: Website Registration

  @SmokeTest @Reg
  Scenario Outline: Regiszter in a website of your scenario outline
    Given launch the url
    When the user enters '<Username>' and '<Password>'
    Then the user clicks on Login button
    And the user validates the Login success

    Examples: 
      | Username                | Password     |
      | standard_user           | secret_sauce |
      | locked_out_user         | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |
