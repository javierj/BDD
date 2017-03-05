Feature: Hello Cucumber
	As a cucumber student
	I want a hello world scenario 
	In order to learn the basics of cucumber
	
Scenario: Saludate
	Given A student called "Bob"
	When Bob says hello to Cucumber
	Then Cucumber answers "Hello Bob" 
	
Scenario: Introduction
	Given A student called "Bob"
	When Bob asks Cucumber to introduce itself
	Then Cucumber answers 
		""""
		Ok Bob, let's go.
		I'm a library for automating scenario validation.
		And I'm a vegetable too !!
		"""
		
	