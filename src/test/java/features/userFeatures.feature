Feature: Test user for Reqres Api

  Scenario: User can register with valid data and show list of users
    Given User has valid register data
    When User sends his data
    Then The token is returned
    And List of users returned