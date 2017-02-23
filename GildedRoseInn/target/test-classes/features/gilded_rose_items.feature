Feature: Actualización diaraia d eproductos

As Alison la amigable posadera
I want que los productos se actualicen cada día
In order to conocer qué productos ya no tienen calidad para la venta

Scenario: Actualización calidad "Aged Brie"
	Given "Aged Brie" con una calidad de 30
	And una fecha de venta de 10 dias
	When transcurre un dia
	Then La calidad es de 31
	And la fecha de ventas es de 9 dias
	

Scenario: Calidad limite "Aged Brie"
	Given "Aged Brie" con una calidad de 50
	And una fecha de venta de 10 dias
	When transcurre un dia
	Then La calidad sigue siendo 50
	But la fecha de ventas es de 9 dias
	
# Implementamos una tabla

Scenario Outline: eating
	Given <item> con una calidad de <calidad_inicial>
	And una fecha de venta de <fecha_venta_inicial> dias
	When transcurre un dia
	Then La calidad es de <calidad_final>
	And la fecha de ventas es de <fecha_venta_final> dias

Examples:
    | item | calidad_inicial | fecha_venta_inicial | calidad_final | fecha_venta_final |
    | "Aged Brie" | 30 | 10 | 31 | 9 |
    | "Aged Brie" | 50 | 10 | 50 | 9 |
    
 # A pesar del outline, estos escenarios tienen valor
 # Si quieres probarlo con TODOS los objetos lo haces en la implementación, no en el escenario.
 Scenario: La calidad no puede bajar de cero
 	Given cualquier item con calidad 0
 	When transcurre un dia
 	Then La calidad sigue siendo 0
 	
 # Y lo mismo para la fecha de venta
 
	
#

Scenario: actualización producto normal
	Given "Producto normal" con una calidad de 20
	And una fecha de venta de 10 dias
	When transcurre un dia
	Then La calidad es de 19
	
