package stepDefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class dataTableDemo {
	WebDriver driver;
	String ExpectedText="Hello vasuvespag!";
	@Given("I am on Hotel App Login page")
	public void i_am_on_hotel_app_login_page() {
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://adactinhotelapp.com/" );
	}

	/*
	 * @When("I enter credentials to login") public void
	 * i_enter_credentials_to_login(DataTable dataTable) { // Write code here that
	 * turns the phrase above into concrete actions // For automatic transformation,
	 * change DataTable to one of // E, List<E>, List<List<E>>, List<Map<K,V>>,
	 * Map<K,V> or // Map<K, List<V>>. E,K,V must be a String, Integer, Float, //
	 * Double, Byte, Short, Long, BigInteger or BigDecimal. // // For other
	 * transformations you can register a DataTableType. //throw new
	 * io.cucumber.java.PendingException(); List<List<String>>
	 * data=dataTable.cells();
	 * driver.findElement(By.id("username")).sendKeys(data.get(0).get(0));
	 * driver.findElement(By.id("password")).sendKeys(data.get(0).get(1)); }
	 */
	@When("I enter credentials to login")
	public void i_enter_credentials_to_login(DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	   // throw new io.cucumber.java.PendingException();
		for(Map<String,String>data:dataTable.asMaps(String.class,String.class)) {
			  driver.findElement(By.id("username")).sendKeys(data.get("username"));
			  driver.findElement(By.id("password")).sendKeys(data.get("password"));
			  driver.findElement(By.id("login")).click();
			   driver.get("https://adactinhotelapp.com/");
			  
		}

			
		}




	@Then("I am loged in successfully")
	public void i_am_loged_in_successfully() {

		
		WebElement e1=driver.findElement(By.id("username_show"));
		 String greeting=e1.getAttribute("value"); Assert.assertEquals(greeting, ExpectedText);
		 
	}
	System.out.println(enter username"+priyanka+");

	@Before
	   public void Login() {
		   driver=new ChromeDriver();
		   driver.get("https://adactinhotelapp.com/");
	   }
	   @After
	   public void exit() {
		  driver.quit();
	   }



}
