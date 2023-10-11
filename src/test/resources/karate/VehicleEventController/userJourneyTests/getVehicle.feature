Feature: Feature test for vehicle data

  Background:
    * url urlBase

  Scenario: try to load and fail for invalid district number
    * def basePath = '/intuit/vehicle/10'
    Given path basePath
    When method get
    Then status 404
    Then match response == { message: "id not found 10", statusCode: '404' }
