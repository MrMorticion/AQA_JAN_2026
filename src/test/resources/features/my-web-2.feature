Feature: Test with API + DB + Selenium

  @wip
  Scenario: Retrieve, store and google random people
    #API
    Given I request 3 random people from service as "crowd_1"
    #DB
    Given I store "crowd_1" in DB
    When I pick 1 random person from DB as "random_group_1"
    #WEB
    When I open google main page
    When I accept cookies if present
    Then I set search field to "random_group_1" first and last name

  Scenario: Retrieve, store and google random people
    #API
    Given I request 2 random people from service as "crowd_1"
    Given I request 5 random people from service as "crowd_2"
    #DB
    Given I store "crowd_1" in DB
    Given I store "crowd_2" in DB
    When I pick 1 random person from DB as "random_group_1"
    When I pick 1 random person from DB as "random_group_2"
    #WEB
    When I open google main page
    When I accept cookies if present
    Then I set search field to "random_group_1" first and last name
    When I open google main page
    When I accept cookies if present
    Then I set search field to "random_group_2" first and last name

  @wip
  Scenario: Retrieve, store and google random people
    Given List of names as "characters"
      | Harry Potter |
    #WEB
    When I open google main page
    When I accept cookies if present
    Then I set search field to "characters" first and last name

  Scenario: Prepare and store predefined person
    Given Prepare person data for DB as "Main Protagonist"
      | FirstName | Harry  |
      | LastName  | Potter |
      | Title     | Mr     |
      | Gender    | Male   |
      | Nat       | UK     |
    Given I store "Main Protagonist" in DB
    @allo
      Scenario: Search iPhone on Allo and compare prices with DB
        Given I open Allo main page
        When I accept Allo cookies if present
        And I search Allo for "iphone"
        Then I save first 3 Allo phone models and prices as "allo_phones"
        And I check Allo phones in DB from "allo_phones" and save missing ones