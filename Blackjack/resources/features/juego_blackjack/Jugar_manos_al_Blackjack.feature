Feature: Jugar manos al Blackjack
	As jugador del casino
	I wanto to jugar manos de Blackjack
	In order to ganar la apuestas
	
Background:
	Given "Stu" ha iniciado una partida de Blackjack.
	Given "Stu" ha apostado "10" euros. 
	
Scenario: Pasarse
	Given La mano de Stu es
		| Carta |
		| Jester |
		| Queen |
	When "Stu" pide una carta más
	Then "Stu" recive un "King"
	And "Stu" pierde la mano por pasarse


Scenario: Victoria con Blackjack inicial
	Given La mano de "Stu" es
		| Carta |
		| Jester |
		| As |
	Given La mano del "Croupier"
		| Carta |
		| Jester |
		| King |
	When "Stu" se planta
	Then "Stu" gana la mano
	
	
Scenario: Empate con Blackjack inicial
	Given La mano de "Stu" es
		| Carta |
		| Jester |
		| As |
	Given La mano del "Croupier"
		| Carta |
		| As |
		| King |
	When "Stu" se planta
	Then "Stu" empata la mano con el Croupier
	
	