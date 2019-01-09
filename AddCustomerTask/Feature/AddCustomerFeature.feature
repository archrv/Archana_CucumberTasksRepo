#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: To test Add Customer functionality in Telecom Project

  
  Scenario: To test Success message when the user clicks Submit button
    Given the user navigates to Add Customer page
    When the user fills in customer details
    And clicks on Submit button
    Then the user navigates to Access Details page with a success message
    And the user will obtain a customer id

  