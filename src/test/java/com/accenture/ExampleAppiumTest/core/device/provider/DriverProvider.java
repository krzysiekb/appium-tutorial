package com.accenture.ExampleAppiumTest.core.device.provider;

import com.accenture.ExampleAppiumTest.core.device.Application;

import io.appium.java_client.AppiumDriver;

public interface DriverProvider {
	AppiumDriver getDriver(Application application);
}
