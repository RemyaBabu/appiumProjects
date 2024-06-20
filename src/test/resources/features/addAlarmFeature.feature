
@addAlarm
Feature: Add new Alarm
  As a user I want to add new alrm in clock app

  @add
  Scenario Outline: Check add new alrm functionality
    Given User opens clocks app
    And User clicks alarm
    And User clicks plus icon
    And User set up new time
    When User clicks ok
    Then New alarm <time> added successfully

    Examples: 
      | time     |
      | 3:20 |
