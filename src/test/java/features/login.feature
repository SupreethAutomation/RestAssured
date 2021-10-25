Feature: Login Feature

  @login
  Scenario: 1. Validate the user is not able to created successfully
    Given the api is successfully running
      | api/users |
    When the user authenticates with the credentials
 		#input
      | eve.holt@reqres.in | pistol |
    Then Validate that the response is valid and token is generated succesfully
 		#input
      | QpwL5tke4Pnpja7X4 |
 