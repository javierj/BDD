Feature: Búsquedas avanzadas


Scenario: Búsqueda de juegos por precio rebajado
	Given El juego "13th Age: Shadows of Eldolan" con precio normal "17.95" y precio reducido "14.95"
	When Hago una busqueda avanzada de juegos entre "10" y "15" euros
	Then El juego aparece en los resultados 
