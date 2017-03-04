Feature: Obtener puntos plus
	As administrador del casino
	I want ofrecer puntos plus a los jugadores que apuestan
	In order to fidelizarlos para que juegen más en el casino

	
Scenario: Obtener puntos plus
	Given "Stu" tiene en su depósito "10" euros. 
	When "Stu" apuesta euros
		| 1 |
		| 2 |
		| 3 |
	Then "Stu" obtiene puntos plus
		| 2 |
		| 4 |
		| 6 |
