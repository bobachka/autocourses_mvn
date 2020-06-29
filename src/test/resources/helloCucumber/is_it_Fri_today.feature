Feature: Is Fri today?
  It's used to know if it's Fri.

  Scenario: Thu is not Fri
    Given Today is Sun
    When I ask if it's Fri today
    Then It says "No"

