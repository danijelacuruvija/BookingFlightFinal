Feature: Booking

#  Scenario Outline: Book a Flight row: "<row>"
  Scenario: Book a flight

    Given I navigate to Booking
    Then I navigate to flights page
#    Then I choose flight type "1"
    And I select flight class "PREMIUM_ECONOMY"
    And I select number of passengers
    And I add destination "Budapest"
    And I add depart and return date "2022-02-28" "2022-03-05"
#    Then I check direct flights only
    And I click search
    Then I choose flight time "12:00 AM - 17:59 PM"
#    And I select flight
#    Then I verify that flight is to selected destination;
#    Then I choose selected flight;

#    Examples:
#      | row |
#      | 1   |
#      | 2   |