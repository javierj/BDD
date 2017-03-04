Feature: tags in scenarios.

@BuildA
Scenario: run during buildA
	Then A scenario was executed
	
@BuildB
Scenario: run during buildB
	Then B scenario was executed
 
@BuildA, @BuildB
Scenario: run always
	Then A scenario was executed
	Then B scenario was executed
	