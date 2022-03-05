Feature: Booking

#  Scenario Outline: Book a Flight row: "<row>"
  Scenario: Book a flight

    Given I navigate to Booking
    Then I navigate to flights page
#    Then I choose flight type "1"
    And I select flight class "PREMIUM_ECONOMY"
    And I select number of passengers
    And I add destination "Budapest"
    And I add depart and return date "2022-03-27" "2022-03-30"
#    Then I check direct flights only
    And I click search
    Then I choose flight time "12:00 PM - 5:59 PM"
    And I select flight
    #Then I verify that flight is to selected destination "Budapest"
    Then I choose selected flight
    Then I select ticket details
    Then I enter contact data "RS"
    Then I enter passenger data "2"
    Then I click next button
    Then I click next for Baggage and extras
  Then I click to skip choosing seat
  #Then I verify flight

#    Examples:
#      | row |
#      | 1   |
#      | 2   |