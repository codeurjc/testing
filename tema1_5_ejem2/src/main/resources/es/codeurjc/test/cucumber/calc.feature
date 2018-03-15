Feature: Calculator
  As a user
  I want to use a calculator to add numbers
  So that I don't need to add myself
 
  Scenario: Add two numbers -2 & 3
    Given I have a calculator
    When I add -2 and 3
    Then the result should be 1
    
  Scenario: Add two numbers 10 & 15
    Given I have a calculator
    When I add 10 and 15
    Then the result should be 25