Feature: Test authentication for client

  @register
  Scenario: User can register with valid data
    Given User has valid register data
    When User sends his data
    Then The response is returned and user saves userId and activation code

  @login
  Scenario Outline: User can login with valid data
    Given User has "<phone>" and "<password>"
    When User sends his login data
    Then The response is returned and user saves userId and activation code
    Examples:
      | phone      | password |
      | 0100100100 | 12345678 |
      | 0100000099 | 123456   |
      | 0100000099 | 12345678 |
      | 0100100100 | 123456   |