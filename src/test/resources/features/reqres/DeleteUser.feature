Feature: To Delete User
  @Tugas
  Scenario Outline: Delete user with invalid id
    Given Delete user with invalid "<id>"
    When Send request delete user
    Then Status code should be 404
    Examples:
      | id |
      | a  |

  @Tugas
  Scenario Outline: Delete user with not found id
    Given Delete user with not found <id>
    When Send request delete user
    Then Status code should be 404
    Examples:
      | id         |
      | 1000000000 |