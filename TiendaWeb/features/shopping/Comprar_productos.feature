Feature: Comprar productos
	As visitante
	I want to to elegir productos
	In order to a�adirlos al mi carrito de compra

Background:
	Given la tienda Dracotienda
	
Scenario: compro producto con el carrito vac�o
	Given mi carrito vac�o
	And el producto "Smash Up: Lindo y primoroso"
	When compro el producto "Smash Up: Lindo y primoroso" a mi carrito
	Then mi carrito incluye una copia
	And el total de mi carrito es "17,95" euros

Scenario: compro m�s de una copia
	Given mi carrito vac�o
	When compro el producto "Smash Up: Lindo y primoroso" a mi carrito
	And compro el producto "Smash Up: Lindo y primoroso" a mi carrito
	Then mi carrito incluye "dos" copias de "Smash Up: Lindo y primoroso"
	And el total de mi carrito es "35.90" euros
