Feature: Test authentication for client

  @auth @register
  Scenario: User can register with valid data
    Given User has valid register data
    When User sends his register data
    Then The response and data are returned

  @auth @login
  Scenario Outline: User can login with data
    Given User has "<phone>" and "<password>" to login
    When User sends his login data
    Then The response and data are returned
    Examples:
      | phone      | password |
      | 0100100100 | 12345678 |
      | 0100000099 | 123456   |
      | 0100000099 | 12345678 |
      | 0100100100 | 123456   |