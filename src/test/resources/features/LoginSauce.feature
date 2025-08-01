Feature: Login operation

  Scenario: Successful Login
    Given the app is opened
    When I input the username
    And I input the password
    And I press Login
    Then I should be at homepage