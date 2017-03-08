Feature: money loans
	Examples of transforms
	
Scenario: A loan
	Given I have "30" euros
	When I loan "14,37" euros
	Then I only have "15,63" euros
	
Scenario: A list of money
	Given I have: 30,40,10 euros

	