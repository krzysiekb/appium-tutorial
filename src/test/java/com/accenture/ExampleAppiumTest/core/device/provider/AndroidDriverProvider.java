package com.accenture.ExampleAppiumTest.core.device.provider;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.accenture.ExampleAppiumTest.core.common.Configuration;
import com.accenture.ExampleAppiumTest.core.device.Application;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class AndroidDriverProvider implements DriverProvider {

	private Configuration configuration;
	
	public AndroidDriverProvider(Configuration configuration) {
		this.configuration = configuration; 
	}
	
	@Override
	public AppiumDriver getDriver(Application application) {
		DesiredCapabilities capabilities = getCapabilities(application);
		return createAndroidDriver(capabilities);
	}

	private DesiredCapabilities getCapabilities(Application application) {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("deviceName", configuration.deviceName());
		capabilities.setCapability("platformName", configuration.platformName());
		capabilities.setCapability("appPackage", application.getAppPackage());
		capabilities.setCapability("appActivity", application.getAppActivity());
		
		return capabilities;
	}

	private AndroidDriver createAndroidDriver(DesiredCapabilities capabilities) {
		try {
			return new AndroidDriver(new URL(configuration.appiumServerUrl()), capabilities);
		} catch (MalformedURLException e) {
			throw new RuntimeException("Error creating Android Driver.", e);
		}
	}

}
