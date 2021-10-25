Feature: Register Feature

  @register
  Scenario: 1. Validate the user is able to successfully register and id and token are generated
    Given the api is successfully running
      | api/register |
    When user registers with the email and password
 		#input
      | eve.holt@reqres.in | pistol |
    Then Validate that the response is valid and token is generated succesfully
 		#input
      | QpwL5tke4Pnpja7X4 |
