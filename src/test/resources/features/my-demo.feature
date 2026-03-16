Feature: my web feature

  Background: pre scenario
    Given Preconditions are "OK"

  @wip
  Scenario: my scenario
    Given Set user password to "aaabcabcaaabcabc1"
    Given There parameters are "param 1" and "param 2"
    When I do something 5 times
    Then Something happens with VALUE_3

  @wip
  Scenario Outline: my scenario
    Given Set user password to "<password>"
    Given There parameters are "param 1" and "param 2"
    When I do something 5 times
    Then Something happens with VALUE_1
    Examples:
      | password          |
      | abcabc1           |
      | aaabcabc          |
      | aaabcabcaaabcabc1 |


  @wip
  Scenario: demo data table
    Given Data table list demo
      | String 1 |
      | String 2 |
      | String 3 |
      | String 4 |
    Given Data table map demo
      | key_1 | value_1 |
      | key_2 | value_2 |
      | key_3 | value_3 |
      | key_4 | value_4 |


#    password must be 8-16 symbols and 1 digit
  # NEgative: 7 symbols with digit
  # negative: 8 symbols without digit
  # negative: 17 symbols with digit