Feature: Hola cucumber
	# Escenario de ejemplo de cucumber
	
Scenario: saludar a Cucumber
	Given soy "Javier"
	When saludo a Cucumber
	Then Cucumber me responde "Hola Javier" 
	
Scenario: tabla
	Given La siguiente tabla
	| x | y |
	| 1 | 2 |
	
	