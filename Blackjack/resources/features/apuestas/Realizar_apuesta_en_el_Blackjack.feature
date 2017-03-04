Feature: Realizar apuesta en el Blackjack
	As jugador del casino
	I want apostar en el Blackjack
	In order to ganar saldo

Background:
	Given Las apuestas mínimas y máximas del Blackjack.
	| juego | apuesta_minima | apuesta-maxima |
	| "Blackjack Atlantic City" | 0,50 | 200,00 |
	| "Blackjack Atlantic City de varias manos" | 0,50 | 20,00 |
	| "Blackjack clásico " | 0,50 | 200,00 |
	
Scenario Outline: límite de apuestas
	Given "Stu" tiene en su depósito "1.000" euros. 
	When "Stu" apuesta <apuesta> euros al juego <juego>
	Then La apuesta es <resultado>

Examples:
    | juego | apuesta | resultado | 
    | "Blackjack Atlantic City" | 0,49 | Rechazada |
	| "Blackjack Atlantic City" | 0,50 | Aceptada |
	| "Blackjack Atlantic City de varias manos" | 20 | Aceptada |
	| "Blackjack Atlantic City de varias manos" | 21 | Rechazada |
	| "Blackjack Atlantic City de varias manos" | 200,00 | Aceptada |
	| "Blackjack Atlantic City de varias manos" | 200,01 | Rechazada |