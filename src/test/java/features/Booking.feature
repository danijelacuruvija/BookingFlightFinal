Feature: Booking

#  Scenario Outline: Book a Flight row: "<row>"
Scenario: Book a flight
#    Given I load test data from "Booking" "BookingSheet" "<row>"
    Given I navigate to Booking
    Then I navigate to flights page
#    And I select flight class
#    And I select number of adults
#    And I add destinartion
#    Then I add departue and yreturn date
#    Then I check direct flights onl
#    And I click search

#    Examples:
#      | row |
#      | 1   |
#      | 2   |