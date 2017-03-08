Feature: jugar al blackjack

@foto03
Scenario: jugador ganador
	Given Cada jugador tiene 2 cartas
	And El jugador "A" obtiene las cartas "As" y "King"
	When se resuelve la partida
	Then el jugador "A" gana la partida
