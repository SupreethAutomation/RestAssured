Feature: Update User Feature

  @updateUser
  Scenario: 1. Validate the admin is able to update the user details succesfully
    Given the api is successfully running
      | api/users |
    When the admin updates the user details
 		#input
      | 2 | Jack | Captain |
    Then Validate that the response is valid and new user is updated succesfully
 		#input
      | Jack | Captain |

  @patchUser
  Scenario: 2. Validate the admin is able to patch the user details succesfully
    Given the api is successfully running
      | api/users |
    When the admin patches the user details
 		#input
      | 2 | Jack | Captain |
    Then Validate that the response is valid and new user is updated succesfully
 		#input
      | Jack | Captain |