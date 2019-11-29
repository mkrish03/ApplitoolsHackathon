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
@tag
Feature: Visual AI Test Suite

  @tag1
  Scenario: Title of your scenario
    Given Launch the Demo APP version2
    Then Verify login page
    And Click on the  login button
    Then Verify the no credentials warning message
    When Enter Username
    And Click on the  login button
    Then Verify the Password warning message
    And Clear Username field
    And Enter Password
    And Click on Login
    Then Verify the Username warning message
    When Enter Username
    And Enter Password
    And Click on Login
    Then Verify the Home page
    And Click on Amount
    Then Verify the Amount sorting
    And Click on Compare Expenses
    Then Verify the Canvas chart page

