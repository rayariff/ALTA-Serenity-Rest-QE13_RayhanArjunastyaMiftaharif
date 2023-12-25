Feature: To Register New User
  @Tugas
  Scenario Outline: Register user with valid json
    Given Register user with valid "<json>"
    When Send request post register user
    Then Status code should be 200
    And Validate register user json schema "RegisterUserSchema.json"
    Examples:
      | json              |
      | RegisterUser.json |

  @Tugas
  Scenario Outline: Register user with invalid json
    Given Register with invalid "<json>"
    When Send request post register user
    Then Status code should be 400
    And Validate register user json schema "InvalidRegisterSchema.json"
    Examples:
      | json               |
      | RegisterUser2.json |
      | RegisterUser3.json |

