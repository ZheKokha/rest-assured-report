Feature: Get user
  Scenario: User calls web service to get user
    When a user retrieves the user information
    Then the response status code is 200
    And response includes the following
      | name	| Leanne Graham|