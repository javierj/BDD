Feature: Bono para nuevos jugadores
	As administrador del casino
	I want ofrecer un bono a los nuevos jugadores
	In order to fidelizarlos

	Criterios de aceptaci�n:
		El bono es de 100 euros
		El bono solo se a�ade al hacer primer dep�sito de 10 euros o m�s
 
		
Background:
	Given "Bob" es un nuevo jugador
	And "Bob" tiene en su dep�sito "0" euros.

# Los siguientes escenarios podr�an definirse como tabla.
	
Scenario: Bono de nuevo jugador no est� dispoible sin un primer dep�sito
	When "Bob" comprueba su saldo
	Then El dep�sito de "Bob" contiene "0" euros.

Scenario: Aplicar el bono de nuevo jugador con el primer dep�sito
	When "Bob" realiza un dep�sito de "10" euros
	Then El bono de nuevos jugadores se a�ade al saldo de "Bob"
	And El dep�sito de "Bob" contiene "110" euros.
	
Scenario: Dep�sito insuficiente para el bono de nuevo jugador
	When "Bob" realiza un dep�sito de "9" euros
	Then El dep�sito de "Bob" contiene "9" euros.
	
Scenario: Al hacer un nuevo dep�sito despu�s del primero no se a�ade el bono de nuevo jugador
	Given "Bob" ya ha hecho un dep�sito de "10" euros.
	And "Bob" tiene en su dep�sito "110" euros.
	When "Bob" realiza un dep�sito de "10" euros.
	Then El dep�sito de "Bob" contiene "120" euros.
	
Scenario: El bono de nuevo jugador no se concede por la suma de dep�sitos
	When "Bob" realiza un dep�sito de "5" euros.
	And "Bob" realiza un dep�sito de "5" euros.
	Then El saldo de "Bob" es de "10" euros.
	