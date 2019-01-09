package org.cucumbertasks.telecom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddTariffPlans {

		static WebDriver driver;
			
		@Given("The user navigates to Add Tariff Plans page")
		public void the_user_navigates_to_Add_Tariff_Plans_page() {
		    System.setProperty("webdriver.chrome.driver", "C:\\Users\\ARCHANA\\ArchNewWorkspace\\CucumberSel2\\driver\\chromedriver.exe");
		    driver = new ChromeDriver();
		    driver.manage().window().maximize();
		    driver.get("http://demo.guru99.com/telecom/addtariffplans.php");
		}

		@When("the user fills in the plan details {string}, {string}, {string}, {string}, {string}, {string}, {string}")
		public void the_user_fills_in_the_plan_details(String monthlyrental, String freelocalmins, String freeinternationalmins, String freesmspack, String localpermincharg, String internationalpermincharg, String smscharg) {
		    driver.findElement(By.id("rental1")).sendKeys(monthlyrental);
		    driver.findElement(By.id("local_minutes")).sendKeys(freelocalmins);
		    driver.findElement(By.id("inter_minutes")).sendKeys(freeinternationalmins);
		    driver.findElement(By.id("sms_pack")).sendKeys(freesmspack);
		    driver.findElement(By.id("minutes_charges")).sendKeys(localpermincharg);
		    driver.findElement(By.id("inter_charges")).sendKeys(internationalpermincharg);
		    driver.findElement(By.id("sms_charges")).sendKeys(smscharg);
		}

		@When("the user clicks on Submit button")
		public void the_user_clicks_on_Submit_button() {
		    driver.findElement(By.name("submit")).click();
		}

		@Then("verify that a success message is displayed with customer id")
		public void verify_that_a_success_message_is_displayed_with_customer_id() {
		    String actual = driver.findElement(By.xpath("//div[@class='inner']//h2")).getText();
		    Assert.assertEquals("Congratulation you add Tariff Plan", actual);
		    
		}


	}

