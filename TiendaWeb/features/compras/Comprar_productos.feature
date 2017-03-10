Feature: Comprar productos
	As visitante
	I want to poner productos en mi carrito
	In order to comprarlos en un futuro

Background:
	Given la tienda Dracotienda
	And mi carrito vacio
	
Scenario: pongo producto con el carrito vacío
	When pongo el producto "Smash Up: Lindo y primoroso" a mi carrito
	Then mi carrito incluye 1 copias de "Smash Up: Lindo y primoroso"
	And el total de mi carrito es "17.95" euros

Scenario: pongo más de una copia
	When pongo el producto "Smash Up: Lindo y primoroso" a mi carrito
	And pongo el producto "Smash Up: Lindo y primoroso" a mi carrito
	Then mi carrito incluye 2 copias de "Smash Up: Lindo y primoroso"
	And el total de mi carrito es "35.90" euros
