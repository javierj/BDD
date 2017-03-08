Feature: Jugar al Blackjack
# Primera foto


@foto01
Scenario: El jugador gana partida con dos cartas
	Given Tengo 2 cartas iniciales con 21 puntos
	And El croupier saca 17 puntos
	When Se resuelve la partida
	Then Gano partida
	And Me llevo 3 a 2
