Feature: Canjear puntos plus
	As jugador del casino
	I want canjear puntos plus 
	In order to obtener más saldo para apostar
	
	Criterios de aceptación:
		No se pueden canjear menos de 5.000 puntos plus.
		
Scenario: Canjear puntos plus
	Given "Stu" tiene "5.000" puntos plus.
	And "Stu" tiene "0" euros en la cuenta de bonos
	When "Stu" canjea puntos plus por créditos.
	Then Los puntos plus de "Stu" son "0"
	And La cuenta de bonos de "Stu" contiene "10" euros.

Scenario: Puntos plus sobrantes
	Given "Stu" tiene "6.000" puntos plus.
	And "Stu" tiene "0" euros en la cuenta de bonos
	When "Stu" canjea puntos plus por créditos.
	Then Los puntos plus de "Stu" son "1.000"
	And La cuenta de bonos de "Stu" contiene "10" euros.
