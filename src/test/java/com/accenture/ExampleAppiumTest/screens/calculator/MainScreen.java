package com.accenture.ExampleAppiumTest.screens.calculator;

import org.openqa.selenium.By;

import com.accenture.ExampleAppiumTest.core.common.BaseScreen;
import com.accenture.ExampleAppiumTest.core.device.Device;

import io.appium.java_client.MobileBy;

public class MainScreen extends BaseScreen {

	// Digits [id]
	private String digitLocatorFormat = "com.android.calculator2:id/digit_%c";
	
	// Dot [accessibility id]
	private By pointLocator = MobileBy.AccessibilityId("point");
	
	// Equals [accessibility id]
	private By equalsLocator = MobileBy.AccessibilityId("equals");
	
	// Operations [accessibility id]
	private By plusLocator = MobileBy.AccessibilityId("plus");
	private By minusLocator = MobileBy.AccessibilityId("minus");
	private By multiplyLocator = MobileBy.AccessibilityId("multiply");
	private By divideLocator = MobileBy.AccessibilityId("divide");
	
	// Result [id]
	private By resultLocator = By.id("com.android.calculator2:id/result");
	
	public MainScreen(Device device) {
		super(device);
	}
	
	public void setNumber(double number) {
		String numberString = Double.toString(number);
		for(char c: numberString.toCharArray()) {
			By locator = getNumberLocator(c);
			device.getDriver().findElement(locator).click();
		}
	}
	
	public void add() {
		performOperation(plusLocator);
	}
	
	public void subtract() {
		performOperation(minusLocator);
	}
	
	public void multiply() {
		performOperation(multiplyLocator);
	}
	
	public void divide() {
		performOperation(divideLocator);
	}
	
	public double execute() {
		device.getDriver()
			.findElement(equalsLocator).click();
		return getResult();
	}

	public double getResult() {
		String resultString = 
				device.getDriver().findElement(resultLocator).getText();
		return Double.parseDouble(resultString);
	}
	
	private By getNumberLocator(char c) {
		// We are processing doubles, therefore it's possible to have .
		if(c == '.') {
			return pointLocator;
		}
		return By.id(String.format(digitLocatorFormat, c));
	}

	private void performOperation(By locator) {
		device.getDriver().findElement(locator).click();
	}
	
}
