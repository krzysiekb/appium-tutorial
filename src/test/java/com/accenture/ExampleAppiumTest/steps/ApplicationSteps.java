package com.accenture.ExampleAppiumTest.steps;

import com.accenture.ExampleAppiumTest.core.common.BaseStep;
import com.accenture.ExampleAppiumTest.core.common.World;
import com.accenture.ExampleAppiumTest.core.device.Application;
import com.accenture.ExampleAppiumTest.core.device.Device;

import cucumber.api.java.en.Given;

public class ApplicationSteps extends BaseStep {
	
	private Device device;

	public ApplicationSteps(World world, Device device) {
		super(world);
		this.device = device;
	}

	@Given("^User opened (.+) app$")
	public void openApplication(String applicationName) {
		Application application = getApplication(applicationName);
		device.open(application);
	}

	private Application getApplication(String applicationName) {
		if(applicationName.equalsIgnoreCase("Calculator")) {
			return new Application()
					.setAppPackage("com.android.calculator2")
					.setAppActivity("com.android.calculator2.Calculator");
		}
		throw new RuntimeException("Unknown application: " + applicationName);		
	}
}
