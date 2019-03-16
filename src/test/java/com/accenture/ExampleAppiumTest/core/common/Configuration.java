package com.accenture.ExampleAppiumTest.core.common;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class Configuration {

    private Config conf;

    public Configuration() {
        conf = ConfigFactory.load("configuration/test.conf");
    }

    public String appiumServerUrl() {
        return conf.getString("appium.serverUrl");
    }
    
    public String deviceName() {
    	return conf.getString("appium.device.deviceName");
    }
    
    public String platformName() {
    	return conf.getString("appium.device.platformName");
    }
}
