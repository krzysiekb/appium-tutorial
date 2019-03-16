package com.accenture.ExampleAppiumTest.core.device;

import com.accenture.ExampleAppiumTest.core.common.Configuration;
import com.accenture.ExampleAppiumTest.core.device.provider.AndroidDriverProvider;

import io.appium.java_client.AppiumDriver;

public class Device {
	
	private Configuration configuration;
	
	private AppiumDriver driver;

	public Device(Configuration configuration) {
		this.configuration = configuration;
	}
	
	public void open(Application application) {
		createAppiumDriver(application);
	}

	private void createAppiumDriver(Application application) {
		if(configuration.platformName().equalsIgnoreCase("Android")) {
			driver = new AndroidDriverProvider(configuration).getDriver(application);
		} else {
			throw new RuntimeException("Unknown platform name: " + configuration.platformName());
		}
	}
	
	public AppiumDriver getDriver() {
		return driver;
	}
}
