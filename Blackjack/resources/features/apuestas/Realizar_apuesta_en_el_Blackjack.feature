Feature: Realizar apuesta en el Blackjack
	As jugador del casino
	I want apostar en el Blackjack
	In order to ganar saldo

Background:
	Given Las apuestas mínimas y máximas del Blackjack.
	| juego | apuesta_minima | apuesta-maxima |
	| "Blackjack Atlantic City" | 0,50 | 200,00 |
	| "Blackjack Atlantic City de varias manos" | 0,50 | 20,00 |
	| "Blackjack clásico" | 0,50 | 200,00 |
	Given "Stu" tiene en su depósito "1.000" euros. 


Scenario: Límite mínimo de apuestas
	When "Stu" apuesta "0,49" euros al cualquier juego de Blackjack
	Then La apuesta es "Rechazada"

	
Scenario Outline: Límite máximo de apuestas
	When "Stu" apuesta <apuesta> euros al juego <juego>
	Then La apuesta es <resultado>

Examples:
    | juego | apuesta | resultado | 
    | "Blackjack Atlantic City" | 200,01 | Rechazada |
	| "Blackjack Atlantic City de varias manos" | 20 | Aceptada |
	| "Blackjack Atlantic City de varias manos" | 21 | Rechazada |
	| "Blackjack clásico" | 200,00 | Aceptada |
	| "Blackjack clásico" | 200,01 | Rechazada |

	
Scenario: Ganar una mano
	Given "Stu" apuesta 100 euros a una mano de "Blackjack clásico"
	When "Stu" gana la mano.
	Then "Stu" gana 100 euros
	And El saldo de "Bob" es de 1100 euros.


Scenario: Ganar apuesta por Blackjack
	Given "Stu" apuesta 100 euros a una mano de "Blackjack clásico"
	When "Stu" gana la mano con Blackjack.
	Then "Stu" gana 150 euros
	And El saldo de "Bob" es de 1150 euros.

	
Scenario: Perder apuesta
	Given "Stu" apuesta 100 euros a una mano de "Blackjack clásico"
	When "Stu" pierde la mano
	Then El saldo de "Bob" es de 900 euros.
