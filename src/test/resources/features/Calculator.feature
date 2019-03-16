Feature: Calculator Feature

	Scenario Outline: Add two numbers
		Given User opened Calculator app
		When User adds <number1> and <number2>
		Then User receives result equal to <result>
		Examples:
		|number1|number2|result|
		|1		|1		|2	   |
		
	Scenario Outline: Multiply two numbers
		Given User opened Calculator app
		When User multiplies <number1> and <number2>
		Then User receives result equal to <result>
		Examples:
		|number1|number2|result|
		|1		|1		|1	   |
		
	Scenario Outline: Divide two numbers
		Given User opened Calculator app
		When User divides <number1> and <number2>
		Then User receives result equal to <result>
		Examples:
		|number1|number2|result|
		|1		|1		|1	   |
		
	Scenario Outline: Divide number by 0
		Given User opened Calculator app
		When User divides <number1> and 0
		Then User receives <error>
		Examples:
		|number1|error 			  |
		|1		|Can't divide by 0|
