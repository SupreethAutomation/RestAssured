Feature: Search User Feature

  @searchUser
  Scenario: 1. Validate the user is perfrom search operation and validate the response
    Given the api is successfully running
      | api/users |
    When the user searches for the particular user as parameter
 		#input
      | 2 |
    Then Validate that the response is valid and new user is searched succesfully
 		#input
      | 2 | janet.weaver@reqres.in | Janet | Weaver | https://reqres.in/img/faces/2-image.jpg | https://reqres.in/#support-heading | To keep ReqRes free, contributions towards server costs are appreciated! |
 