package com.accenture.ExampleAppiumTest.core.common;

import com.accenture.ExampleAppiumTest.core.device.Application;
import com.accenture.ExampleAppiumTest.core.device.Device;

public class BaseScreen {
	
	protected Device device;

	public BaseScreen(Device device) {
		this.device = device;
	}

	public void open(Application application) {
		device.open(application);
	}
}
