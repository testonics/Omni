#  Scenario: read account numbers
#    Given I have an account file with contents:
#      """
#        _  _     _  _  _  _  _
#      | _| _||_||_ |_   ||_||_|
#      ||_  _|  | _||_|  ||_| _|
#
#      """
#    When I parse the file
#    Then the first account number is "123456789"
#
#  Scenario: a few cukes
#    Given I have 42 cukes in my belly
#    When I wait 1 hour
#    Then my belly should growl
#
#
#  Scenario: Creating a todo
#    When I type the todo "Do Things!"
#    Then todo list item 1 has text "Do Things!"
