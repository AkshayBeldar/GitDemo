
@tag
Feature: Error Validations
  I want to use this template for my feature file


  @tag2
Scenario Outline: Positive Test of Submitting the order
    Given I landed on Ecommerce Page
    Given Logged in with username <name> and password <password> 
    Then "Incorrect email  password." message is displayed 

    Examples: 
      | name                  |  password        |
      | Akshays@gmail.com     |  Akshay@         | 
     
