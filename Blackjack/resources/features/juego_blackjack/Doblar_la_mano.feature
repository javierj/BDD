Feature: Doblar la mano
	As jugador del casino
	I wanto to jugar más de una mano de manera simultánea
	In order to poder ganar más apuestas
	
	Criterios de aceptación:
		Un jugador debe poner una nueva apuesta en la nueva mano si dobla la mano.
		
	
Scenario: Doblar la mano inicial
	Given La mano inicial son dos cartas iguales
	When "Stu" dobla la mano
	Then "Stu" tiene dos manos más con una carta cada una
	And El croupier reparte una carta más a cada mano de "Stu"
	
	
Scenario: Apuesta al doblar la mano
	Given "Stu" ha apostado "10" euros.
	Given "Stu" ha doblado la mano
	When "Stu" apuesta "20" euros
	Then La "primera" mano tiene una apuesta de "10" euros
	And La "segunda" mano tiene una apuesta de "20" euros

# ¿Y si ponemos una tabla?
	
Scenario: Doblar mano doblada
	Given "Stu" ha doblado la mano
	And "Stu" tiene una mano con cartas duplicadas
	When "Stu" dobla la mano
	Then "Stu" tiene dos manos más con una carta cada una
	And El croupier reparte una carta más a cada mano de "Stu"
	
	