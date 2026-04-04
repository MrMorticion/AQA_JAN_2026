@wip
Feature: Allo web feature

  Scenario: Search iPhone on Allo and compare prices with DB
    Given I open Allo main page
    When I accept Allo cookies if present
    And I search Allo for "iphone"
    Then I save first 3 Allo phone models and prices as "allo_phones"
    And I check Allo phones in DB from "allo_phones" and save missing ones