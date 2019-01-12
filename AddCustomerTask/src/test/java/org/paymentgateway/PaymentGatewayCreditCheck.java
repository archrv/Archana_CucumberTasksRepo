package org.paymentgateway;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PaymentGatewayCreditCheck {
	static WebDriver driver;
	
	@Given("User navigates to payment gateway homepage")
	public void user_navigates_to_payment_gateway_homepage() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ARCHANA\\ArchNewWorkspace\\MyGitFolder\\AddCustomerTask\\driver\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("http://demo.guru99.com/payment-gateway/index.php");
	}

	@When("User clicks on Pay button")
	public void user_clicks_on_Pay_button() {
	    driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

	@When("enters credit card details as {string}, {string}, {string}, {string}")
	public void enters_credit_card_details_as(String cardno, String expirymonth, String expiryyear, String cvv) {
	    driver.findElement(By.id("card_nmuber")).sendKeys(cardno);
	    Select s1 = new Select (driver.findElement(By.id("month")));
	    s1.selectByVisibleText(expirymonth);
	    Select s2 = new Select (driver.findElement(By.id("year")));
	    s2.selectByVisibleText(expiryyear);
	    driver.findElement(By.id("cvv_code")).sendKeys(cvv);
	}

	@Then("User sees a success message with an Order id generated")
	public void user_sees_a_success_message_with_an_Order_id_generated() {
	    String actualMsg = driver.findElement(By.xpath("//section[@id='three']//div//div//h2")).getText();
	    Assert.assertEquals("Payment successfull!", actualMsg);
	    List <WebElement> tRows = driver.findElements(By.tagName("tr"));
	    List <WebElement> tData = tRows.get(0).findElements(By.tagName("td"));
	    System.out.println("Order ID generated is: " + tData.get(1).getText());
	}

	@When("clicks on Credit Check Limit button")
	public void clicks_on_Credit_Check_Limit_button() {
	    driver.findElement(By.xpath("(//a[text()='Check Credit Card Limit'])[1]")).click();
	    
	}

	@When("submits card number as {string}")
	public void submits_card_number_as(String ccardno) {
	    driver.findElement(By.name("card_nmuber")).sendKeys(ccardno);
	    driver.findElement(By.name("submit")).click();
	}

	@Then("User should see Credit Card Balance amount displayed")
	public void user_should_see_Credit_Card_Balance_amount_displayed() {
		System.out.println("Credit Balance is: "+ driver.findElement(By.xpath("//div//h4//span")).getText());
	}



}
