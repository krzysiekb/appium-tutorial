package com.accenture.ExampleAppiumTest.runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = { "classpath:features" },
		glue = { "com.accenture.ExampleAppiumTest.steps" },
		plugin = { "pretty" }
)
public class TestRunner { }
