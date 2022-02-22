Feature: Booking

#  Scenario Outline: Book a Flight row: "<row>"
    Scenario Outline: Book a flight
        Given I navigate to Booking
        Then I navigate to flights page
        And I select flight class <arg0>
        Examples:
            | arg0       |
            | "BUSINESS" |
#    And I select number of adults
#    And I add destinartion
#    Then I add departue and yreturn date
#    Then I check direct flights onl
#    And I click search

#    Examples:
#      | row |
#      | 1   |
#      | 2   |