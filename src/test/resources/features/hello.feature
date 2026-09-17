Feature: Hello endpoint

  Scenario: Calling /hello returns a greeting
    Given the application is running
    When I call GET /hello
    Then I get a 200 response
    And the response body is "Hello World"
