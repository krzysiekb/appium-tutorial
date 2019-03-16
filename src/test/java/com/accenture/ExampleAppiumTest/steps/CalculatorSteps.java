package com.accenture.ExampleAppiumTest.steps;

import static org.junit.Assert.assertTrue;

import com.accenture.ExampleAppiumTest.core.common.BaseStep;
import com.accenture.ExampleAppiumTest.core.common.World;
import com.accenture.ExampleAppiumTest.screens.calculator.MainScreen;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CalculatorSteps extends BaseStep {
	
	private MainScreen mainScreen;
	
	public CalculatorSteps(World world, MainScreen mainScreen) {
		super(world);
		this.mainScreen = mainScreen;
	}

	@When("^User adds (.+) and (.+)$")
	public void addNumbers(double number1, double number2) {
		mainScreen.setNumber(number1);
		mainScreen.add();
		mainScreen.setNumber(number2);
	}
	
	@When("^User multiplies (.+) and (.+)$")
	public void multiplyNumbers(double number1, double number2) {
		mainScreen.setNumber(number1);
		mainScreen.multiply();
		mainScreen.setNumber(number2);
	}
	
	@When("^User divides (.+) and (.+)$")
	public void divideNumbers(double number1, double number2) {
		mainScreen.setNumber(number1);
		mainScreen.divide();
		mainScreen.setNumber(number2);
	}
	
	@Then("^User receives result equal to (.+)$")
	public void verifyResult(double resultToVerify) {
		mainScreen.execute();
		double result = mainScreen.getResult();
		assertTrue("Result is incorrect.", result == resultToVerify);
	}
	
	@Then("^User receives error (.+)$")
	public void verifyResultWithError(String errorToVerify) {
		mainScreen.execute();
		String error = mainScreen.getError();
		assertTrue("Error is incorrect.", error.equals(errorToVerify));
	}
}
