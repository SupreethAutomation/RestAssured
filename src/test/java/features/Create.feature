Feature: Create User Feature

  @createUser
  Scenario: 2. Validate the user is able to create new users
    Given the api is successfully running
      | api/users |
    When the user creates new Users
 		#input
      | Jack | Captain |
    Then Validate that the response is valid and new user is created succesfully
 		#input
      | Jack | Captain |
 