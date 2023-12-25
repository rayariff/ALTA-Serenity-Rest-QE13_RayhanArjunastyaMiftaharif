Feature: To Create User
  @Tugas
  Scenario Outline: Post create user with valid json
    Given Post Create user with valid json "<json>"
    When Send request post create user
    Then Status code should be 201
    And Response body name was "<name>" and job was "<job>"
    And Validate create user json schema "CreateUserSchema.json"
    Examples:
      | json            | name        | job         |
      | CreateUser.json | Rayhan Arif | QA Engineer |

  @Tugas
  Scenario Outline: Post create user with invalid json
    Given Post create user with invalid json "<json>"
    When Send request post create user
    Then Status code should be 400
    Examples:
      | json             |
      | CreateUser2.json |