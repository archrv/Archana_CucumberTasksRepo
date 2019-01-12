package org.paymentgateway;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith (Cucumber.class)
@CucumberOptions (features = "src\\test\\resources\\Feature\\PaymentGatewayCreditCheck",
					tags = {"@paymentsuccess", "@creditcheck"},
					glue = {"org.paymentgateway"},
					plugin = {"html:target"})

public class Testrunner {

}
