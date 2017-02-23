Feature: Comprar productos
	As visitante
	I want to to elegir productos
	In order to añadirlos al mi carrito de compra

Background:
	Given la tienda Dracotienda
	
Scenario: compro producto con el carrito vacío
	Given mi carrito vacío
	And el producto "Smash Up: Lindo y primoroso"
	When compro el producto "Smash Up: Lindo y primoroso" a mi carrito
	Then mi carrito incluye una copia
	And el total de mi carrito es "17,95" euros

Scenario: compro más de una copia
	Given mi carrito vacío
	When compro el producto "Smash Up: Lindo y primoroso" a mi carrito
	And compro el producto "Smash Up: Lindo y primoroso" a mi carrito
	Then mi carrito incluye "dos" copias de "Smash Up: Lindo y primoroso"
	And el total de mi carrito es "35.90" euros
