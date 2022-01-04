Feature: Test user data

  @user
  Scenario: User can show his profile data
    When User get his data
    Then The response and data are returned
