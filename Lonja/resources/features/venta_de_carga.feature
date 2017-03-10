Feature: precios de venta
	As comprador en lonja
	I want to calcular los precios de venta de la compra en distintos mercados
	In order to descubrir el mayor beneficio


Scenario: Madrid no compra Vieiras
	Given una carga de 50 kilos de vieiras
	And un precio de 500 euros por kilo de vieiras en "Madrid"
	And una distancia hasta "Madrid" de 800 Km
	When vendo la carga en "Madrid"
	Then el beneficio es -1605