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
@addcustomerFeature
Feature: Add Customer page functionalities in Guru99 Telecom project

	Background: 
  
  @submitButtonSanity
  Scenario: To verify if Submit button click will submit details to create a customer id successfully
  	Given User navigates to Add Customer page
    When User enters customer details
    |			fname			|			lname			|			email					|			addres		|			phnum			|
    |			Steve			|		Jobs				| stevej@gmail.com	|	Atlanta USA		|	12034442210		|
    |		William			|	Shakespeare		| wills@gmail.com		|	England UK		|	444000112345	|
    |		Owen				|	Wilson				|	owenw@ymail.com		|	Chicago USA		|	120678900112	|
    
    And click on Submit button
    Then user will navigate to access page with a customer id displayed

  @resetButtonSanity
  Scenario: To verify if Reset button click will reset the form
		Given User navigates to Add Customer page
    When User enters customer details
    |			fname			|			lname			|			email					|			addres		|			phnum			|
    |			Steve			|		Jobs				| stevej@gmail.com	|	Atlanta USA		|	12034442210		|
    |		William			|	Shakespeare		| wills@gmail.com		|	England UK		|	444000112345	|
    |		Owen				|	Wilson				|	owenw@ymail.com		|	Chicago USA		|	120678900112	|
    And click on Reset button
    Then all fields get cleared and reset
