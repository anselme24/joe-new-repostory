@End2End 
Feature: Validate login functionality 

Background: 
	Given User is on the techfios Login Page 
	
@Scenario1 
Scenario: User should be able to Login with valid credentials 
	When User enters username as "demo@techfios.com" 
	When User enters password as "abc123" 
	And User clicks on Signin Button         
	Then User should be land on Dashbaord Page 
@Scenario2 
Scenario: User should be able to Login with valid credentials 
	When User enters username as "demo@techfios.com" 
	When User enters password as "abc123" 
	And User clicks on Signin Button         
	Then User should be land on Dashbaord Page 
	
	@Scenario3
	Scenario Outline: User sould be able to login with valid credentials
	When User enters the "<username>"and"<passwoard>" 
	And User clicks on Signin Button   
	Then User should be land on Dashbaord Page
	Examples:
	|username|passwoard|
	|demo@techfios.com|abc123|
	|demo@techfios.com|abc12|
	|demo@techfio.com|abc123|
	
