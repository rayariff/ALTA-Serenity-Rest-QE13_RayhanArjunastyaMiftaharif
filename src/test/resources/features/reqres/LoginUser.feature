Feature: To Login User
  @Tugas
  Scenario Outline: Login user with valid json
    Given Login user with valid "<json>"
    When Send request post login user
    Then Status code should be 200
    And Validate login user json schema "LoginUserSchema.json"
    Examples:
      | json       |
      | LoginUser.json |

  @Tugas
  Scenario Outline: Login user with invalid json
    Given Login user with invalid "<json>"
    When Send request post login user
    Then Status code should be 400
    And Validate login user json schema "InvalidLoginSchema.json"
    Examples:
      | json            |
      | LoginUser2.json |
      | LoginUser3.json |