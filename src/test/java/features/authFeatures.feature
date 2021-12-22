Feature: Test authentication for Reqres Api

  @valid
  Scenario: User can register with valid data
    Given User has valid register data
    When User sends his data
    Then The token is returned

  @invalid
  Scenario Outline: User can register with invalid data
    Given User has "<email>" and "<password>"
    When User sends his data
    Then The error is returned

    Examples:
      | email     | password  |
      | saber1234 |           |
      |           | 123456789 |
      | saber1234 | 123456789 |