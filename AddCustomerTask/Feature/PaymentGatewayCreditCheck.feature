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
@paymentgatewayfeature
Feature: Payment Gateway functionality in Guru99
  
  @paymentsuccess
  Scenario Outline: To verify if payment is successful with Order Id displayed
    Given User navigates to payment gateway homepage
    When User clicks on Pay button
    And enters credit card details as "<cardno>", "<expirymonth>", "<expiryyear>", "<cvv>"
    And User clicks on Pay button
    Then User sees a success message with an Order id generated
    
    Examples: 
      | cardno  					| expirymonth | expiryyear  |	cvv	|
      | 1122334455667788  |     04			| 2019				| 123	|
      

  @creditcheck
   Scenario Outline: To check credit card balance after payment
    Given User navigates to payment gateway homepage
    When clicks on Credit Check Limit button
    And submits card number as "<ccardno>"
    Then User should see Credit Card Balance amount displayed
    
    Examples: 
      | ccardno  					|
      | 1122334455667788  |
   
    
