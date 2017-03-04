Feature: Retirada de fondos
	As jugador del casino
	I want retirar fondos de mi depósito
	In order to recibirlos en mi cuenta personal

Scenario: Retirada de fondos
	Given "Stu" tiene en su depósito "10" euros. 
	When "Stu" retira "10" euros de sus fondos
	Then El saldo de "Stu" es "0"
	And Se crea una nueva orden de transferencia para "Stu"

Scenario: Saldo insuficiente para retirar fondos
	Given "Stu" tiene en su depósito "10" euros. 
	When "Stu" retira "9" euros de sus fondos
	Then La retirada se cancela.
	And El depósito de "Stu" contiene "10" euros.
	
Scenario: No se puede retirar fondos del bono de nuevo jugador
	Given "Bob" tiene en su depósito "10" euros.
	And "Bob" tiene un bono de nuevo jugador de "100" euros.
	When "Bob" retira "11" euros de sus fondos
	Then La retirada se cancela.
	And El depósito de "Bob" contiene "110" euros.
	