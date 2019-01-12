package org.addcustomerfunctionality;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class AddCustUsingListofMaps {
	static WebDriver driver;
	
	@Given("User navigates to Add Customer page")
	public void user_navigates_to_Add_Customer_page() {
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\ARCHANA\\ArchNewWorkspace\\MyGitFolder\\AddCustomerTask\\driver\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("http://demo.guru99.com/telecom/addcustomer.php");
	}

	@When("User enters customer details")
	public void user_enters_customer_details(DataTable custDetails) {
	    List <Map <String, String>> custDetailsList = custDetails.asMaps(String.class, String.class);
	    driver.findElement(By.xpath("//label[text()='Done']")).click();
	    driver.findElement(By.id("fname")).sendKeys(custDetailsList.get(1).get("fname"));
		driver.findElement(By.id("lname")).sendKeys(custDetailsList.get(1).get("lname"));
		driver.findElement(By.id("email")).sendKeys(custDetailsList.get(1).get("email"));
		driver.findElement(By.name("addr")).sendKeys(custDetailsList.get(1).get("addres"));
		driver.findElement(By.name("telephoneno")).sendKeys(custDetailsList.get(1).get("phnum"));
		
	}

	@When("click on Submit button")
	public void click_on_Submit_button() {
	    driver.findElement(By.name("submit")).click();
	}

	@Then("user will navigate to access page with a customer id displayed")
	public void user_will_navigate_to_access_page_with_a_customer_id_displayed() {
	    List <WebElement> tRows = driver.findElements(By.tagName("tr"));
	    List <WebElement> tData = tRows.get(0).findElements(By.tagName("td"));
	    System.out.println("Customer ID generated is: " + tData.get(1).getText());	    
	    
	}

	@When("click on Reset button")
	public void click_on_Reset_button() {
	    driver.findElement(By.xpath("//input[@value='Reset']")).click();;
	}

	@Then("all fields get cleared and reset")
	public void all_fields_get_cleared_and_reset() {
		ArrayList <WebElement> verifyValues = new ArrayList<WebElement>();
		verifyValues.add(driver.findElement(By.id("fname")));
		verifyValues.add(driver.findElement(By.id("lname")));
		verifyValues.add(driver.findElement(By.id("email")));
		verifyValues.add(driver.findElement(By.name("addr")));
		verifyValues.add(driver.findElement(By.name("telephoneno")));
		for (WebElement v : verifyValues) {
			if (v.getAttribute("value").isEmpty())
					System.out.println("Field Reset");
		}
	
	}

}
