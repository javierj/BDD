Feature: Jugar al Blackjack
As X
I want
In order to


@clase
Scenario: Jugador tiene Blackjack de mano inicial
	Given El croupier tiene un "6" y una "Jester"
	And El jugador tiene un "As" y un "Queen"
	When La partida se resuelve
	Then El jugador gana

@clase
Scenario: Jugador tiene Blackjack de mano inicial
	Given El croupier tiene un "6" y una "Jester"
	When El jugador recibe un "As" 
	And El jugador recibe un "Queen"
	Then La partida termina
	And El jugador gana

@clase	
Scenario: Jugador solicita una carta y pierde
	Given El croupier tiene un "10" y una "8"
	And El jugador tiene un "3" y un "9"
	When El jugador recibe un "King"
	Then La partida termina
	And El jugador pierde

@clase	
Scenario: Jugador solicita dos cartas y pierde
	Given El croupier tiene un "10" y una "8"
	And El jugador tiene un "3" y un "9"
	When El jugador recibe un "6"
	When El jugador recibe un "King"
	Then La partida termina
	And El jugador pierde
	