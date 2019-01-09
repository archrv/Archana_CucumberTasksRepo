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

Feature: To test Add Tariff Plan functionality in Guru99 website

  Scenario Outline: To test success message when user adds various tariff plans
    Given The user navigates to Add Tariff Plans page
    When the user fills in the plan details "<monthlyrental>", "<freelocalmins>", "<freeinternationalmins>", "<freesmspack>", "<localpermincharg>", "<internationalpermincharg>", "<smscharg>"
    And the user clicks on Submit button
    Then verify that a success message is displayed with customer id

    Examples: 
      | monthlyrental  | freelocalmins | freeinternationalmins  |	freesmspack	|	localpermincharg	|	internationalpermincharg	|	smscharg	|
      | 299						 |     10					| 	1 									|	100					|	50								|	150												|	5					|
      | 399						 |     100				| 	10 									|	200					|	30								|	170												|	3					|
      | 599						 |     300				| 	20 									|	100					|	20								|	50												|	1					|
