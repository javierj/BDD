Feature: Obtener puntos plus
	As administrador del casino
	I want ofrecer puntos plus a los jugadores que apuestan
	In order to fidelizarlos para que juegen m�s en el casino

	
Scenario: Obtener puntos plus
	Given "Stu" tiene en su dep�sito "10" euros. 
	When "Stu" apuesta euros
		| 1 |
		| 2 |
		| 3 |
	Then "Stu" obtiene puntos plus
		| 2 |
		| 4 |
		| 6 |
