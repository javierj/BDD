Feature: Jugar al Blackjack



@foto02
Scenario: Jugador se pasa de mano
	Given El usuario tiene un "10" y un "7"
	When El jugador pide una carta y recibe un "8"
	Then La partida termina
	And El jugador pierde
