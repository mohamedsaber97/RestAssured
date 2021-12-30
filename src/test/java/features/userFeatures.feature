Feature: Test user for Reqres Api

  @sanity
  Scenario: User can register with valid data and show list of users
    Given User has valid register data
    When User sends his data
    And List of users returned

    @functionality
    Scenario: User upload pet image
      Given User has pet id
      When User send pet data
      Then Response is printed