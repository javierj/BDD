Feature: Transferences among accounts of the same owner

Scenario: Valid transference
	Given the accounts of Bob
		| Id | Amount | 
		| 01 |    1000|
		| 02 |    3000| 
	When Bob transfers 500 from account "01" to account "02"
	Then The balance of his accounts are
		| Id | Amount | 
		| 01 |    500 |
		| 02 |    3500| 

Scenario: Valid transference (alt impl)
	Given the accounts of Bob (alt impl)
		| Id | Ammount | 
		| 01 |    1000|
		| 02 |    3000| 
