Feature: Bono para nuevos jugadores
	As administrador del casino
	I want ofrecer un bono a los nuevos jugadores
	In order to fidelizarlos

	Criterios de aceptación:
		El bono es de 100 euros
		El bono solo se añade al hacer primer depósito de 10 euros o más
 
		
Background:
	Given "Bob" es un nuevo jugador
	And "Bob" tiene en su depósito "0" euros.

# Los siguientes escenarios podrían definirse como tabla.
	
Scenario: Bono de nuevo jugador no está dispoible sin un primer depósito
	When "Bob" comprueba su saldo
	Then El depósito de "Bob" contiene "0" euros.

Scenario: Aplicar el bono de nuevo jugador con el primer depósito
	When "Bob" realiza un depósito de "10" euros
	Then El bono de nuevos jugadores se añade al saldo de "Bob"
	And El depósito de "Bob" contiene "110" euros.
	
Scenario: Depósito insuficiente para el bono de nuevo jugador
	When "Bob" realiza un depósito de "9" euros
	Then El depósito de "Bob" contiene "9" euros.
	
Scenario: Al hacer un nuevo depósito después del primero no se añade el bono de nuevo jugador
	Given "Bob" ya ha hecho un depósito de "10" euros.
	And "Bob" tiene en su depósito "110" euros.
	When "Bob" realiza un depósito de "10" euros.
	Then El depósito de "Bob" contiene "120" euros.
	
Scenario: El bono de nuevo jugador no se concede por la suma de depósitos
	When "Bob" realiza un depósito de "5" euros.
	And "Bob" realiza un depósito de "5" euros.
	Then El saldo de "Bob" es de "10" euros.
	