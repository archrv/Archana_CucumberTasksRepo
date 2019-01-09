package org.cucumbertasks.telecom;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddCustomer {
	static WebDriver driver;
	static List <WebElement> tRows, tData;
	@Given("the user navigates to Add Customer page")
	public void the_user_navigates_to_Add_Customer_page() {
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\ARCHANA\\ArchNewWorkspace\\CucumberSel2\\driver\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("http://demo.guru99.com/telecom/");
	    driver.findElement(By.xpath("//a[text()='Add Customer'][1]")).click();	    
	}
	
	@When("the user fills in customer details")
	public void the_user_fills_in_customer_details() {
	    driver.findElement(By.xpath("//label[text()='Done']")).click();
	    driver.findElement(By.id("fname")).sendKeys("Steve");
	    driver.findElement(By.id("lname")).sendKeys("Jobs");
	    driver.findElement(By.id("email")).sendKeys("stevejobstest123@gmail.com");
	    driver.findElement(By.name("addr")).sendKeys("Hello testing this project");
	    driver.findElement(By.id("telephoneno")).sendKeys("9990001112223");	    
	}

	@When("clicks on Submit button")
	public void clicks_on_Submit_button() {
		driver.findElement(By.name("submit")).click();
	}

	@Then("the user navigates to Access Details page with a success message")
	public void the_user_navigates_to_Access_Details_page_with_a_success_message() {
	    String actualMsg = driver.findElement(By.xpath("//section[@id='main']//header[@class='align-center']//h1")).getText();
	    Assert.assertEquals("Access Details to Guru99 Telecom", actualMsg);
	}

	@Then("the user will obtain a customer id")
	public void the_user_will_obtain_a_customer_id() {
	    tRows = driver.findElements(By.tagName("tr"));
	    tData = tRows.get(0).findElements(By.tagName("td"));
	    System.out.println("Customer ID generated: "+ tData.get(1).getText());	
	}
}
