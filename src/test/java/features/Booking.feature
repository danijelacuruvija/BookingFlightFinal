Feature: Booking

#  Scenario Outline: Book a Flight row: "<row>"
  Scenario: Book a flight
    Given I navigate to Booking
    Then I navigate to flights page
    #Then I choose flight type "1"
    And I select flight class "PREMIUM_ECONOMY"
    And I select number of passengers
    And I add destination "Budapest"
    And I add depart and return date "2022-02-28" "2022-03-05"
#    Then I check direct flights onl
   And I click search

#    Examples:
#      | row |
#      | 1   |
#      | 2   |