package com.accenture.ExampleAppiumTest.core.device;

public class Application {
	
	private String appPackage;
	private String appActivity;
	
	public String getAppPackage() {
		return appPackage;
	}
	public Application setAppPackage(String appPackage) {
		this.appPackage = appPackage;
		return this;
	}
	public String getAppActivity() {
		return appActivity;
	}
	public Application setAppActivity(String appActivity) {
		this.appActivity = appActivity;
		return this;
	}
}
