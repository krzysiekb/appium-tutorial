package com.accenture.ExampleAppiumTest.runner;

import com.accenture.ExampleAppiumTest.core.device.Device;

import cucumber.api.java.After;

public class DeviceCleanup {

	private Device device;

	public DeviceCleanup(Device device) {
		this.device = device;
	}
	
	@After
	public void cleanupDevice() {
		device.getDriver().quit();
	}
}
