Feature: Goodbye endpoint

  Scenario: Calling /goodbye returns a farewell
    Given the application is running
    When I call GET "/goodbye"
    Then I get a 200 response
    And the response body is "Goodbye World"
